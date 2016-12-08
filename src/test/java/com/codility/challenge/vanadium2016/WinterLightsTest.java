package com.codility.challenge.vanadium2016;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WinterLightsTest {

    private WinterLights solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new WinterLights();
    }

    @Test
    public void testSlow1() throws Exception {
        Assert.assertEquals(0, solution.solutionSlow(""));
        Assert.assertEquals(1, solution.solutionSlow("0"));
        Assert.assertEquals(10, solution.solutionSlow("0123456789"));
    }

    @Test
    public void testSlow2() throws Exception {
        Assert.assertEquals(41, solution.solutionSlow("1011100011"));
    }

    @Test
    public void testSlow3() throws Exception {
        Assert.assertEquals(11, solution.solutionSlow("02002"));
    }
}