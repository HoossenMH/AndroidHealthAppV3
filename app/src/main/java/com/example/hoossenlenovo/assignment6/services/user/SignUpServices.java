package com.example.hoossenlenovo.assignment6.services.user;

import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.SignUpResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface SignUpServices {
	
	void addSignUp(Context context, SignUpResource signUpResource);

    void resetSignUp(Context context);
}
