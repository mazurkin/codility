package com.codility.challenge.titanium2016;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 */
public class BracketsRotation {

    public int solution(final String s, final int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int N = s.length();

        if (k >= N / 2 + 1) {
            return N;
        }

        final char[] brackets = s.toCharArray();

        return solution(brackets, 0, N, k);
    }

    private int solution(final char[] brackets, final int offset, final int count, final int k) {
        if (count < 2) {
            return 0;
        }

        if (count % 2 == 1) {
            final int r1 = solution(brackets, offset, count - 1, k);
            final int r2 = solution(brackets, offset + 1, count - 1, k);
            return Math.max(r1, r2);
        }

        int r1 = 0;

        final int r2 = solution(brackets, offset + 1, count - 1, k);

        return Math.max(r1, r2);
    }


}