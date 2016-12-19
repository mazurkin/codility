package com.codility.challenge.beta2010;

import java.util.Arrays;

/**
 * https://codility.com/programmers/task/number_of_disc_intersections/
 */
public class NumberOfDiscIntersections {

    private static final int END_MASK = 0x01;

    public int solution(int[] a) {
        final int MAX_COUNT = 10000000;

        final int n = a.length;
        if (n < 2) {
            return 0;
        }

        final long[] points = new long[2 * n];

        for (int i = 0, j = 0; i < n; i++) {
            final long radius = a[i];
            final long center = i;

            // start point (comes first on sort)
            points[j++] = ((center - radius) << 1);

            // end point (comes after on sort)
            points[j++] = ((center + radius) << 1) | END_MASK;
        }

        Arrays.sort(points);

        int result = 0;
        int tracker = 0;

        for (long point : points) {
            if ((point & END_MASK) == 0) {
                result += tracker;

                if (result > MAX_COUNT) {
                    return -1;
                }

                tracker++;
            } else {
                tracker--;
            }
        }

        return result;
    }
}
