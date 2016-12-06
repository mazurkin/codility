package com.codility.samples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

    private Palindrome solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new Palindrome();
    }

    @Test
    public void testPalindromePrimitive() throws Exception {
        Assert.assertEquals(3, solution.solutionPalindromePrimitive("aa"));
        Assert.assertEquals(4, solution.solutionPalindromePrimitive("aba"));
        Assert.assertEquals(9, solution.solutionPalindromePrimitive("ababa"));
        Assert.assertEquals(10, solution.solutionPalindromePrimitive("0123456789"));
    }

    @Test
    public void testPalindromeManacher() throws Exception {
        Assert.assertEquals(3, solution.solutionPalindromeManacher("aa"));
        Assert.assertEquals(4, solution.solutionPalindromeManacher("aba"));
        Assert.assertEquals(9, solution.solutionPalindromeManacher("ababa"));
        Assert.assertEquals(10, solution.solutionPalindromeManacher("0123456789"));
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(4, solution.solutionPalindromePrimitive("aza"));
        Assert.assertEquals(4, solution.solutionPalindromeManacher("aza"));

        Assert.assertEquals(6, solution.solutionPalindromePrimitive("abba"));
        Assert.assertEquals(6, solution.solutionPalindromeManacher("abba"));

        Assert.assertEquals(12, solution.solutionPalindromePrimitive("a1a2a1a"));
        Assert.assertEquals(12, solution.solutionPalindromeManacher("a1a2a1a"));
    }
}