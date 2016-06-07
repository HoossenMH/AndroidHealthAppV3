package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;
import com.example.hoossenlenovo.assignment6.repository.UserNameRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.UserNameRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.UserNameResource;
import com.example.hoossenlenovo.assignment6.services.user.UserNameServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class UserNameServicesImpl extends IntentService implements UserNameServices
{
    private final UserNameRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static UserNameServicesImpl service = null;

    public static UserNameServicesImpl getInstance() {
        if (service == null)
            service = new UserNameServicesImpl();
        return service;
    }

    private UserNameServicesImpl() {
        super("UserNameServicesImpl");
        repository = new UserNameRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addUserName(Context context, UserNameResource userNameResource) {
        Intent intent = new Intent(context, UserNameServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, userNameResource);
        context.startService(intent);
    }

    @Override
    public void resetUserName(Context context) {
        Intent intent = new Intent(context, UserNameServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final UserNameResource userNameResource = (UserNameResource) intent.getSerializableExtra(EXTRA_ADD);
                saveUserName(userNameResource);
            } else if (ACTION_RESET.equals(action)) {
                resetUserNameRecords();
            }
        }
    }

    private void resetUserNameRecords() {
        repository.deleteAll();
    }

    private void saveUserName(UserNameResource userNameResource) {
        UserName userName = new UserName.Builder()
                .id(userNameResource.getId())
                .firstName(userNameResource.getFirstName())
                .lastName(userNameResource.getLastName())
                .build();
        UserName savedUserName = repository.save(userName);

    }
}

