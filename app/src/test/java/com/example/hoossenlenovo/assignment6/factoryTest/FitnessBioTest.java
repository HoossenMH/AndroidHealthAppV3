package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.FitnessBioFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.FitnessBioFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-06-08.
 */
public class FitnessBioTest {

    private FitnessBioFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = FitnessBioFactoryImpl.getInstance();

    }

    @Test
    public void testLoginCreation() throws Exception {

        FitnessBio user = factory.createLogin("to be the best", "to feel good", "overallfitness", "y", 70, 175, 7, "120", 8);

        Assert.assertEquals(user.getGoals(), "to be the best");
        Assert.assertEquals(user.getReasons(), "to feel good");
        Assert.assertEquals(user.getExercise(), "overallfitness");
        Assert.assertEquals(user.getYn(), "y");
        Assert.assertEquals(user.getWeight(), 70);
        Assert.assertEquals(user.getHeight(), 175);
        Assert.assertEquals(user.getBloodPressure(), "120");
        Assert.assertEquals(user.getDietlevel(), 8);
        Assert.assertEquals(user.getFitLevel(), 7);
    }


    @Test
    public void testLoginUpdate() throws Exception {

        FitnessBio user = factory.createLogin("to be the best", "to feel good", "overallfitness", "y", 70, 175, 7, "120", 8);

        Assert.assertEquals(user.getGoals(), "to be the best");
        Assert.assertEquals(user.getReasons(), "to feel good");
        Assert.assertEquals(user.getExercise(), "overallfitness");
        Assert.assertEquals(user.getYn(), "y");
        Assert.assertEquals(user.getWeight(), 70);
        Assert.assertEquals(user.getHeight(), 175);
        Assert.assertEquals(user.getBloodPressure(), "120");
        Assert.assertEquals(user.getDietlevel(), 8);
        Assert.assertEquals(user.getFitLevel(), 7);

        // Updated password

        FitnessBio updateLogin = new FitnessBio.Builder()
                .copy(user)
                .bloodPressure("140")
                .build();

        Assert.assertEquals(user.getGoals(), "to be the best");
        Assert.assertEquals(user.getReasons(), "to feel good");
        Assert.assertEquals(user.getExercise(), "overallfitness");
        Assert.assertEquals(user.getYn(), "y");
        Assert.assertEquals(user.getWeight(), 70);
        Assert.assertEquals(user.getHeight(), 175);
        Assert.assertEquals(user.getDietlevel(), 8);
        Assert.assertEquals(user.getFitLevel(), 7);

        Assert.assertEquals(updateLogin.getBloodPressure(), "140");


    }
}
