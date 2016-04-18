package com.gsu.cs4998.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;

public class SolidFood extends AppCompatActivity {

    private Button saveButton;
    private String foodName;
    private String day;
    private String month;
    private String hour;
    private String minute;
    private String observation;

    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solid_food);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foodName = ((EditText)findViewById(R.id.editText3)).getText().toString();
                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hour = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minute = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                com.gsu.cs4998.project.model.SolidFood solidFood = new com.gsu.cs4998.project.model.SolidFood();
                solidFood.setSolidFoodName(foodName);
                solidFood.setSolidFoodDay(day);
                solidFood.setSoliFoodMonth(month);
                solidFood.setSolidFoodHour(hour);
                solidFood.setSolidFoodMinute(minute);
                solidFood.setObservation(observation);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveSolidFood(solidFood);

                Toast.makeText(SolidFood.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}