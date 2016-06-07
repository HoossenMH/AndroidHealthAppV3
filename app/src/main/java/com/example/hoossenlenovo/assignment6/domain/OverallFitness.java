package com.example.hoossenlenovo.assignment6.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class OverallFitness extends Exercise
{
    private int runningKm;
    private int skippingRopeAmount;


    public OverallFitness() {
    }

    public OverallFitness(int runningKm, int skippingRopeAmount) {
        this.runningKm = runningKm;
        this.skippingRopeAmount = skippingRopeAmount;
    }


    public int getRunnningKm() {
        return runningKm;
    }
    public int getSkippingRopeAmount() {
        return skippingRopeAmount;
    }

    @Override
    public String exerciseDone()
    {
        return "is done";
    }
}
