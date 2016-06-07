package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.repository.DateOfBirthRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.DateOfBirthRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.DateOfBirthResource;
import com.example.hoossenlenovo.assignment6.services.user.DateOfBirthServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class DateOfBirthServicesImpl extends IntentService implements DateOfBirthServices
{
    private final DateOfBirthRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static DateOfBirthServicesImpl service = null;

    public static DateOfBirthServicesImpl getInstance() {
        if (service == null)
            service = new DateOfBirthServicesImpl();
        return service;
    }

    private DateOfBirthServicesImpl() {
        super("DateOfBirthServicesImpl");
        repository = new DateOfBirthRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addDateOfBirth(Context context, DateOfBirthResource dateOfBirthResource) {
        Intent intent = new Intent(context, DateOfBirthServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, dateOfBirthResource);
        context.startService(intent);
    }

    @Override
    public void resetDateOfBirth(Context context) {
        Intent intent = new Intent(context, DateOfBirthServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final DateOfBirthResource dateOfBirthResource = (DateOfBirthResource) intent.getSerializableExtra(EXTRA_ADD);
                saveDateOfBirth(dateOfBirthResource);
            } else if (ACTION_RESET.equals(action)) {
                resetDateOfBirthRecords();
            }
        }
    }

    private void resetDateOfBirthRecords() {
        repository.deleteAll();
    }

    private void saveDateOfBirth(DateOfBirthResource dateOfBirthResource) {
        DateOfBirth dateOfBirth = new DateOfBirth.Builder()
                .id(dateOfBirthResource.getId())
                .year(dateOfBirthResource.getYear())
                .month(dateOfBirthResource.getMonth())
                .day(dateOfBirthResource.getDay())
                .build();
        DateOfBirth savedDateOfBirth = repository.save(dateOfBirth);

    }
}

