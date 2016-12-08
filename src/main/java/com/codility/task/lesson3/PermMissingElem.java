package com.codility.task.lesson3;

/**
 * https://codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {

    public int solution(int[] a) {
        final int n = a.length;
        final int max = n + 1;

        long actualSum = 0;
        for (int v : a) {
            actualSum = actualSum + v;
        }

        final long expectedSum = (long) max * (max + 1) / 2;

        return (int) (expectedSum - actualSum);
    }
}
