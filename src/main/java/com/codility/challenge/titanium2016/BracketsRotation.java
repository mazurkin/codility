package com.codility.challenge.titanium2016;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 *
 * <pre>
 * Inspired by:
 * http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 * http://qa.geeksforgeeks.org/2551/minimum-reversal-to-make-brackets-balance-accenture?show=2551
 * http://stackoverflow.com/questions/29687542/find-the-minimum-number-of-edits-to-balance-parentheses
 * </pre>
 */
public class BracketsRotation {

    private static final char BRACKET_OPEN = '(';

    private static final char BRACKET_CLOSE = ')';

    public int solution(String s, int k) {
        assert k >= 0;

        if (s == null || s.length() < 2) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        if (isOdd(n)) {
            final int r1 = solution(chars, 0, n - 1, k);
            final int r2 = solution(chars, 1, n, k);
            return Math.max(r1, r2);
        } else {
            return solution(chars, 0, n, k);
        }
    }

    private int solution(final char[] chars, final int left, final int right, final int availableBudget) {
        final int count = right - left;
        assert isEven(count);

        final int maxRequiredBudget = count / 2 + 1;
        if (maxRequiredBudget <= availableBudget) {
            return count;
        }

        final Deque<Integer> closeBracketStack = new ArrayDeque<>(count);
        final Deque<Integer> openBracketStack = new ArrayDeque<>(count);

        for (int i = left; i < right; i++) {
            final char c = chars[i];

            if (c == BRACKET_CLOSE) {
                if (openBracketStack.isEmpty()) {
                    closeBracketStack.addLast(i);
                } else {
                    openBracketStack.removeLast();
                }
            } else {
                openBracketStack.addLast(i);
            }
        }

        // count orphans
        final int closeBracketCount = closeBracketStack.size();
        final int openBracketCount = openBracketStack.size();

        final int totalBracketCount = closeBracketCount + openBracketCount;
        assert isEven(totalBracketCount);

        final int actualRequiredBudget = (closeBracketCount + 1) / 2 + (openBracketCount + 1) / 2;
        if (actualRequiredBudget <= availableBudget) {
            return count;
        }

        // prepare combined array
        //   * ")" brackets = [1 ... closeBracketCount]
        //   * "(" brackets = [closeBracketCount + 1 ... totalBracketCount]
        final int[] bounds = new int[totalBracketCount + 2];
        int j = 0;

        bounds[j++] = left - 1;
        while (!closeBracketStack.isEmpty()) {
            bounds[j++] = closeBracketStack.removeFirst();
        }
        while (!openBracketStack.isEmpty()) {
            bounds[j++] = openBracketStack.removeFirst();
        }
        bounds[j] = right;

        // examine all combinations with proper budget
        int result = 0;

        for (int l = 0, r; l <= totalBracketCount; l++) {
            r = l + 2 * availableBudget;

            if (l < closeBracketCount && r > closeBracketCount && isOdd(closeBracketCount - l)) {
                r = r - 2;
                if (r < closeBracketCount) {
                    continue;
                }
            }

            if (r > totalBracketCount) {
                r = totalBracketCount;
                if (isOdd(r - l)) {
                    r--;
                }
            }

            assert isEven(r - l);

            final int length = bounds[r + 1] - bounds[l] - 1;
            assert isEven(length);

            result = Math.max(result, length);
        }

        return result;
    }

    private static boolean isOdd(int v) {
        return v % 2 == 1;
    }

    private static boolean isEven(int v) {
        return v % 2 == 0;
    }
}