package com.example.hoossenlenovo.assignment6.services.exercise.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.OverallFitness;
import com.example.hoossenlenovo.assignment6.repository.OverallFitnessRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.OverallFitnessRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.OverallFitnessResource;
import com.example.hoossenlenovo.assignment6.services.exercise.OverallFitnessServices;

/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class OverallFitnessServicesImpl extends IntentService implements OverallFitnessServices
{
    private final OverallFitnessRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.exercise.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.exercise.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.exercise.Impl.extra.ADD";

    private static OverallFitnessServicesImpl service = null;

    public static OverallFitnessServicesImpl getInstance() {
        if (service == null)
            service = new OverallFitnessServicesImpl();
        return service;
    }

    private OverallFitnessServicesImpl() {
        super("OverallFitnessServicesImpl");
        repository = new OverallFitnessRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addOverallFitness(Context context, OverallFitnessResource overallFitnessResource) {
        Intent intent = new Intent(context, OverallFitnessServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, overallFitnessResource);
        context.startService(intent);
    }

    @Override
    public void resetOverallFitness(Context context) {
        Intent intent = new Intent(context, OverallFitnessServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final OverallFitnessResource overallFitnessResource = (OverallFitnessResource) intent.getSerializableExtra(EXTRA_ADD);
                saveOverallFitness(overallFitnessResource);
            } else if (ACTION_RESET.equals(action)) {
                resetOverallFitnessRecords();
            }
        }
    }

    private void resetOverallFitnessRecords() {
        repository.deleteAll();
    }

    private void saveOverallFitness(OverallFitnessResource overallFitnessResource) {
        OverallFitness overallFitness = new OverallFitness.Builder()
                .id(overallFitnessResource.getId())
                .runningKm(overallFitnessResource.getRunnningKm())
                .skippingRopeAmount(overallFitnessResource.getSkippingRopeAmount())
                .build();
        OverallFitness savedOverallFitness = repository.save(overallFitness);

    }
}
