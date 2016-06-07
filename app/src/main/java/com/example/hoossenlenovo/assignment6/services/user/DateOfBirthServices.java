package com.example.hoossenlenovo.assignment6.services.user;
import android.content.Context;

import com.example.hoossenlenovo.assignment6.restapi.DateOfBirthResource;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public interface DateOfBirthServices {
	
	void addDateOfBirth(Context context, DateOfBirthResource dateOfBirthResource);

    void resetDateOfBirth(Context context);
}
