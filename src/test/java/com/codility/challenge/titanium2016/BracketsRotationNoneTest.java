package com.codility.challenge.titanium2016;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BracketsRotationNoneTest {

    private BracketsRotationNone solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new BracketsRotationNone();
    }

    @Test
    public void test0() throws Exception {
        Assert.assertEquals(0, solution.solution(")))))((((("));
        Assert.assertEquals(0, solution.solution("))(((((((("));
        Assert.assertEquals(0, solution.solution("))))))))(("));

        Assert.assertEquals(0, solution.solution("))))))))))"));
        Assert.assertEquals(0, solution.solution("(((((((((("));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(2, solution.solution("(()(()(()"));
        Assert.assertEquals(2, solution.solution("())())())"));

        Assert.assertEquals(2, solution.solution("(((()(((()(((()"));
        Assert.assertEquals(2, solution.solution("())))())))())))"));

        Assert.assertEquals(2, solution.solution("()"));

        Assert.assertEquals(2, solution.solution(")))))()(((((("));
        Assert.assertEquals(2, solution.solution("())))))))))))"));
        Assert.assertEquals(2, solution.solution("(((((((((((()"));
    }

    @Test
    public void test4() throws Exception {
        Assert.assertEquals(4, solution.solution("()()"));
        Assert.assertEquals(4, solution.solution("(())"));

        Assert.assertEquals(4, solution.solution(")()))(())((()("));
        Assert.assertEquals(4, solution.solution("(())((()((()(("));
        Assert.assertEquals(4, solution.solution("))()))()))(())"));
    }

    @Test
    public void test6() throws Exception {
        Assert.assertEquals(6, solution.solution("()()()"));
        Assert.assertEquals(6, solution.solution("((()))"));
        Assert.assertEquals(6, solution.solution("()(())"));
        Assert.assertEquals(6, solution.solution("(())()"));

        Assert.assertEquals(6, solution.solution("(((((((())()"));
        Assert.assertEquals(6, solution.solution("(())()))))))"));
    }
}