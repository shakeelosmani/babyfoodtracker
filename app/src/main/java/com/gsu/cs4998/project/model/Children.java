package com.gsu.cs4998.project.model;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class Children {

    private Integer id;

    private String name;

    private String imagePath;

    private String birthDate;

    private String sex;

    private String birthMonth;

    private String heightFeet;

    private String heightInch;

    private String weight;


    public Children(){
        //no args constructor
    }


    public Children(String name,String imagePath, String birthDate, String birthMonth, String sex, String heightFeet, String heightInch, String weight){
        // constructor without id
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.name = name;
        this.sex = sex;
        this.imagePath = imagePath;
        this.heightFeet = heightFeet;
        this.heightInch = heightInch;
        this.weight = weight;
    }

    public Children(String name, String birthDate, String birthMonth, String sex, String heightFeet, String heightInch, String weight){
        // constructor without imagepath and id
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.name = name;
        this.heightFeet = heightFeet;
        this.heightInch = heightInch;
        this.weight = weight;
        this.sex = sex;

    }

    public Children(Integer id, String name,String imagePath, String birthDate, String birthMonth, String sex, String heightFeet, String heightInch, String weight){
        this.id = id;
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.name = name;
        this.imagePath = imagePath;
        this.heightFeet = heightFeet;
        this.heightInch = heightInch;
        this.weight = weight;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightInch() {
        return heightInch;
    }

    public void setHeightInch(String heightInch) {
        this.heightInch = heightInch;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
