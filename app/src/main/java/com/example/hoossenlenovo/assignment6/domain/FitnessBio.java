package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class FitnessBio {

    private String goals;
    private String reasons;
    private String exercise;
    private String yn;

    private float weight;
    private float height;

    private float BMI = weight / (height*height);
    private int fitLevel;

    private String bloodPressure;

    private int dietlevel;


    public FitnessBio() {
    }

    public FitnessBio(String goals, String reasons, String exercise, String yn, float weight, float height, int fitLevel, String bloodPressure, int dietlevel) {
        this.goals = goals;
        this.reasons = reasons;
        this.exercise = exercise;
        this.yn = yn;
        weight = weight;
        this.height = height;
        this.fitLevel = fitLevel;
        this.bloodPressure = bloodPressure;
        this.dietlevel = dietlevel;
    }

    public String getGoals() {
        return goals;
    }

    public String getReasons() {
        return reasons;
    }

    public String getExercise() {
        return exercise;
    }

    public String getYn() {
        return yn;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public float getBMI() {
        return BMI;
    }

    public int getFitLevel() {
        return fitLevel;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public int getDietlevel() {
        return dietlevel;
    }
}
