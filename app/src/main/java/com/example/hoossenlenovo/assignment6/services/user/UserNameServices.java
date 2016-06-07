package com.example.hoossenlenovo.assignment6.services.user;

import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.UserNameResource;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public interface UserNameServices {

    void addUserName(Context context, UserNameResource userNameResource);

    void resetUserName(Context context);

}
