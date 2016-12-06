package com.codility.challenge.gamma2011;

/**
 * https://codility.com/programmers/task/count_palindromic_slices/
 */
public class CountPalindromicSlices {

    public int solution(String s) {
        final int MAX_COUNT = 100000000;

        final char[] chars = s.toCharArray();
        final int n = chars.length;

        final int[] d1 = new int[n];
        final int[] d2 = new int[n];

        int total = 0;

        {
            int l = 0;
            int r = -1;

            for (int i = 0; i < n; i++) {
                int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i);

                for (int ll = i - k, rr = i + k; 0 <= ll && rr < n; ll--, rr++, k++) {
                    if (chars[ll] != chars[rr]) {
                        break;
                    }
                }

                d1[i] = k--;

                if (k > 0) {
                    total = total + k;
                    if (total > MAX_COUNT) {
                        return -1;
                    }
                }

                if (i + k > r) {
                    l = i - k;
                    r = i + k;
                }
            }
        }

        {
            int l = 0;
            int r = -1;

            for (int i = 0; i < n; i++) {
                int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);

                for (int ll = i - k - 1, rr = i + k; 0 <= ll && rr < n; ll--, rr++, k++) {
                    if (chars[ll] != chars[rr]) {
                        break;
                    }
                }

                d2[i] = k;

                if (k > 0) {
                    total = total + k;
                    if (total > MAX_COUNT) {
                        return -1;
                    }
                }

                if (i + k - 1 > r) {
                    l = i - k;
                    r = i + k - 1;
                }
            }
        }

        return total;
    }
}
