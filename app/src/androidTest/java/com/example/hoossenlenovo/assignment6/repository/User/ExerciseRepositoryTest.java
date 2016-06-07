package com.example.hoossenlenovo.assignment6.repository.User;

import android.test.AndroidTestCase;

import com.example.hoossenlenovo.assignment6.repository.ExerciseRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Admin on 2016/06/07.
 */
public class ExerciseRepositoryTest extends AndroidTestCase
{
    private static final String TAG="Exercise TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        ExerciseRepository repo = new ExerciseRepositoryImpl(this.getContext());
        // CREATE
        Exercise createEntity = new Exercise.Builder()
                .done("is done");
                .build();

        Exercise insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Exercise> users = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",users.size()>0);

        //READ ENTITY
        Exercise entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Exercise updateEntity = new Exercise.Builder()
                .copy(entity)
                .done("is not done");
                .build();
        repo.update(updateEntity);
        Exercise newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","is not done",newEntity.getMonth());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Exercise deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
