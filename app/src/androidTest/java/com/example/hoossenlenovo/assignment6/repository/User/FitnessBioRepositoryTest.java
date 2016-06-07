package com.example.hoossenlenovo.assignment6.repository.User;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;
import com.example.hoossenlenovo.assignment6.repository.FitnessBioRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.FitnessBioRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Admin on 2016/06/07.
 */
public class FitnessBioRepositoryTest extends AndroidTestCase
{
    private static final String TAG="FitnessBio TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        FitnessBioRepository repo = new FitnessBioRepositoryImpl(this.getContext());
        // CREATE
        FitnessBio createEntity = new FitnessBio.Builder()
                .goals("to be fit")
                .reasons("i want to feel healthy")
                .exercise("overall fitness")
                .yn("yes")
                .weight(70)
                .height(1.7)
                .BMI(707)
                .fitLevel(5)
                .bloodPressure(100)
                .dietlevel(5)
                .build();

        FitnessBio insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<FitnessBio> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        FitnessBio entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        FitnessBio updateEntity = new FitnessBio.Builder()
                .copy(entity)
                .height(1.85)
                .build();
        repo.update(updateEntity);
        FitnessBio newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",1.85,newEntity.getHeight());

        // DELETE ENTITY
        repo.delete(updateEntity);
        FitnessBio deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
