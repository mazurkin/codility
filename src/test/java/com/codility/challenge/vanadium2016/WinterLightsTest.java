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
    public void testBest() throws Exception {
        Assert.assertEquals(0, solution.solutionBest("", 10));
        Assert.assertEquals(1, solution.solutionBest("0", 10));
        Assert.assertEquals(2, solution.solutionBest("01", 10));

        Assert.assertEquals(41, solution.solutionBest("1011100011", 10));

        Assert.assertEquals(11, solution.solutionBest("02002", 10));

        Assert.assertEquals(10, solution.solutionBest("0123456789", 10));
        Assert.assertEquals(23, solution.solutionBest("01234567890123456789", 10));
    }

    @Test
    public void testGood() throws Exception {
        Assert.assertEquals(0, solution.solutionGood("", 10));
        Assert.assertEquals(1, solution.solutionGood("0", 10));
        Assert.assertEquals(2, solution.solutionGood("01", 10));

        Assert.assertEquals(41, solution.solutionGood("1011100011", 10));

        Assert.assertEquals(11, solution.solutionGood("02002", 10));

        Assert.assertEquals(10, solution.solutionGood("0123456789", 10));
        Assert.assertEquals(23, solution.solutionGood("01234567890123456789", 10));
    }

    @Test
    public void testSlow() throws Exception {
        Assert.assertEquals(0, solution.solutionSlow(""));
        Assert.assertEquals(1, solution.solutionSlow("0"));

        Assert.assertEquals(41, solution.solutionSlow("1011100011"));

        Assert.assertEquals(11, solution.solutionSlow("02002"));

        Assert.assertEquals(10, solution.solutionSlow("0123456789"));
        Assert.assertEquals(23, solution.solutionSlow("01234567890123456789"));
    }
}