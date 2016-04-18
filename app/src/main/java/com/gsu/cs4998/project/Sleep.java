package com.gsu.cs4998.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;

public class Sleep extends AppCompatActivity {

    private Button saveButton;
    private String day;
    private String month;
    private String hourFrom;
    private String minuteFrom;
    private String hourTo;
    private String minuteTo;
    private String observation;

    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hourFrom = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minuteFrom = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                hourTo = ((EditText)findViewById(R.id.editText_hour_hh2)).getText().toString();
                minuteTo = ((EditText)findViewById(R.id.editText_hour_mm2)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                com.gsu.cs4998.project.model.Sleep sleep = new com.gsu.cs4998.project.model.Sleep();
                sleep.setSleepDate(day);
                sleep.setSleepMonth(month);
                sleep.setSleepHourFrom(hourFrom);
                sleep.setSleepMinuteFrom(minuteFrom);
                sleep.setSleepHourTo(hourTo);
                sleep.setSleepMinuteTo(minuteTo);
                sleep.setObservation(observation);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveSleep(sleep);

                Toast.makeText(Sleep.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }


}