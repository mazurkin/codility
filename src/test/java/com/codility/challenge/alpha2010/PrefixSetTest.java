package com.codility.challenge.alpha2010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrefixSetTest {

    private PrefixSet solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new PrefixSet();
    }

    @Test
    public void test() throws Exception {
        int[] a = {2, 2, 1, 0, 1};

        Assert.assertEquals(3, solution.solution(a));
    }
}