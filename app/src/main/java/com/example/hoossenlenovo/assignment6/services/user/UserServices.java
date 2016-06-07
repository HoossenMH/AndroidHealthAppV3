package com.example.hoossenlenovo.assignment6.services.user;

import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.UserResource;


/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface UserServices {

	void addUser(Context context, UserResource userResource);

    void resetUser(Context context);
}