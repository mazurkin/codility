package com.codility.task.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistinctTest {

    private Distinct solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new Distinct();
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(3, solution.solution(new int[] {2, 1, 1, 2, 3, 1}));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(1, solution.solution(new int[] {1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(1, solution.solution(new int[] {1}));
        Assert.assertEquals(0, solution.solution(new int[] {}));
    }
}