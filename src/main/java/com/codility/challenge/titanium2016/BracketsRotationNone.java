package com.codility.challenge.titanium2016;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 *
 * No rotation is allowed
 * time: O(n)
 * space: O(n)
 */
public class BracketsRotationNone {

    private static final char BRACKET_OPEN = '(';

    private static final char BRACKET_CLOSE = ')';

    public int solution(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        final Deque<Integer> stack = new ArrayDeque<>(n);

        final int[] matches = new int[n];
        Arrays.fill(matches, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            final char c = chars[i];

            if (c == BRACKET_OPEN) {
                stack.addLast(i);
            } else if (c == BRACKET_CLOSE) {
                if (!stack.isEmpty()) {
                    final int openBracketIndex = stack.removeLast();
                    matches[openBracketIndex] = i;
                }
            } else {
                throw new IllegalArgumentException("Unknown char: " + c);
            }
        }

        int result = 0;
        int pending = 0;
        for (int i = 0; i < n; i++) {
            final int closedBracketIndex = matches[i];
            if (closedBracketIndex > i) {
                pending += closedBracketIndex - i + 1;
                result = Math.max(result, pending);
                i = closedBracketIndex;
            } else {
                pending = 0;
            }
        }

        return result;
    }

}