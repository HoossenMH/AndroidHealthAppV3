package com.example.hoossenlenovo.assignment6.services.user;
import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.LoginResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface LoginServices {
	
	void addLogin(Context context, LoginResource loginResource);

    void resetLogin(Context context);
}
