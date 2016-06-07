package com.example.hoossenlenovo.assignment6.repository.User;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Weightloss;
import com.example.hoossenlenovo.assignment6.repository.WeightlossRepository;
import com.example.hoossenlenovo.assignment6.repository.impl.WeightlossRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Admin on 2016/06/07.
 */
public class WeightlossRepositoryTest extends AndroidTestCase
{
    private static final String TAG="Weightloss TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        WeightlossRepository repo = new WeightlossRepositoryImpl(this.getContext());
        // CREATE
        Weightloss createEntity = new Weightloss.Builder()
                .squatAmount(20)
                .pushPressAmount(15)
                .runnningKm(6)
                .build();

        Weightloss insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Weightloss> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        Weightloss entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Weightloss updateEntity = new Weightloss.Builder()
                .copy(entity)
                .pushPressAmount(16)
                .build();
        repo.update(updateEntity);
        Weightloss newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",6,newEntity.getPushPressAmount());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Weightloss deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
