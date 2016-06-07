package com.example.hoossenlenovo.assignment6.designPatterns.factories.impl;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.FitnessBioFactory;

import java.util.UUID;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class FitnessBioFactoryImpl implements FitnessBioFactory {

    private static FitnessBioFactoryImpl factory = null;

    private  FitnessBioFactoryImpl() {
    }

    public static FitnessBioFactoryImpl getInstance(){
        if(factory ==null)
            factory = new FitnessBioFactoryImpl();
        return factory;
    }

    public FitnessBio createLogin(String goals, String reasons, String exercise, String yn, float weight, float height, int fitLevel, String bloodPressure, int dietlevel)
    {
        FitnessBio user = new FitnessBio
                .Builder()
                .goals(UUID.randomUUID().toString())
                .reasons(reasons)
                .exercise(exercise)
                .yn(yn)
                .weight(weight)
                .height(height)
                .fitLevel(fitLevel)
                .dietlevel(dietlevel)
                .bloodPressure(bloodPressure)
                .build();
        return user;
    }

}

