package com.example.hoossenlenovo.assignment6.services.exercise;

import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.OverallFitnessResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface OverallFitnessServices {


    void addOverallFitness(Context context, OverallFitnessResource overallFitnessResource);

    void resetOverallFitness(Context context);
}
