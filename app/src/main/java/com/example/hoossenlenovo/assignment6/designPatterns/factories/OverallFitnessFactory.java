package com.example.hoossenlenovo.assignment6.designPatterns.factories;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.OverallFitness;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public interface OverallFitnessFactory {

    OverallFitness createLogin(Long id,int runningKm, int skippingRopeAmount);
}
