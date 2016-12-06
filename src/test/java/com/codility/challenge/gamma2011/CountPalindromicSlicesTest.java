package com.codility.challenge.gamma2011;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountPalindromicSlicesTest {

    private CountPalindromicSlices solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new CountPalindromicSlices();
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(6, solution.solution("baababa"));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(1, solution.solution("aza"));
        Assert.assertEquals(2, solution.solution("abba"));
        Assert.assertEquals(5, solution.solution("abacaba"));
    }
}