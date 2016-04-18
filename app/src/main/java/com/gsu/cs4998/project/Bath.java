package com.gsu.cs4998.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;
import com.gsu.cs4998.project.model.BathSchedule;

public class Bath extends AppCompatActivity {

    private Button saveButton;
    private String day;
    private String month;
    private String hour;
    private String minute;
    private String diaperBrand;
    private String observation;

    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bath);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hour = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minute = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                diaperBrand = ((EditText)findViewById(R.id.editText_diaper_brand)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                BathSchedule bathSchedule = new BathSchedule();
                bathSchedule.setBathDate(day);
                bathSchedule.setBathMonth(month);
                bathSchedule.setBathHour(hour);
                bathSchedule.setBathMinute(minute);
                bathSchedule.setDiaperBrand(diaperBrand);
                bathSchedule.setObservation(observation);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveBath(bathSchedule);

                Toast.makeText(Bath.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}