package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.User;
import com.example.hoossenlenovo.assignment6.repository.UserRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.UserRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.UserResource;
import com.example.hoossenlenovo.assignment6.services.user.UserServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class UserServicesImpl extends IntentService implements UserServices
{
    private final UserRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static UserServicesImpl service = null;

    public static UserServicesImpl getInstance() {
        if (service == null)
            service = new UserServicesImpl();
        return service;
    }

    private UserServicesImpl() {
        super("UserServicesImpl");
        repository = new UserRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addUser(Context context, UserResource userResource) {
        Intent intent = new Intent(context, UserServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, userResource);
        context.startService(intent);
    }

    @Override
    public void resetUser(Context context) {
        Intent intent = new Intent(context, UserServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final UserResource userResource = (UserResource) intent.getSerializableExtra(EXTRA_ADD);
                saveUser(userResource);
            } else if (ACTION_RESET.equals(action)) {
                resetUserRecords();
            }
        }
    }

    private void resetUserRecords() {
        repository.deleteAll();
    }

    private void saveUser(UserResource userResource) {
        User user = new User.Builder()
                .id(userResource.getId())
                .userId(userResource.getUserId())
                //.uName(userResource.getUserName())
                .age(userResource.getAge())
                .build();
        User savedUser = repository.save(user);

    }
}

