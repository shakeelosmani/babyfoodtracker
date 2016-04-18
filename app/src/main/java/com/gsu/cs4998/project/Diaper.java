package com.gsu.cs4998.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;

public class Diaper extends AppCompatActivity {

    private Button saveButton;
    private CheckBox poopBox;
    private CheckBox peeBox;
    private String poop;
    private String pee;
    private String day;
    private String month;
    private String hour;
    private String minute;
    private String brand;
    private String observation;

    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaper);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                poopBox = (CheckBox)findViewById(R.id.checkBox_poop);
                peeBox = (CheckBox)findViewById(R.id.checkBox_pee);

                if (poopBox.isChecked()) {
                    poop = "Yes";
                }else {
                    poop = "No";
                }

                if (peeBox.isChecked()){
                    pee = "Yes";
                }else{
                    pee = "No";
                }

                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hour = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minute = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                brand = ((EditText)findViewById(R.id.editText_diaper_brand)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                com.gsu.cs4998.project.model.Diaper diaper = new com.gsu.cs4998.project.model.Diaper();

                diaper.setDiaperForPoop(poop);
                diaper.setDiaperForPee(pee);
                diaper.setDiaperDate(day);
                diaper.setDiaperMonth(month);
                diaper.setDiaperHour(hour);
                diaper.setDiaperMinute(minute);
                diaper.setDiaperBrand(brand);
                diaper.setObservation(observation);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveDiaper(diaper);

                Toast.makeText(Diaper.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();


            }
        });
    }
}