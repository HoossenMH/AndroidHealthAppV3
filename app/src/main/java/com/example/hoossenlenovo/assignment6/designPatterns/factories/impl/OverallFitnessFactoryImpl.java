package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.OverallFitness;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.OverallFitnessFactory;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class OverallFitnessFactoryImpl implements OverallFitnessFactory {

    private static OverallFitnessFactoryImpl factory = null;

    private  OverallFitnessFactoryImpl() {
    }

    public static OverallFitnessFactoryImpl getInstance(){
        if(factory ==null)
            factory = new OverallFitnessFactoryImpl();
        return factory;
    }

    public OverallFitness createLogin(Long id,int runningKm, int skippingRopeAmount) {
        OverallFitness user = new OverallFitness
                .Builder()
                .id(id)
                .runningKm(runningKm)
                .skippingRopeAmount(skippingRopeAmount)
                .build();
        return user;
    }

}

