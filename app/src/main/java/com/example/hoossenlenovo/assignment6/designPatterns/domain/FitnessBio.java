package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class FitnessBio implements Serializable {

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


    public FitnessBio() {
    }

    public FitnessBio(Long id,String goals, String reasons, String exercise, String yn, float weight, float height, int fitLevel, String bloodPressure, int dietlevel) {
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


    public FitnessBio(Builder builder)
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


        public Builder copy(FitnessBio value) {

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

        public FitnessBio build() {
            return new FitnessBio(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FitnessBio)) return false;

        FitnessBio that = (FitnessBio) o;

        if (Float.compare(that.getWeight(), getWeight()) != 0) return false;
        if (Float.compare(that.getHeight(), getHeight()) != 0) return false;
        if (Float.compare(that.getBMI(), getBMI()) != 0) return false;
        if (getFitLevel() != that.getFitLevel()) return false;
        if (getDietlevel() != that.getDietlevel()) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (getGoals() != null ? !getGoals().equals(that.getGoals()) : that.getGoals() != null)
            return false;
        if (getReasons() != null ? !getReasons().equals(that.getReasons()) : that.getReasons() != null)
            return false;
        if (getExercise() != null ? !getExercise().equals(that.getExercise()) : that.getExercise() != null)
            return false;
        if (getYn() != null ? !getYn().equals(that.getYn()) : that.getYn() != null) return false;
        return getBloodPressure() != null ? getBloodPressure().equals(that.getBloodPressure()) : that.getBloodPressure() == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (getGoals() != null ? getGoals().hashCode() : 0);
        result = 31 * result + (getReasons() != null ? getReasons().hashCode() : 0);
        result = 31 * result + (getExercise() != null ? getExercise().hashCode() : 0);
        result = 31 * result + (getYn() != null ? getYn().hashCode() : 0);
        result = 31 * result + (getWeight() != +0.0f ? Float.floatToIntBits(getWeight()) : 0);
        result = 31 * result + (getHeight() != +0.0f ? Float.floatToIntBits(getHeight()) : 0);
        result = 31 * result + (getBMI() != +0.0f ? Float.floatToIntBits(getBMI()) : 0);
        result = 31 * result + getFitLevel();
        result = 31 * result + (getBloodPressure() != null ? getBloodPressure().hashCode() : 0);
        result = 31 * result + getDietlevel();
        return result;
    }
}
