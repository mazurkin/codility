package com.codility.task.lesson3;

/**
 * https://codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {

    public int solution(int[] a) {
        final int n = a.length;

        final int[] runningSum = new int[n];

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
            runningSum[i] = totalSum;
        }

        int m = Integer.MAX_VALUE;
        for (int i = 1;  i < n; i++) {
            final int s1 = runningSum[i - 1];
            final int s2 = totalSum - s1;

            final int r = Math.abs(s1 - s2);

            if (r < m) {
                m = r;
            }
        }

        return m;
    }
}
