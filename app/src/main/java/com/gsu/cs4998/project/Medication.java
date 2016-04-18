package com.gsu.cs4998.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;

public class Medication extends AppCompatActivity {

    private Button saveButton;
    private String medicationName;
    private String quantity;
    private String measureUnit;
    private String symptoms;
    private String day;
    private String month;
    private String hour;
    private String minute;
    private String observation;

    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medication);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                medicationName = ((EditText)findViewById(R.id.editText6)).getText().toString();
                quantity = ((EditText)findViewById(R.id.editText5)).getText().toString();
                symptoms = ((EditText)findViewById(R.id.editText_sym_desc)).getText().toString();
                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hour = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minute = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                RadioGroup rg = (RadioGroup)findViewById(R.id.unit_radio_group);
                measureUnit = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                com.gsu.cs4998.project.model.Medication medication = new com.gsu.cs4998.project.model.Medication();
                medication.setMedicineName(medicationName);
                medication.setMedicineQuantity(quantity);
                medication.setSymptomsDescription(symptoms);
                medication.setMedicineDate(day);
                medication.setMedicineMonth(month);
                medication.setMedicineHour(hour);
                medication.setMedicineMinute(minute);
                medication.setObservation(observation);
                medication.setMedicineQuantityMeasure(measureUnit);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveMedication(medication);

                Toast.makeText(Medication.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}