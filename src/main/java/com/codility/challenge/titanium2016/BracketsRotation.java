package com.codility.challenge.titanium2016;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 */
public class BracketsRotation {

    public int solution(String s, int k) {
        return solutionSlow(s, k);
    }

    public int solutionSlow(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        int globalResult = 0;

        for (int i = 0; i < n; i++) {
            int balance = 0;
            int result = 0;
            int budget = k;

            for (int j = i, rest = n - j; j < n; j++, rest--) {
                if (chars[j] == '(') {
                    if (balance + 1 <= rest - 1) {
                        balance++;
                    } else if (budget > 0) {
                        balance--;
                        budget--;
                    } else {
                        break;
                    }
                } else {
                    if (balance > 0) {
                        balance--;
                    } else if (budget > 0) {
                        balance++;
                        budget--;
                    } else {
                        break;
                    }
                }

                if (balance == 0) {
                    result = Math.max(result, j - i + 1);
                }
            }

            globalResult = Math.max(globalResult, result);
        }

        return globalResult;
    }

    public int solutionFast(final String s, final int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int N = s.length();

        if (k >= N / 2 + 1) {
            return N;
        }

        final char[] brackets = s.toCharArray();

        return solutionFast(brackets, 0, N, k);
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