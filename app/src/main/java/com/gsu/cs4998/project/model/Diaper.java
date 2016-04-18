package com.gsu.cs4998.project.model;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class Diaper {

    private Integer id;

    private String diaperForPoop;

    private String diaperForPee;

    private String diaperDate;

    private String diaperMonth;

    private String diaperHour;

    private String diaperMinute;

    private String diaperBrand;

    private String observation;

    //no args constructor

    public Diaper(){

    }

    public Diaper(String diaperForPoop, String diaperForPee, String diaperDate, String diaperMonth, String diaperHour, String diaperMinute, String diaperBrand, String observation) {
        this.diaperForPoop = diaperForPoop;
        this.diaperForPee = diaperForPee;
        this.diaperDate = diaperDate;
        this.diaperMonth = diaperMonth;
        this.diaperHour = diaperHour;
        this.diaperMinute = diaperMinute;
        this.diaperBrand = diaperBrand;
        this.observation = observation;
    }

    public Diaper(Integer id, String diaperForPoop, String diaperForPee, String diaperDate, String diaperMonth, String diaperHour, String diaperMinute, String diaperBrand, String observation) {
        this.id = id;
        this.diaperForPoop = diaperForPoop;
        this.diaperForPee = diaperForPee;
        this.diaperDate = diaperDate;
        this.diaperMonth = diaperMonth;
        this.diaperHour = diaperHour;
        this.diaperMinute = diaperMinute;
        this.diaperBrand = diaperBrand;
        this.observation = observation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaperForPoop() {
        return diaperForPoop;
    }

    public void setDiaperForPoop(String diaperForPoop) {
        this.diaperForPoop = diaperForPoop;
    }

    public String getDiaperForPee() {
        return diaperForPee;
    }

    public void setDiaperForPee(String diaperForPee) {
        this.diaperForPee = diaperForPee;
    }

    public String getDiaperDate() {
        return diaperDate;
    }

    public void setDiaperDate(String diaperDate) {
        this.diaperDate = diaperDate;
    }

    public String getDiaperMonth() {
        return diaperMonth;
    }

    public void setDiaperMonth(String diaperMonth) {
        this.diaperMonth = diaperMonth;
    }

    public String getDiaperHour() {
        return diaperHour;
    }

    public void setDiaperHour(String diaperHour) {
        this.diaperHour = diaperHour;
    }

    public String getDiaperMinute() {
        return diaperMinute;
    }

    public void setDiaperMinute(String diaperMinute) {
        this.diaperMinute = diaperMinute;
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
}
