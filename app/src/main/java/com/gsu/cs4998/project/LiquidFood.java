package com.gsu.cs4998.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gsu.cs4998.project.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class LiquidFood extends AppCompatActivity {

    private Button saveButton;
    private String measureUnit;
    private String foodName;
    private String quantity;
    private String day;
    private String month;
    private String hour;
    private String minute;
    private String observation;

    private DatabaseHelper mDatabaseHelper;
    private DatabaseHelper mDatabaseReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liquid_food);

        saveButton = (Button)findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foodName = ((EditText)findViewById(R.id.editText3)).getText().toString();
                quantity = ((EditText)findViewById(R.id.editText5)).getText().toString();
                day = ((EditText)findViewById(R.id.editText_date_dd)).getText().toString();
                month = ((EditText)findViewById(R.id.editText_date_mm)).getText().toString();
                hour = ((EditText)findViewById(R.id.editText_hour_hh)).getText().toString();
                minute = ((EditText)findViewById(R.id.editText_hour_mm)).getText().toString();
                observation = ((EditText)findViewById(R.id.editText_obs)).getText().toString();

                RadioGroup rg = (RadioGroup)findViewById(R.id.unit_radio_group);
                measureUnit = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                com.gsu.cs4998.project.model.LiquidFood liquidFood = new com.gsu.cs4998.project.model.LiquidFood();
                liquidFood.setLiquidFoodName(foodName);
                liquidFood.setLiquidFoodDay(day);
                liquidFood.setLiquidFoodMonth(month);
                liquidFood.setLiquidFoodMinute(minute);
                liquidFood.setLiquidFoodHour(hour);
                liquidFood.setLiquidFoodMeasureType(measureUnit);
                liquidFood.setObservation(observation);
                liquidFood.setLiquidFoodQuantity(quantity);

                mDatabaseHelper = new DatabaseHelper(getApplicationContext());
                Long saveId = mDatabaseHelper.saveLiquidFood(liquidFood);

                Toast.makeText(LiquidFood.this, "The Entry with ID " + saveId + " inserted", Toast.LENGTH_SHORT).show();

            }

        });

        List<com.gsu.cs4998.project.model.LiquidFood> mLiquidFood = new ArrayList<com.gsu.cs4998.project.model.LiquidFood>();
        mDatabaseReader = new DatabaseHelper(getApplicationContext());
        mLiquidFood = mDatabaseReader.getAllLiquidFood();
        for(int i = 0; i < mLiquidFood.size(); i++) {
            System.out.println(mLiquidFood.get(i).getLiquidFoodName() + " " + mLiquidFood.get(i).getLiquidFoodMonth());
        }
    }
}