package com.gsu.cs4998.project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.gsu.cs4998.project.database.DatabaseHelper;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Snapshot extends AppCompatActivity {

    private String date;
    private TextView mTextViewDate;
    private DatabaseHelper mDatabaseHelper;

    // bath section
    private TextView textViewBathHour;
    private TextView textViewBathDate;
    private TextView textViewBathDiaper;
    private TextView textViewBathObservation;

    //liquid feed
    private TextView textViewLiquidName;
    private TextView textViewLiquidHour;
    private TextView textViewLiquidDay;
    private TextView textViewLiquidObservation;
    private TextView textViewLiquidQuantity;

    //solid feed
    private TextView textViewSolidName;
    private TextView textViewSolidHour;
    private TextView textViewSolidDay;
    private TextView textViewSolidObservation;

    //diaper
    private TextView textViewDiaperBrand;
    private TextView textViewDiaperDate;
    private TextView textViewDiaperHour;
    private TextView textViewDiaperPee;
    private TextView textViewDiaperPoop;
    private TextView textViewDiaperObservation;

    //sleep
    private TextView textViewSleepDate;
    private TextView textViewSleepHourFrom;
    private TextView textViewSleepHourTo;
    private TextView textViewSleepObservation;

    //medication
    private TextView textViewMedicineName;
    private TextView textViewMedicineQuantity;
    private TextView textViewMedicineSymptoms;
    private TextView textViewMedicineDate;
    private TextView textViewMedicineHour;
    private TextView textViewMedicineObservation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mTextViewDate = (TextView)findViewById(R.id.today_date);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
        Date date = new Date();
        mTextViewDate.setText(dateFormat.format(date));

        // begin bath section
        textViewBathHour = (TextView)findViewById(R.id.bath_hour);
        textViewBathDate = (TextView)findViewById(R.id.bath_date);
        textViewBathDiaper = (TextView)findViewById(R.id.bath_diaper);
        textViewBathObservation = (TextView)findViewById(R.id.bath_observation);
        textViewBathHour.setText(mDatabaseHelper.getLatestBath().getBathHour() + " : "+ mDatabaseHelper.getLatestBath().getBathMinute());
        textViewBathDate.setText(mDatabaseHelper.getLatestBath().getBathMonth() + " / " + mDatabaseHelper.getLatestBath().getBathDate());
        textViewBathDiaper.setText(mDatabaseHelper.getLatestBath().getDiaperBrand());
        textViewBathObservation.setText(mDatabaseHelper.getLatestBath().getObservation());
        // end bath section

        //begin liquid feed
        textViewLiquidDay = (TextView)findViewById(R.id.liquid_feed_date);
        textViewLiquidHour = (TextView)findViewById(R.id.liquid_feed_hour);
        textViewLiquidName = (TextView)findViewById(R.id.liquid_feed_name);
        textViewLiquidQuantity = (TextView)findViewById(R.id.liquid_feed_quantity);
        textViewLiquidObservation = (TextView)findViewById(R.id.liquid_feed_observation);
        textViewLiquidQuantity.setText(mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodQuantity() + " " +mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodMeasureType());
        textViewLiquidName.setText(mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodName());
        textViewLiquidDay.setText(mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodMonth() + " / " + mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodDay());
        textViewLiquidHour.setText(mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodHour() + " : " + mDatabaseHelper.getLatestLiquidFeed().getLiquidFoodMinute());
        textViewLiquidObservation.setText(mDatabaseHelper.getLatestLiquidFeed().getObservation());
        //end liquid feed

        //begin solid feed
        textViewSolidDay = (TextView)findViewById(R.id.solid_feed_date);
        textViewSolidHour = (TextView)findViewById(R.id.solid_feed_hour);
        textViewSolidName = (TextView)findViewById(R.id.solid_feed_name);
        textViewSolidObservation = (TextView)findViewById(R.id.solid_feed_observation);
        textViewSolidName.setText(mDatabaseHelper.getLatestSolidFeed().getSolidFoodName());
        textViewSolidDay.setText(mDatabaseHelper.getLatestSolidFeed().getSoliFoodMonth() + " / " + mDatabaseHelper.getLatestSolidFeed().getSolidFoodDay());
        textViewSolidHour.setText(mDatabaseHelper.getLatestSolidFeed().getSolidFoodHour() + " : " + mDatabaseHelper.getLatestSolidFeed().getSolidFoodMinute());
        textViewSolidObservation.setText(mDatabaseHelper.getLatestSolidFeed().getObservation());
        //end solid feed

        //begin diaper
        textViewDiaperBrand = (TextView)findViewById(R.id.diaper_brand);
        textViewDiaperDate = (TextView)findViewById(R.id.diaper_date);
        textViewDiaperHour = (TextView)findViewById(R.id.diaper_hour);
        textViewDiaperPee = (TextView)findViewById(R.id.diaper_pee);
        textViewDiaperPoop = (TextView)findViewById(R.id.diaper_poop);
        textViewDiaperObservation = (TextView)findViewById(R.id.diaper_observation);

        textViewDiaperBrand.setText(mDatabaseHelper.getLatestDaiper().getDiaperBrand());
        textViewDiaperDate.setText(mDatabaseHelper.getLatestDaiper().getDiaperMonth() + " / " + mDatabaseHelper.getLatestDaiper().getDiaperDate());
        textViewDiaperHour.setText(mDatabaseHelper.getLatestDaiper().getDiaperHour() + " : " +mDatabaseHelper.getLatestDaiper().getDiaperMinute());
        textViewDiaperPee.setText(mDatabaseHelper.getLatestDaiper().getDiaperForPee());
        textViewDiaperPoop.setText(mDatabaseHelper.getLatestDaiper().getDiaperForPoop());
        textViewDiaperObservation.setText(mDatabaseHelper.getLatestDaiper().getObservation());
        //end diaper

        //begin sleep
        textViewSleepDate = (TextView)findViewById(R.id.sleep_date);
        textViewSleepHourFrom = (TextView)findViewById(R.id.sleep_hour_from);
        textViewSleepHourTo = (TextView)findViewById(R.id.sleep_hour_to);
        textViewSleepObservation = (TextView)findViewById(R.id.sleep_observation);

        textViewSleepDate.setText(mDatabaseHelper.getLatestSleep().getSleepMonth() + " / " + mDatabaseHelper.getLatestSleep().getSleepDate());
        textViewSleepHourFrom.setText(mDatabaseHelper.getLatestSleep().getSleepHourFrom() + " : " +mDatabaseHelper.getLatestSleep().getSleepMinuteFrom());
        textViewSleepHourTo.setText(mDatabaseHelper.getLatestSleep().getSleepHourTo() + " : " + mDatabaseHelper.getLatestSleep().getSleepMinuteTo());
        textViewSleepObservation.setText(mDatabaseHelper.getLatestSleep().getObservation());

        //begin medicine
        textViewMedicineName = (TextView)findViewById(R.id.medicine_name);
        textViewMedicineQuantity = (TextView)findViewById(R.id.medicine_quantity);
        textViewMedicineDate = (TextView)findViewById(R.id.medicine_date);
        textViewMedicineHour = (TextView)findViewById(R.id.medicine_time);
        textViewMedicineSymptoms = (TextView)findViewById(R.id.medicine_symptoms);
        textViewMedicineObservation = (TextView)findViewById(R.id.medicine_observation);

        textViewMedicineName.setText(mDatabaseHelper.getLatestMedication().getMedicineName());
        textViewMedicineQuantity.setText(mDatabaseHelper.getLatestMedication().getMedicineQuantity() + " " +mDatabaseHelper.getLatestMedication().getMedicineQuantityMeasure());
        textViewMedicineSymptoms.setText(mDatabaseHelper.getLatestMedication().getSymptomsDescription());
        textViewMedicineDate.setText(mDatabaseHelper.getLatestMedication().getMedicineMonth() + " / " +mDatabaseHelper.getLatestMedication().getMedicineDate());
        textViewMedicineHour.setText(mDatabaseHelper.getLatestMedication().getMedicineHour() + " : " +mDatabaseHelper.getLatestMedication().getMedicineMinute());
        textViewMedicineObservation.setText(mDatabaseHelper.getLatestMedication().getObservation());
    }

}
