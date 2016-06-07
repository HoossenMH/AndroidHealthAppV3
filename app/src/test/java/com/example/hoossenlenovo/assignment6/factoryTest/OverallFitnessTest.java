package com.example.hoossenlenovo.assignment6.factoryTest;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.Login;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.OverallFitness;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.OverallFitnessFactory;
import com.example.hoossenlenovo.assignment6.designPatterns.factories.impl.OverallFitnessFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hoossenLenovo on 2016-06-08.
 */
public class OverallFitnessTest
{

        private OverallFitnessFactory factory;

        @Before
        public void setUp() throws Exception {
            factory = OverallFitnessFactoryImpl.getInstance();

        }

        @Test
        public void testLoginCreation() throws Exception {

            OverallFitness user = factory.createLogin(5, 500);

            Assert.assertEquals(user.getRunnningKm(), 5);
            Assert.assertEquals(user.getSkippingRopeAmount(), 500);
        }


        @Test
        public void testLoginUpdate() throws Exception {

            OverallFitness user = factory.createLogin(5, 500);

            Assert.assertEquals(user.getRunnningKm(), 5);
            Assert.assertEquals(user.getSkippingRopeAmount(), 500);

            // Updated password

            OverallFitness updateLogin = new OverallFitness.Builder()
                    .copy(user)
                    .runningKm(8)
                    .build();

            Assert.assertEquals(updateLogin.getRunnningKm(), 8);
            Assert.assertEquals(user.getSkippingRopeAmount(), 500);


        }
}

