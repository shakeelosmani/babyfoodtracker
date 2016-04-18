package com.gsu.cs4998.project.model;

import android.content.Intent;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class BathSchedule {

    private Integer id;

    private  String bathDate;

    private  String bathMonth;

    private String bathHour;

    private String bathMinute;

    private String diaperBrand;

    private String observation;

    public BathSchedule(){
        //no args constructor;
    }

    // constructor without Id
    public BathSchedule(String bathDate, String bathMonth, String bathHour, String bathMinute, String diaperBrand, String observation){
        this.bathDate = bathDate;
        this.bathHour = bathHour;
        this.bathMinute = bathMinute;
        this.bathMonth = bathMonth;
        this.diaperBrand = diaperBrand;
        this.observation = observation;
    }


    // all args constructor
    public BathSchedule(Integer id,String bathDate, String bathMonth, String bathHour, String bathMinute, String diaperBrand, String observation){
        this.id = id;
        this.bathDate = bathDate;
        this.bathHour = bathHour;
        this.bathMinute = bathMinute;
        this.bathMonth = bathMonth;
        this.diaperBrand = diaperBrand;
        this.observation = observation;
    }

    public String getBathDate() {
        return bathDate;
    }

    public void setBathDate(String bathDate) {
        this.bathDate = bathDate;
    }

    public String getBathMonth() {
        return bathMonth;
    }

    public void setBathMonth(String bathMonth) {
        this.bathMonth = bathMonth;
    }

    public String getBathHour() {
        return bathHour;
    }

    public void setBathHour(String bathHour) {
        this.bathHour = bathHour;
    }

    public String getBathMinute() {
        return bathMinute;
    }

    public void setBathMinute(String bathMinute) {
        this.bathMinute = bathMinute;
    }

    public String getDiaperBrand() {
        return diaperBrand;
    }

    public void setDiaperBrand(String diaperBrand) {
        this.diaperBrand = diaperBrand;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
