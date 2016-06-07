package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.repository.SignUpRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.SignUpRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.SignUpResource;
import com.example.hoossenlenovo.assignment6.services.user.SignUpServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class SignUpServicesImpl extends IntentService implements SignUpServices
{
    private final SignUpRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static SignUpServicesImpl service = null;

    public static SignUpServicesImpl getInstance() {
        if (service == null)
            service = new SignUpServicesImpl();
        return service;
    }

    private SignUpServicesImpl() {
        super("SignUpServicesImpl");
        repository = new SignUpRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addSignUp(Context context, SignUpResource signUpResource) {
        Intent intent = new Intent(context, SignUpServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, signUpResource);
        context.startService(intent);
    }

    @Override
    public void resetSignUp(Context context) {
        Intent intent = new Intent(context, SignUpServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final SignUpResource signUpResource = (SignUpResource) intent.getSerializableExtra(EXTRA_ADD);
                saveSignUp(signUpResource);
            } else if (ACTION_RESET.equals(action)) {
                resetSignUpRecords();
            }
        }
    }

    private void resetSignUpRecords() {
        repository.deleteAll();
    }

    private void saveSignUp(SignUpResource signUpResource) {
        SignUp signUp = new SignUp.Builder()
                .id(signUpResource.getId())
                .password(signUpResource.getPassword())
                .age(signUpResource.getAge())
                //.dob(signUpResource.getDob())
                .email(signUpResource.getEmail())
                //.uName(signUpResource.getUName())
                .username(signUpResource.getUsername())
                .build();
        SignUp savedSignUp = repository.save(signUp);

    }
}

