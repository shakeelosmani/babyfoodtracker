package com.gsu.cs4998.project.model;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class LiquidFood {

    private Integer id;

    private String liquidFoodName;

    private String liquidFoodQuantity;

    private String liquidFoodMeasureType;

    private String liquidFoodHour;

    private String liquidFoodMinute;

    private String liquidFoodDay;

    private String liquidFoodMonth;

    private String observation;

    public LiquidFood(){

    }

    public LiquidFood(String liquidFoodName, String liquidFoodQuantity, String liquidFoodMeasureType, String liquidFoodHour, String liquidFoodMinute, String liquidFoodDay, String liquidFoodMonth, String observation) {
        this.liquidFoodName = liquidFoodName;
        this.liquidFoodQuantity = liquidFoodQuantity;
        this.liquidFoodMeasureType = liquidFoodMeasureType;
        this.liquidFoodHour = liquidFoodHour;
        this.liquidFoodMinute = liquidFoodMinute;
        this.liquidFoodDay = liquidFoodDay;
        this.liquidFoodMonth = liquidFoodMonth;
        this.observation = observation;
    }

    public LiquidFood(Integer id, String liquidFoodName, String liquidFoodQuantity, String liquidFoodMeasureType, String liquidFoodHour, String liquidFoodMinute, String liquidFoodDay, String liquidFoodMonth, String observation) {
        this.id = id;
        this.liquidFoodName = liquidFoodName;
        this.liquidFoodQuantity = liquidFoodQuantity;
        this.liquidFoodMeasureType = liquidFoodMeasureType;
        this.liquidFoodHour = liquidFoodHour;
        this.liquidFoodMinute = liquidFoodMinute;
        this.liquidFoodDay = liquidFoodDay;
        this.liquidFoodMonth = liquidFoodMonth;
        this.observation = observation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiquidFoodName() {
        return liquidFoodName;
    }

    public void setLiquidFoodName(String liquidFoodName) {
        this.liquidFoodName = liquidFoodName;
    }

    public String getLiquidFoodQuantity() {
        return liquidFoodQuantity;
    }

    public void setLiquidFoodQuantity(String liquidFoodQuantity) {
        this.liquidFoodQuantity = liquidFoodQuantity;
    }

    public String getLiquidFoodMeasureType() {
        return liquidFoodMeasureType;
    }

    public void setLiquidFoodMeasureType(String liquidFoodMeasureType) {
        this.liquidFoodMeasureType = liquidFoodMeasureType;
    }

    public String getLiquidFoodHour() {
        return liquidFoodHour;
    }

    public void setLiquidFoodHour(String liquidFoodHour) {
        this.liquidFoodHour = liquidFoodHour;
    }

    public String getLiquidFoodMinute() {
        return liquidFoodMinute;
    }

    public void setLiquidFoodMinute(String liquidFoodMinute) {
        this.liquidFoodMinute = liquidFoodMinute;
    }

    public String getLiquidFoodDay() {
        return liquidFoodDay;
    }

    public void setLiquidFoodDay(String liquidFoodDay) {
        this.liquidFoodDay = liquidFoodDay;
    }

    public String getLiquidFoodMonth() {
        return liquidFoodMonth;
    }

    public void setLiquidFoodMonth(String liquidFoodMonth) {
        this.liquidFoodMonth = liquidFoodMonth;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
