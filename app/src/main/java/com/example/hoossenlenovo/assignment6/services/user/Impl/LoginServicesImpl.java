package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;
import com.example.hoossenlenovo.assignment6.repository.LoginRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.LoginRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.LoginResource;
import com.example.hoossenlenovo.assignment6.services.user.LoginServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class LoginServicesImpl extends IntentService implements LoginServices
{
    private final LoginRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static LoginServicesImpl service = null;

    public static LoginServicesImpl getInstance() {
        if (service == null)
            service = new LoginServicesImpl();
        return service;
    }

    private LoginServicesImpl() {
        super("LoginServicesImpl");
        repository = new LoginRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addLogin(Context context, LoginResource loginResource) {
        Intent intent = new Intent(context, LoginServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, loginResource);
        context.startService(intent);
    }

    @Override
    public void resetLogin(Context context) {
        Intent intent = new Intent(context, LoginServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final LoginResource loginResource = (LoginResource) intent.getSerializableExtra(EXTRA_ADD);
                saveLogin(loginResource);
            } else if (ACTION_RESET.equals(action)) {
                resetLoginRecords();
            }
        }
    }

    private void resetLoginRecords() {
        repository.deleteAll();
    }

    private void saveLogin(LoginResource loginResource) {
        Login login = new Login.Builder()
                .id(loginResource.getId())
                .password(loginResource.getPassword())
                .userName(loginResource.getUserName())
                .build();
        Login savedLogin = repository.save(login);

    }
}

