package com.example.hoossenlenovo.assignment6.services.exercise;

import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.MuscleGainResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface MuscleGainServices {

    void addMuscleGain(Context context, MuscleGainResource muscleGainResource);

    void resetMuscleGain(Context context);
}
