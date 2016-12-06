package com.codility.challenge.beta2010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfDiscIntersectionsTest {

    private NumberOfDiscIntersections solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new NumberOfDiscIntersections();
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertEquals(0, solution.solution(new int[] {}));
        Assert.assertEquals(0, solution.solution(new int[] {2}));
    }

    @Test
    public void test1() throws Exception {
        int[] a = {1, 5, 2, 1, 4, 0};

        Assert.assertEquals(11, solution.solution(a));
    }

    @Test
    public void test2() throws Exception {
        int[] a = {0, 0, 0, 0, 0, 0};

        Assert.assertEquals(0, solution.solution(a));
    }

    @Test
    public void test3() throws Exception {
        int[] a = {1, 1, 1, 1, 1};

        Assert.assertEquals(7, solution.solution(a));
    }

}