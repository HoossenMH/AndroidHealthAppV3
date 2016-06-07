package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class OverallFitness implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private int runningKm;
    private int skippingRopeAmount;


    public OverallFitness() {
    }

    public OverallFitness(Long id,int runningKm, int skippingRopeAmount) {
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


    public OverallFitness(Builder builder)
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

        public Builder copy(OverallFitness value) {
            this.id = value.id;
            this.runningKm = value.runningKm;
            this.skippingRopeAmount = value.skippingRopeAmount;
            return this;
        }

        public OverallFitness build() {
            return new OverallFitness(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OverallFitness)) return false;

        OverallFitness that = (OverallFitness) o;

        if (runningKm != that.runningKm) return false;
        if (getSkippingRopeAmount() != that.getSkippingRopeAmount()) return false;
        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + runningKm;
        result = 31 * result + getSkippingRopeAmount();
        return result;
    }
}
