package com.codility.challenge.titanium2016;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 */
public class BracketsRotation {

    private static final char BRACKET_OPEN = '(';

    private static final char BRACKET_CLOSE = ')';

    public int solution(String s, int k) {
        return solutionSlow(s, k);
    }

    public int solutionSlow(final String s, final int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int balance = 0;
            int budget = k;

            int rest = n - i;
            if (rest <= result) {
                break;
            }

            for (int j = i; j < n; j++, rest--) {
                final char c = chars[j];

                if (c == BRACKET_OPEN) {
                    if (balance + 1 <= rest - 1) {
                        balance++;
                    } else if (budget > 0) {
                        balance--;
                        budget--;
                    } else {
                        break;
                    }
                } else if (c == BRACKET_CLOSE){
                    if (balance > 0) {
                        balance--;
                    } else if (budget > 0) {
                        balance++;
                        budget--;
                    } else {
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Unknown char: " + c);
                }

                if (balance == 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

    public int solutionFast(final String s, final int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        if (k >= n / 2 + 1) {
            return n;
        }

        final char[] brackets = s.toCharArray();

        return solutionFast(brackets, 0, n, k);
    }

    private int solutionFast(final char[] brackets, final int offset, final int count, final int k) {
        if (count < 2) {
            return 0;
        }

        if (count % 2 == 1) {
            final int r1 = solutionFast(brackets, offset, count - 1, k);
            final int r2 = solutionFast(brackets, offset + 1, count - 1, k);
            return Math.max(r1, r2);
        }

        int r1 = 0;

        final int r2 = solutionFast(brackets, offset + 1, count - 1, k);

        return Math.max(r1, r2);
    }


}