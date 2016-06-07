package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by Admin on 2016/06/07.
 */
public class MuscleGainResource implements Serializable {

    private Long id;
    private int chestsAmount;
    private int benchPressAmount;
    private int inclineBenchPressAmount;

//    private List<Orders> orders;

    public Long getId() {
        return id;
    }
    public int getBenchPressAmount() {
        return benchPressAmount;
    }
    public int getChestsAmount() {
        return chestsAmount;
    }
    public int getInclineBenchPressAmount() {
        return inclineBenchPressAmount;
    }

    private MuscleGainResource(){}

    public MuscleGainResource(Builder builder)
    {
        this.id = builder.id;
        this.chestsAmount = builder.chestsAmount;
        this.benchPressAmount = builder.benchPressAmount;
        this.inclineBenchPressAmount = builder.inclineBenchPressAmount;
    }

    public static class Builder
    {
        private long id;
        private int chestsAmount;
        private int benchPressAmount;
        private int inclineBenchPressAmount;

        public Builder() {
        }

        public Builder(Long id,int chestsAmount, int benchPressAmount, int inclineBenchPressAmount) {
            this.id = id;
            this.chestsAmount = chestsAmount;
            this.benchPressAmount = benchPressAmount;
            this.inclineBenchPressAmount = inclineBenchPressAmount;
        }


        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder chestsAmount(int value){
            this.chestsAmount = value;
            return this;
        }
        public Builder benchPressAmount(int value){
            this.benchPressAmount = value;
            return this;
        }
        public Builder inclineBenchPressAmount(int value){
            this.inclineBenchPressAmount = value;
            return this;
        }

        public Builder copy(MuscleGainResource value) {
            this.id = value.id;
            this.chestsAmount = value.chestsAmount;
            this.benchPressAmount = value.benchPressAmount;
            this.inclineBenchPressAmount = value.inclineBenchPressAmount;
            return this;
        }

        public MuscleGainResource build() {
            return new MuscleGainResource(this);
        }
    }
}