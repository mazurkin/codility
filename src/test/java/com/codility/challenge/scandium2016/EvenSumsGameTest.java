package com.codility.challenge.scandium2016;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvenSumsGameTest {

    private EvenSumsGame solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new EvenSumsGame();
    }

    @Test
    public void test0() throws Exception {
        Assert.assertEquals("1,2", solution.solution(new int[] {4, 5, 3, 7, 2}));
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals("NO SOLUTION", solution.solution(new int[] {}));
        Assert.assertEquals("NO SOLUTION", solution.solution(new int[] {1}));
        Assert.assertEquals("NO SOLUTION", solution.solution(new int[] {2, 1, 2}));
        Assert.assertEquals("NO SOLUTION", solution.solution(new int[] {2, 2, 1, 2, 2}));
        Assert.assertEquals("NO SOLUTION", solution.solution(new int[] {2, 2, 2, 1, 2, 2, 2}));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertNotEquals("NO SOLUTION", solution.solution(new int[] {2}));
        Assert.assertNotEquals("NO SOLUTION", solution.solution(new int[] {2, 2}));
        Assert.assertNotEquals("NO SOLUTION", solution.solution(new int[] {2, 2, 2}));
        Assert.assertNotEquals("NO SOLUTION", solution.solution(new int[] {2, 2, 1, 2}));
        Assert.assertNotEquals("NO SOLUTION", solution.solution(new int[] {2, 1, 2, 2}));
    }

}
