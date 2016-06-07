package com.example.hoossenlenovo.assignment6.services.user;
import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.FitnessBioResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface FitnessBioServices {
	
	void addFitnessBio(Context context, FitnessBioResource fitnessBioResource);

    void resetFitnessBio(Context context);
}
