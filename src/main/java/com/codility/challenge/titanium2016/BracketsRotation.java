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

    /**
     * time: O(n**2)
     * space: O(1)
     */
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

}