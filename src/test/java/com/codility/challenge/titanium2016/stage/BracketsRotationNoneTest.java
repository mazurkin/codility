package com.codility.challenge.titanium2016.stage;

import com.codility.challenge.titanium2016.stage.BracketsRotationNone;
import com.codility.challenge.titanium2016.stage.BracketsRotationSlow;
import com.codility.challenge.titanium2016.util.BracketsRotationUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

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

    @Test
    public void testVerifier() throws Exception {
        BracketsRotationSlow verifier = new BracketsRotationSlow();
        Random random = new Random(1);

        for (int i = 0; i < 128; i++) {
            final int length = 4 + random.nextInt(256);
            final String brackets = BracketsRotationUtils.generateRandom(length, 0.5, random);

            final int r1 = verifier.solution(brackets, 0);
            final int r2 = solution.solution(brackets);
            Assert.assertEquals(brackets, r1, r2);
        }
    }
}