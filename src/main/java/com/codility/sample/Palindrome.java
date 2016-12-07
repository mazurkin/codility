package com.codility.sample;

/**
 * http://e-maxx.ru/algo/palindromes_count
 */
public class Palindrome {

    public final int solutionPalindromePrimitive(String s) {
        final char[] chars = s.toCharArray();
        final int n = chars.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            int d1 = 1;
            while (i - d1 >= 0 && i + d1 < n && chars[i - d1] == chars[i + d1]) {
                d1++;
            }

            int d2 = 0;
            while (i - d2 - 1 >= 0 && i + d2 < n && chars[i - d2 - 1] == chars[i + d2]) {
                d2++;
            }

            total = total + d1 + d2;
        }

        return total;
    }

    public final int solutionPalindromeManacher(String s) {
        final char[] chars = s.toCharArray();
        final int n = chars.length;

        final int[] d1 = new int[n];
        final int[] d2 = new int[n];

        {
            int l = 0;
            int r = -1;

            for (int i = 0; i < n; i++) {
                int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i);

                while (0 <= i - k &&  i + k < n && chars[i - k] == chars[i + k]) {
                    k++;
                }

                d1[i] = k--;

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

                while (0 <= i - k - 1 && i + k < n && chars[i - k - 1] == chars[i + k]) {
                    k++;
                }

                d2[i] = k;

                if (i + k - 1 > r) {
                    l = i - k;
                    r = i + k - 1;
                }
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + d1[i] + d2[i];
        }

        return total;
    }
}
