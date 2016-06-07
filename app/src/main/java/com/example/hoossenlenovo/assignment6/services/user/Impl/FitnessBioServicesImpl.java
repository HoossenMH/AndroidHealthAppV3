package com.example.hoossenlenovo.assignment6.services.user.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.hoossenlenovo.assignment6.conf.util.App;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;
import com.example.hoossenlenovo.assignment6.repository.FitnessBioRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.FitnessBioRepositoryImpl;
import com.example.hoossenlenovo.assignment6.restapi.FitnessBioResource;
import com.example.hoossenlenovo.assignment6.services.user.FitnessBioServices;
/**
 * Created by hoossenLenovo on 2016-05-08.
 */
public class FitnessBioServicesImpl extends IntentService implements FitnessBioServices
{
    private final FitnessBioRepository repository;

    private static final String ACTION_ADD = "com.example.hoossenlenovo.assignment6.services.user.impl.action.ADD";
    private static final String ACTION_RESET = "com.example.hoossenlenovo.assignment6.services.user.impl.action.RESET";

    private static final String EXTRA_ADD = "com.example.hoossenlenovo.assignment6.services.user.Impl.extra.ADD";

    private static FitnessBioServicesImpl service = null;

    public static FitnessBioServicesImpl getInstance() {
        if (service == null)
            service = new FitnessBioServicesImpl();
        return service;
    }

    private FitnessBioServicesImpl() {
        super("FitnessBioServicesImpl");
        repository = new FitnessBioRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addFitnessBio(Context context, FitnessBioResource fitnessBioResource) {
        Intent intent = new Intent(context, FitnessBioServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, fitnessBioResource);
        context.startService(intent);
    }

    @Override
    public void resetFitnessBio(Context context) {
        Intent intent = new Intent(context, FitnessBioServicesImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final FitnessBioResource fitnessBioResource = (FitnessBioResource) intent.getSerializableExtra(EXTRA_ADD);
                saveFitnessBio(fitnessBioResource);
            } else if (ACTION_RESET.equals(action)) {
                resetFitnessBioRecords();
            }
        }
    }

    private void resetFitnessBioRecords() {
        repository.deleteAll();
    }

    private void saveFitnessBio(FitnessBioResource fitnessBioResource) {
        FitnessBio fitnessBio = new FitnessBio.Builder()
                .id(fitnessBioResource.getId())
                .goals(fitnessBioResource.getGoals())
                .dietlevel(fitnessBioResource.getDietlevel())
                .BMI(fitnessBioResource.getBMI())
                .exercise(fitnessBioResource.getExercise())
                .bloodPressure(fitnessBioResource.getBloodPressure())
                .fitLevel(fitnessBioResource.getFitLevel())
                .height(fitnessBioResource.getHeight())
                .weight(fitnessBioResource.getWeight())
                .yn(fitnessBioResource.getYn())
                .build();
        FitnessBio savedFitnessBio = repository.save(fitnessBio);

    }
}

