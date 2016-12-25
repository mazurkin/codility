package com.codility.challenge.titanium2016;

import com.codility.challenge.titanium2016.stage.BracketsRotationSlow;
import com.codility.challenge.titanium2016.util.BracketsRotationUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BracketsRotationTest {

    private BracketsRotation solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new BracketsRotation();
    }

    @Test
    public void testNull() throws Exception {
        Assert.assertEquals(0, solution.solution(null, 0));
        Assert.assertEquals(0, solution.solution(null, 2));
        Assert.assertEquals(0, solution.solution("", 0));
        Assert.assertEquals(0, solution.solution("", 2));
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(6, solution.solution("((()))", 0));
        Assert.assertEquals(6, solution.solution("((()))", 1));
        Assert.assertEquals(6, solution.solution("((()))", 2));
        Assert.assertEquals(6, solution.solution("((()))", 3));
        Assert.assertEquals(6, solution.solution("((()))", 4));
        Assert.assertEquals(6, solution.solution("((()))", 5));
        Assert.assertEquals(6, solution.solution("((()))", 6));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(0, solution.solution(")))(((", 0));
        Assert.assertEquals(2, solution.solution(")))(((", 1));
        Assert.assertEquals(4, solution.solution(")))(((", 2)); // )()()(
        Assert.assertEquals(6, solution.solution(")))(((", 4)); // ()()(), ()(()), (()())
        Assert.assertEquals(6, solution.solution(")))(((", 6));
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(2, solution.solution("))()((", 0));
        Assert.assertEquals(6, solution.solution("))()((", 2)); // ()()()
        Assert.assertEquals(6, solution.solution("))()((", 4)); // ()()(), ((())), ()(())
        Assert.assertEquals(6, solution.solution("))()((", 6));
    }

    @Test
    public void test4() throws Exception {
        Assert.assertEquals(2, solution.solution("))()((", 0));
        Assert.assertEquals(6, solution.solution("))()((", 2)); // ()()()
        Assert.assertEquals(6, solution.solution("))()((", 4));
        Assert.assertEquals(6, solution.solution("))()((", 6));
    }

    @Test
    public void test5() throws Exception {
        // - compaction algorithm is bad ('(()))(())' -> '4)4')
        // - greedy algorithm is bad
        Assert.assertEquals(4, solution.solution("(()))(())", 0));
        Assert.assertEquals(8, solution.solution("(()))(())", 1)); // (()()(())
    }

    @Test
    public void test6() throws Exception {
        Assert.assertEquals(6, solution.solution(")((()()(", 1));
        Assert.assertEquals(6, solution.solution(")()()))(", 1));

        Assert.assertEquals(4, solution.solution(")()()(", 0));
        Assert.assertEquals(4, solution.solution(")()()(", 1));
        Assert.assertEquals(6, solution.solution(")()()(", 2));

        Assert.assertEquals(4, solution.solution("))()()((", 0));
        Assert.assertEquals(6, solution.solution("))()()((", 1));
        Assert.assertEquals(8, solution.solution("))()()((", 2));

        Assert.assertEquals(4, solution.solution(")))()()(((", 0));
        Assert.assertEquals(6, solution.solution(")))()()(((", 1));
        Assert.assertEquals(8, solution.solution(")))()()(((", 2));
    }

    @Test
    public void test7() throws Exception {
        Assert.assertEquals(2, solution.solution(")))(", 2));
        Assert.assertEquals(2, solution.solution(")(((", 2));

        Assert.assertEquals(0, solution.solution(")(", 1));
        Assert.assertEquals(2, solution.solution(")(", 2));

        Assert.assertEquals(2, solution.solution("))((", 1));
        Assert.assertEquals(4, solution.solution("))((", 2));

        Assert.assertEquals(4, solution.solution("))(((", 2));
        Assert.assertEquals(4, solution.solution(")))((", 2));

        Assert.assertEquals(2, solution.solution(")))(((", 1));
        Assert.assertEquals(4, solution.solution(")))(((", 2));
        Assert.assertEquals(4, solution.solution(")))(((", 3));
        Assert.assertEquals(6, solution.solution(")))(((", 4));

        Assert.assertEquals(2, solution.solution(")(((", 2));
        Assert.assertEquals(4, solution.solution(")(((", 3));

        Assert.assertEquals(4, solution.solution(")(((((", 3));
        Assert.assertEquals(6, solution.solution(")(((((", 4));

        Assert.assertEquals(6, solution.solution(")(((((((", 4));
        Assert.assertEquals(8, solution.solution(")(((((((", 5));
    }

    @Test
    public void test8() throws Exception {
        Assert.assertEquals(4, solution.solution(")(((((", 3));
        Assert.assertEquals(6, solution.solution("))((((", 3));
        Assert.assertEquals(4, solution.solution(")))(((", 3));
        Assert.assertEquals(6, solution.solution("))))((", 3));
        Assert.assertEquals(4, solution.solution(")))))(", 3));
    }

    @Test
    public void test9() throws Exception {
        Assert.assertEquals(2, solution.solution("((()", 0));
        Assert.assertEquals(4, solution.solution("((()", 1));

        Assert.assertEquals(2, solution.solution("()))", 0));
        Assert.assertEquals(4, solution.solution("()))", 1));

        Assert.assertEquals(4, solution.solution("(((())", 0));
        Assert.assertEquals(6, solution.solution("(((())", 1));

        Assert.assertEquals(4, solution.solution("(())))", 0));
        Assert.assertEquals(6, solution.solution("(())))", 1));

        Assert.assertEquals(6, solution.solution("((()(())", 0));
        Assert.assertEquals(8, solution.solution("((()(())", 1));

        Assert.assertEquals(6, solution.solution("(())()))", 0));
        Assert.assertEquals(8, solution.solution("(())()))", 1));
    }

    @Test
    public void test10() throws Exception {
        Assert.assertEquals(4, solution.solution("(()))()", 0));
        Assert.assertEquals(6, solution.solution("(()))()", 1));
    }

    @Test
    public void test11() throws Exception {
        Assert.assertEquals(4, solution.solution("))))))", 2));
        Assert.assertEquals(4, solution.solution("((((((", 2));

        Assert.assertEquals(14, solution.solution(")())())())())())", 2));
        Assert.assertEquals(14, solution.solution("(()(()(()(()(()(", 2));

        Assert.assertEquals(4, solution.solution(")))))))", 2));
        Assert.assertEquals(4, solution.solution("(((((((", 2));
    }

    @Test
    public void testVerifier() throws Exception {
        BracketsRotationSlow verifier = new BracketsRotationSlow();
        Random random = new Random(1);

        for (int i = 0; i < 128; i++) {
            final int length = 4 + random.nextInt(256);
            final int budget = random.nextInt(length);
            final String brackets = BracketsRotationUtils.generateRandom(length, 0.5, random);

            final int r1 = verifier.solution(brackets, budget);
            final int r2 = solution.solution(brackets, budget);
            Assert.assertEquals(String.format("s=%s, l=%d, b=%d", brackets, length, budget), r1, r2);
        }
    }
}