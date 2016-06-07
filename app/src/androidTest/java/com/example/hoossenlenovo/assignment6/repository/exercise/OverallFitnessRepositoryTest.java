package com.example.hoossenlenovo.assignment6.repository.exercise;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.OverallFitness;
import com.example.hoossenlenovo.assignment6.repository.OverallFitnessRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.OverallFitnessRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Admin on 2016/06/07.
 */
public class OverallFitnessRepositoryTest extends AndroidTestCase
{
    private static final String TAG="DateOfBirth TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        OverallFitnessRepository repo = new OverallFitnessRepositoryImpl(this.getContext());
        // CREATE
        OverallFitness createEntity = new OverallFitness.Builder()
                .runningKm(5)
                .skippingRopeAmount(500)
                .build();

        OverallFitness insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<OverallFitness> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        OverallFitness entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        OverallFitness updateEntity = new OverallFitness.Builder()
                .copy(entity)
                .runningKm(5)
                .build();
        repo.update(updateEntity);
        OverallFitness newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",5,newEntity.getRunnningKm());

        // DELETE ENTITY
        repo.delete(updateEntity);
        OverallFitness deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}

