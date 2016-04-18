package com.gsu.cs4998.project.model;

import java.net.Inet4Address;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class Medication {

    private Integer id;

    private String medicineName;

    private String medicineQuantity;

    private String medicineQuantityMeasure;

    private String symptomsDescription;

    private String medicineDate;

    private String medicineMonth;

    private String medicineHour;

    private String medicineMinute;

    private String observation;

    public Medication(){

    }

    public Medication(String medicineName, String medicineQuantity, String medicineQuantityMeasure, String symptomsDescription, String medicineDate, String medicineMonth, String medicineHour, String medicineMinute, String observation) {
        this.medicineName = medicineName;
        this.medicineQuantity = medicineQuantity;
        this.medicineQuantityMeasure = medicineQuantityMeasure;
        this.symptomsDescription = symptomsDescription;
        this.medicineDate = medicineDate;
        this.medicineMonth = medicineMonth;
        this.medicineHour = medicineHour;
        this.medicineMinute = medicineMinute;
        this.observation = observation;
    }


    public Medication(Integer id, String medicineName, String medicineQuantity, String medicineQuantityMeasure, String symptomsDescription, String medicineDate, String medicineMonth, String medicineHour, String medicineMinute, String observation) {
        this.id = id;
        this.medicineName = medicineName;
        this.medicineQuantity = medicineQuantity;
        this.medicineQuantityMeasure = medicineQuantityMeasure;
        this.symptomsDescription = symptomsDescription;
        this.medicineDate = medicineDate;
        this.medicineMonth = medicineMonth;
        this.medicineHour = medicineHour;
        this.medicineMinute = medicineMinute;
        this.observation = observation;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(String medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getMedicineQuantityMeasure() {
        return medicineQuantityMeasure;
    }

    public void setMedicineQuantityMeasure(String medicineQuantityMeasure) {
        this.medicineQuantityMeasure = medicineQuantityMeasure;
    }

    public String getSymptomsDescription() {
        return symptomsDescription;
    }

    public void setSymptomsDescription(String symptomsDescription) {
        this.symptomsDescription = symptomsDescription;
    }

    public String getMedicineDate() {
        return medicineDate;
    }

    public void setMedicineDate(String medicineDate) {
        this.medicineDate = medicineDate;
    }

    public String getMedicineMonth() {
        return medicineMonth;
    }

    public void setMedicineMonth(String medicineMonth) {
        this.medicineMonth = medicineMonth;
    }

    public String getMedicineHour() {
        return medicineHour;
    }

    public void setMedicineHour(String medicineHour) {
        this.medicineHour = medicineHour;
    }

    public String getMedicineMinute() {
        return medicineMinute;
    }

    public void setMedicineMinute(String medicineMinute) {
        this.medicineMinute = medicineMinute;
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
