package com.codility.challenge.delta2011;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinAbsSumTest {

    private MinAbsSum solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new MinAbsSum();
    }

    @Test
    public void test() throws Exception {
        int[] a = {1, 5, 2, -2};

        Assert.assertEquals(0, solution.solution(a));
    }
}
