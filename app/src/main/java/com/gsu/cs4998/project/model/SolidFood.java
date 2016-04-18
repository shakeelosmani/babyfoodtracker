package com.gsu.cs4998.project.model;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class SolidFood {



    private Integer id;

    private String solidFoodName;

    private String solidFoodDay;

    private String soliFoodMonth;

    private String solidFoodHour;

    private String solidFoodMinute;

    private String observation;

    public SolidFood(){

    }

    public SolidFood(String solidFoodName, String solidFoodHour, String solidFoodMinute, String observation) {
        this.solidFoodName = solidFoodName;
        this.solidFoodHour = solidFoodHour;
        this.solidFoodMinute = solidFoodMinute;
        this.observation = observation;
    }

    public SolidFood(Integer id, String solidFoodName, String solidFoodHour, String solidFoodMinute, String observation) {
        this.id = id;
        this.solidFoodName = solidFoodName;
        this.solidFoodHour = solidFoodHour;
        this.solidFoodMinute = solidFoodMinute;
        this.observation = observation;
    }

    public String getSolidFoodName() {
        return solidFoodName;
    }

    public void setSolidFoodName(String solidFoodName) {
        this.solidFoodName = solidFoodName;
    }

    public String getSolidFoodHour() {
        return solidFoodHour;
    }

    public void setSolidFoodHour(String solidFoodHour) {
        this.solidFoodHour = solidFoodHour;
    }

    public String getSolidFoodMinute() {
        return solidFoodMinute;
    }

    public void setSolidFoodMinute(String solidFoodMinute) {
        this.solidFoodMinute = solidFoodMinute;
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

    public String getSolidFoodDay() {
        return solidFoodDay;
    }

    public void setSolidFoodDay(String solidFoodDay) {
        this.solidFoodDay = solidFoodDay;
    }

    public String getSoliFoodMonth() {
        return soliFoodMonth;
    }

    public void setSoliFoodMonth(String soliFoodMonth) {
        this.soliFoodMonth = soliFoodMonth;
    }
}
