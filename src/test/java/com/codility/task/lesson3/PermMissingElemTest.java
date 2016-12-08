package com.codility.task.lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermMissingElemTest {

    private PermMissingElem solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new PermMissingElem();
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(1, solution.solution(new int[] {}));
        Assert.assertEquals(1, solution.solution(new int[] {2}));
        Assert.assertEquals(4, solution.solution(new int[] {2, 3, 1, 5}));
    }
}