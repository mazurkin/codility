package com.codility.challenge.titanium2016;

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
    public void test12() throws Exception {
        Assert.assertEquals(8, solution.solution("))()()((", 2));
        Assert.assertEquals(8, solution.solution("))()()((", 4));
        Assert.assertEquals(8, solution.solution("))()()((", 5));
        Assert.assertEquals(8, solution.solution("))()()((", 6));
        Assert.assertEquals(8, solution.solution("))()()((", 8));
        Assert.assertEquals(8, solution.solution("))()()((", 100));

        Assert.assertEquals(8, solution.solution("))()()()", 2));
        Assert.assertEquals(8, solution.solution("))()()()", 4));
        Assert.assertEquals(8, solution.solution("))()()()", 5));
        Assert.assertEquals(8, solution.solution("))()()()", 6));
        Assert.assertEquals(8, solution.solution("))()()()", 8));
        Assert.assertEquals(8, solution.solution("))()()()", 100));

        Assert.assertEquals(8, solution.solution("()()()((", 2));
        Assert.assertEquals(8, solution.solution("()()()((", 4));
        Assert.assertEquals(8, solution.solution("()()()((", 5));
        Assert.assertEquals(8, solution.solution("()()()((", 6));
        Assert.assertEquals(8, solution.solution("()()()((", 8));
        Assert.assertEquals(8, solution.solution("()()()((", 100));

        Assert.assertEquals(8, solution.solution("()))((()", 2));
        Assert.assertEquals(8, solution.solution("()))((()", 4));
        Assert.assertEquals(8, solution.solution("()))((()", 5));
        Assert.assertEquals(8, solution.solution("()))((()", 6));

        Assert.assertEquals(8, solution.solution("()))((()(", 2));
        Assert.assertEquals(8, solution.solution("()))((()(", 4));
        Assert.assertEquals(8, solution.solution("()))((()(", 5));
        Assert.assertEquals(8, solution.solution("()))((()(", 6));

        Assert.assertEquals(8, solution.solution(")()))((()", 2));
        Assert.assertEquals(8, solution.solution(")()))((()", 4));
        Assert.assertEquals(8, solution.solution(")()))((()", 5));
        Assert.assertEquals(8, solution.solution(")()))((()", 6));

        Assert.assertEquals(8, solution.solution(")))()()(", 4));
    }

    @Test
    public void testRandomValid() throws Exception {
        Random random = new Random(1);

        for (int i = 0, limit = 16 * 1024; i < limit; i++) {
            final int n = 2 * (1 + random.nextInt(64));
            final String brackets = BracketsRotationUtils.generateRandomValid(n, random);

            Assert.assertEquals(brackets, n, solution.solution(brackets, 0));
            Assert.assertEquals(brackets, n, solution.solution(brackets, 1));
            Assert.assertEquals(brackets, n, solution.solution(brackets, 2));
            Assert.assertEquals(brackets, n, solution.solution(brackets, 3));
        }
    }

    @Test
    public void testRandomInvalid() throws Exception {
        Random random = new Random(1);

        for (int i = 0, limit = 16 * 1024; i < limit; i++) {
            final int n = 2 * (1 + random.nextInt(64));
            final int invalid = 2 * (1 + random.nextInt(n));
            final int openCount = random.nextInt(invalid + 1);
            final int closedCount = invalid - openCount;
            final String brackets = BracketsRotationUtils.generateRandomInvalid(n, openCount, closedCount, random);

            final int total = n + invalid;
            final String description = String.format("b=%s, n=%d, (=%d, )=%d", brackets, n, openCount, closedCount);

            Assert.assertNotEquals(description, total, solution.solution(brackets, 0));
            Assert.assertNotEquals(description, total, solution.solution(brackets, invalid / 2 - 1));

            Assert.assertEquals(description, total, solution.solution(brackets, invalid));
            Assert.assertEquals(description, total, solution.solution(brackets, invalid + 1));
            Assert.assertEquals(description, total, solution.solution(brackets, invalid + 2));
            Assert.assertEquals(description, total, solution.solution(brackets, invalid * 2));
        }
    }

    @Test
    public void testMassive1() throws Exception {
        final int depth = 6;

        BracketsRotationUtils.iterateAll(depth, (s) ->
                Assert.assertEquals(s, 2 * depth, solution.solution(s, 0)));

    }

    @Test
    public void testMassive2() throws Exception {
        final int depth = 6;

        BracketsRotationUtils.iterateAll(depth, (s) -> {
            final String m = ")" + s + "(";
            Assert.assertEquals(m, 2 * depth, solution.solution(m, 0));
            Assert.assertEquals(m, 2 * depth, solution.solution(m, 1));
            Assert.assertEquals(m, 2 * depth + 2, solution.solution(m, 2));
        });
    }

    @Test
    public void testInvalid() throws Exception {
        for (int close = 1; close < 7; close++) {
            for (int open = 1; open < 7; open++) {
                final String brackets = BracketsRotationUtils.generateInvalid(close, open);

                Assert.assertEquals(brackets, 0, solution.solution(brackets, 0));
                Assert.assertNotEquals(brackets, 0, solution.solution(brackets, 2));
            }
        }

    }
}