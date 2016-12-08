package com.codility.task.lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrogJmpTest {

    private FrogJmp solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new FrogJmp();
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3, solution.solution(10, 85, 30));

        Assert.assertEquals(3, solution.solution(10, 99, 30));
        Assert.assertEquals(3, solution.solution(10, 100, 30));
        Assert.assertEquals(4, solution.solution(10, 101, 30));

        Assert.assertEquals(1, solution.solution(999999999, 1000000000, 1000000000));

    }

}