package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class FitnessBioResource implements Serializable {

    private Long id;
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


    public FitnessBioResource() {
    }

    public FitnessBioResource(Long id,String goals, String reasons, String exercise, String yn, float weight, float height, int fitLevel, String bloodPressure, int dietlevel) {
        this.id = id;
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

    public Long getId() {
        return id;
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


    public FitnessBioResource(Builder builder)
    {
        this.id = builder.id;
        this.goals = builder.goals;
        this.reasons = builder.reasons;
        this.exercise = builder.exercise;
        this.yn = builder.yn;
        weight = builder.weight;
        this.height = builder.height;
        this.fitLevel = builder.fitLevel;
        this.bloodPressure = builder.bloodPressure;
        this.dietlevel = builder.dietlevel;
    }

    public static class Builder
    {
        private Long id;
        private String goals;
        private String reasons;
        private String exercise;
        private String yn;
        private float weight;
        private float height;
        private float BMI = weight / (height*height);
        private int fitLevel;
        private int dietlevel;
        private String bloodPressure;



        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder goals(String value){
            this.goals = value;
            return this;
        }
        public Builder reasons(String value){
            this.reasons = value;
            return this;
        }
        public Builder exercise(String value){
            this.exercise = value;
            return this;
        }
        public Builder yn(String value){
            this.yn = value;
            return this;
        }
        public Builder weight(float value){
            this.weight = value;
            return this;
        }
        public Builder height(float value){
            this.height = value;
            return this;
        }
        public Builder BMI(float value){
            this.BMI = value;
            return this;
        }
        public Builder fitLevel(int value){
            this.fitLevel = value;
            return this;
        }
        public Builder dietlevel(int value){
            this.dietlevel = value;
            return this;
        }
        public Builder bloodPressure(String value){
            this.bloodPressure = value;
            return this;
        }


        public Builder copy(FitnessBioResource value) {

            this.id = value.id;
            this.goals = value.goals;
            this.reasons = value.reasons;
            this.exercise = value.exercise;
            this.yn = value.yn;
            weight = value.weight;
            this.height = value.height;
            this.fitLevel = value.fitLevel;
            this.bloodPressure = value.bloodPressure;
            this.dietlevel = value.dietlevel;
            return this;
        }

        public FitnessBioResource build() {
            return new FitnessBioResource(this);
        }
    }

}
