package com.example.hoossenlenovo.assignment6.designPatterns.factories;


import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public interface FitnessBioFactory {

    FitnessBio createLogin(String goals, String reasons, String exercise, String yn, float weight, float height, int fitLevel, String bloodPressure, int dietlevel);
}
