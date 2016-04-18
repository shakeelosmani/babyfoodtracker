package com.gsu.cs4998.project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;
import com.gsu.cs4998.project.model.Children;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddBaby extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatabaseHelper mDatabaseHelper;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    private Button button;
    private Spinner spinner;
    private String selectedGender;
    private Button saveButton;
    private String imageUri;
    private String name;
    private String birthDate;
    private String birthMonth;
    private String heightFeet;
    private String heightInch;
    private String weightLbs;
    private EditText nameEditText;
    private EditText birthDateEditText;
    private EditText birthMonthEditText;
    private EditText heightFeetEditText;
    private EditText heightInchEditText;
    private EditText weightEditText;

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_baby);

        this.imageView = (ImageView) findViewById(R.id.baby_pic);
        button = (Button) findViewById(R.id.take_image);
        spinner = (Spinner)findViewById(R.id.sex_spinner);
        saveButton = (Button)findViewById(R.id.button_save);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sex,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText = (EditText)findViewById(R.id.edit_text_baby_name);
                name = nameEditText.getText().toString();

                birthDateEditText = (EditText)findViewById(R.id.editText_date_dd);
                birthDate = birthDateEditText.getText().toString();

                birthMonthEditText = (EditText)findViewById(R.id.editText_date_mm);
                birthMonth = birthMonthEditText.getText().toString();

                heightFeetEditText = (EditText)findViewById(R.id.editText_feet);
                heightFeet = heightFeetEditText.getText().toString();

                heightInchEditText = (EditText)findViewById(R.id.editText_inch);
                heightInch = heightInchEditText.getText().toString();

                weightEditText = (EditText)findViewById(R.id.editTextWeight);
                weightLbs = weightEditText.getText().toString();
                if(name =="" || birthDate == "" || birthMonth == "" || heightFeet == "" || heightInch == "" || weightLbs == ""){
                    Toast.makeText(AddBaby.this,"All the fields are needed",Toast.LENGTH_LONG);
                }
                else{
                    if(imageUri == ""){ // the user is not saving an image
                        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                        Children child = new Children();
                        child.setName(name);
                        child.setBirthDate(birthDate);
                        child.setBirthMonth(birthMonth);
                        child.setHeightFeet(heightFeet);
                        child.setSex(selectedGender);
                        child.setHeightInch(heightInch);
                        child.setWeight(weightLbs);
                        long result = mDatabaseHelper.createBaby(child);

                        Toast.makeText(AddBaby.this,"The baby with ID " +result + " stored",Toast.LENGTH_LONG).show();
                    }
                    else{ // user is saving an image as well
                        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                        Children child = new Children();
                        child.setName(name);
                        child.setImagePath(imageUri);
                        child.setBirthDate(birthDate);
                        child.setBirthMonth(birthMonth);
                        child.setHeightFeet(heightFeet);
                        child.setSex(selectedGender);
                        child.setHeightInch(heightInch);
                        child.setWeight(weightLbs);
                        long result = mDatabaseHelper.createBaby(child);

                        Toast.makeText(AddBaby.this,"The baby with ID " +result + " stored",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);
                Uri tempUri = getImageUri(getApplicationContext(), photo);

                // CALL THIS METHOD TO GET THE ACTUAL PATH
                File finalFile = new File(getRealPathFromURI(tempUri));

                System.out.println(finalFile);
                imageUri = finalFile.getAbsolutePath();
            }
        }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selectedGender = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
