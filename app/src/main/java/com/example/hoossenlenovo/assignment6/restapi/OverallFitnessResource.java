package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class OverallFitnessResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private int runningKm;
    private int skippingRopeAmount;


    public OverallFitnessResource() {
    }

    public OverallFitnessResource(Long id,int runningKm, int skippingRopeAmount) {
        this.id = id;
        this.runningKm = runningKm;
        this.skippingRopeAmount = skippingRopeAmount;
    }

    public Long getId() {
        return id;
    }

    public int getRunnningKm() {
        return runningKm;
    }
    public int getSkippingRopeAmount() {
        return skippingRopeAmount;
    }


    public OverallFitnessResource(Builder builder)
    {
        this.runningKm = builder.runningKm;
        this.skippingRopeAmount = builder.skippingRopeAmount;
        this.id = builder.id;
    }

    public static class Builder
    {
        private Long id;
        private int runningKm;
        private int skippingRopeAmount;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder runningKm(int value){
            this.runningKm = value;
            return this;
        }
        public Builder skippingRopeAmount(int value){
            this.skippingRopeAmount = value;
            return this;
        }

        public Builder copy(OverallFitnessResource value) {
            this.id = value.id;
            this.runningKm = value.runningKm;
            this.skippingRopeAmount = value.skippingRopeAmount;
            return this;
        }

        public OverallFitnessResource build() {
            return new OverallFitnessResource(this);
        }
    }
}
