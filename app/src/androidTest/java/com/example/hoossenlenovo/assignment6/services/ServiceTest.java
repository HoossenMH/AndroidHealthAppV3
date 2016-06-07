package com.example.hoossenlenovo.assignment6.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;
import com.example.hoossenlenovo.assignment6.services.exercise.impl.MuscleGainServicesImpl;

import junit.framework.Assert;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class ServiceTest extends AndroidTestCase {
    private MuscleGainServicesImpl activateService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), MuscleGainServicesImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MuscleGainServicesImpl.ActivateServiceLocalBinder binder
                    = (MuscleGainServicesImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

//    public void testActivateAccount() throws Exception {
//        String activate = activateService.activateAccount("bonifae@test.com", "test");
//        Assert.assertEquals("ACTIVATED", activate);
//
//    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = activateService.isAccountActivated();
        Assert.assertTrue("ACTIVATED", activated);

    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = activateService.deactivateAccount();
        Assert.assertTrue("ACTIVATED", deactivated);
    }




}
