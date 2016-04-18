package com.gsu.cs4998.project;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddAlarm extends AppCompatActivity {

    private Switch switchButton;
    private Date time;
    private List<Integer> days;
    private Button saveButton;
    private Boolean repeat;
    private TimePicker timePicker;
    private EditText editTextMessage;
    private String message;
    private CheckBox sunday;
    private CheckBox monday;
    private CheckBox tuesday;
    private CheckBox wednesday;
    private CheckBox thursday;
    private CheckBox friday;
    private CheckBox saturday;
    Calendar calNow;
    Calendar calSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);

        saveButton = (Button)findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchButton = (Switch)findViewById(R.id.switch_repeat);
                timePicker = (TimePicker)findViewById(R.id.timePicker);
                editTextMessage = (EditText)findViewById(R.id.editText_label);
                sunday = (CheckBox)findViewById(R.id.checkBox_sunday);
                monday = (CheckBox)findViewById(R.id.checkBox_monday);
                tuesday = (CheckBox)findViewById(R.id.checkBox_tuesday);
                wednesday = (CheckBox)findViewById(R.id.checkBox_wednessday);
                thursday = (CheckBox)findViewById(R.id.checkBox_thursday);
                friday = (CheckBox)findViewById(R.id.checkBox_friday);
                saturday = (CheckBox)findViewById(R.id.checkBox_satuday);

                message = editTextMessage.getText().toString();
                days = new ArrayList<Integer>();

                if(sunday.isChecked()){
                    days.add(1);
                }
                if(monday.isChecked()){
                    days.add(2);
                }
                if(tuesday.isChecked()){
                    days.add(3);
                }
                if(wednesday.isChecked()){
                    days.add(4);
                }
                if(thursday.isChecked()){
                    days.add(5);
                }
                if(friday.isChecked()){
                    days.add(6);
                }
                if(saturday.isChecked()){
                    days.add(7);
                }

                if(switchButton.isChecked()){
                    repeat = true;
                }
                else{
                    repeat = false;
                }
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent alarmIntent = new Intent(AddAlarm.this,AlarmReceiver.class);
                alarmIntent.putExtra("AlarmMessage",message);
                PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(AddAlarm.this,111,alarmIntent,PendingIntent.FLAG_ONE_SHOT);
                for(int i =0; i < days.size(); i++){
                    calNow = Calendar.getInstance();
                    calSet = (Calendar) calNow.clone();

                    int day = calSet.get(Calendar.DAY_OF_WEEK);  //current day...for example.13 dec 2014 - sat  so, day = 7

                    calSet.set(Calendar.DAY_OF_WEEK, days.get(i));
                    calSet.set(Calendar.HOUR_OF_DAY, hour);
                    calSet.set(Calendar.MINUTE, minute);
                    calSet.set(Calendar.SECOND, 0);
                    calSet.set(Calendar.MILLISECOND, 0);
                }

                if(repeat){
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), (DateUtils.DAY_IN_MILLIS)*7, alarmPendingIntent);
                }
                else{
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calSet.getTimeInMillis(),alarmPendingIntent);
                }

            }
        });




    }
}