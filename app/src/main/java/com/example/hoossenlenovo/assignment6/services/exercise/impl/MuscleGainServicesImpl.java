package com.example.hoossenlenovo.assignment6.services.exercise.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.MuscleGain;
import com.example.hoossenlenovo.assignment6.repository.MuscleGainRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.MuscleGainRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.MuscleGainResource;
import com.example.hoossenlenovo.assignment6.services.exercise.MuscleGainServices;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class MuscleGainServicesImpl extends IntentService implements MuscleGainServices
{
    private final MuscleGainRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.exercise.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.exercise.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.exercise.Impl.extra.ADD";

    private static MuscleGainServicesImpl service = null;

    public static MuscleGainServicesImpl getInstance() {
        if (service == null)
            service = new MuscleGainServicesImpl();
        return service;
    }

    private MuscleGainServicesImpl() {
        super("MuscleGainServicesImpl");
        repository = new MuscleGainRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addMuscleGain(Context context, MuscleGainResource muscleGainResource) {
        Intent intent = new Intent(context, MuscleGainServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, muscleGainResource);
        context.startService(intent);
    }

    @Override
    public void resetMuscleGain(Context context) {
        Intent intent = new Intent(context, MuscleGainServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final MuscleGainResource muscleGainResource = (MuscleGainResource) intent.getSerializableExtra(EXTRA_ADD);
                saveMuscleGain(muscleGainResource);
            } else if (ACTION_RESET.equals(action)) {
                resetMuscleGainRecords();
            }
        }
    }

    private void resetMuscleGainRecords() {
        repository.deleteAll();
    }

    private void saveMuscleGain(MuscleGainResource muscleGainResource) {
        MuscleGain muscleGain = new MuscleGain.Builder()
                .id(muscleGainResource.getId())
                .inclineBenchPressAmount(muscleGainResource.getInclineBenchPressAmount())
                .benchPressAmount(muscleGainResource.getBenchPressAmount())
                .chestsAmount(muscleGainResource.getChestsAmount())
                .build();
        MuscleGain savedMuscleGain = repository.save(muscleGain);

    }
}

