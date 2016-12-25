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
        if (s == null || s.length() < 2) {
            return 0;
        }

        if (k < 0) {
            throw new IllegalArgumentException("k value is invalid");
        }

        final int n = s.length();

        final int maxRequiredBudget = n / 2 + 1;
        if (maxRequiredBudget <= k) {
            return isOdd(n) ? n - 1 : n;
        }

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
        final int swing = 2 * availableBudget;

        final Deque<Integer> openBracketStack = new ArrayDeque<>(count);
        final Deque<Integer> closeBracketStack = new ArrayDeque<>(count);

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
        final int openBracketCount = openBracketStack.size();
        final int closeBracketCount = closeBracketStack.size();
        final int totalBracketCount = openBracketCount + closeBracketCount;

        final int requiredBudget = (openBracketCount + 1) / 2 + (closeBracketCount + 1) / 2;
        if (requiredBudget <= availableBudget) {
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
            r = l + swing;

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

            final int length = bounds[r + 1] - bounds[l] - 1;
            result = Math.max(result, length);
        }

        /*

        if (closeBracketCount >= swing) {
            for (int i = 0, limit = closeBracketCount - swing, l = 0, r = l + 1 + swing;
                 i <= limit; i++, l++, r++)
            {
                final int length = bounds[r] - bounds[l] - 1;
                result = Math.max(result, length);
            }
        }

        if (openBracketCount >= swing) {
            for (int i = 0, limit = openBracketCount - swing, l = closeBracketCount, r = l + 1 + swing;
                 i <= limit; i++, l++, r++)
            {
                final int length = bounds[r] - bounds[l] - 1;
                result = Math.max(result, length);
            }
        }

        if (isOdd(closeBracketCount) && availableBudget > (closeBracketCount + 1) / 2) {
            final int overheadBudget = availableBudget - (closeBracketCount + 1) / 2;
            final int l = 0;
            final int r = Math.min(closeBracketCount + overheadBudget * 2, totalBracketCount + 1);
            final int length = bounds[r] - bounds[l] - 1;
            result = Math.max(result, length);
        }

        if (isOdd(openBracketCount) && availableBudget > (openBracketCount + 1) / 2) {
            final int overheadBudget = availableBudget - (openBracketCount + 1) / 2;
            final int l = Math.max(closeBracketCount - overheadBudget * 2 + 1, 0);
            final int r = totalBracketCount + 1;
            final int length = bounds[r] - bounds[l] - 1;
            result = Math.max(result, length);
        }

        if (availableBudget >= 2 && closeBracketCount > 1 && openBracketCount > 1) {
            final int limitL = Math.min(closeBracketCount / 2, availableBudget - 1);
            final int limitR = openBracketCount / 2;
            int l = closeBracketCount - 2 * limitL;
            int r = closeBracketCount + 1 + 2 * Math.min(limitR, availableBudget - limitL);

            for (int i = 0; i < limitL && i < limitR; i++, l += 2, r += 2)
            {
                final int length = bounds[r] - bounds[l] - 1;
                result = Math.max(result, length);
            }
        }
        */

        return result;
    }

    private static boolean isOdd(int v) {
        return v % 2 == 1;
    }

    private static boolean isEven(int v) {
        return v % 2 == 0;
    }
}