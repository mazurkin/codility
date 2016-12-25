package com.codility.challenge.titanium2016;

/**
 * https://codility.com/programmers/task/brackets_rotation/
 *
 * <pre>
 * time: O(n**2)
 * space: O(1)
 * </pre>
 */
public class BracketsRotationSlow {

    private static final char BRACKET_OPEN = '(';

    private static final char BRACKET_CLOSE = ')';

    public int solution(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        int result = 0;

        for (int i = 0; result < n - i; i++) {
            int balance = 0;
            int budget = k;

            for (int j = i; j < n; j++) {
                final char c = chars[j];

                if (c == BRACKET_OPEN) {
                    if (balance + 1 <= (n - j) - 1) {
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
        }

        return result;
    }

}