package com.gsu.cs4998.project.model;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class Sleep {


    private Integer id;

    private String sleepDate;

    private String sleepMonth;

    private String sleepHourFrom;

    private String sleepMinuteFrom;

    private String sleepHourTo;

    private String sleepMinuteTo;

    private String observation;


    public Sleep(){

    }

    public Sleep(String sleepDate, String sleepMonth, String sleepHourFrom, String sleepMinuteFrom, String sleepHourTo, String sleepMinuteTo, String observation) {
        this.sleepDate = sleepDate;
        this.sleepMonth = sleepMonth;
        this.sleepHourFrom = sleepHourFrom;
        this.sleepMinuteFrom = sleepMinuteFrom;
        this.sleepHourTo = sleepHourTo;
        this.sleepMinuteTo = sleepMinuteTo;
        this.observation = observation;
    }

    public Sleep(Integer id, String sleepDate, String sleepMonth, String sleepHourFrom, String sleepMinuteFrom, String sleepHourTo, String sleepMinuteTo, String observation) {
        this.id = id;
        this.sleepDate = sleepDate;
        this.sleepMonth = sleepMonth;
        this.sleepHourFrom = sleepHourFrom;
        this.sleepMinuteFrom = sleepMinuteFrom;
        this.sleepHourTo = sleepHourTo;
        this.sleepMinuteTo = sleepMinuteTo;
        this.observation = observation;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSleepDate() {
        return sleepDate;
    }

    public void setSleepDate(String sleepDate) {
        this.sleepDate = sleepDate;
    }

    public String getSleepMonth() {
        return sleepMonth;
    }

    public void setSleepMonth(String sleepMonth) {
        this.sleepMonth = sleepMonth;
    }

    public String getSleepHourFrom() {
        return sleepHourFrom;
    }

    public void setSleepHourFrom(String sleepHourFrom) {
        this.sleepHourFrom = sleepHourFrom;
    }

    public String getSleepMinuteFrom() {
        return sleepMinuteFrom;
    }

    public void setSleepMinuteFrom(String sleepMinuteFrom) {
        this.sleepMinuteFrom = sleepMinuteFrom;
    }

    public String getSleepHourTo() {
        return sleepHourTo;
    }

    public void setSleepHourTo(String sleepHourTo) {
        this.sleepHourTo = sleepHourTo;
    }

    public String getSleepMinuteTo() {
        return sleepMinuteTo;
    }

    public void setSleepMinuteTo(String sleepMinuteTo) {
        this.sleepMinuteTo = sleepMinuteTo;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }


}
