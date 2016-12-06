package com.codility.task.lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TapeEquilibriumTest {

    private TapeEquilibrium solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new TapeEquilibrium();
    }

    @Test
    public void test() throws Exception {
        int[] a = { 3, 1, 2, 4, 3 };

        Assert.assertEquals(1, solution.solution(a));
    }

}