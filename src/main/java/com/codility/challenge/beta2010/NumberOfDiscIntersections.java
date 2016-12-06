package com.codility.challenge.beta2010;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    public int solution(int[] a) {
        final int MAX_COUNT = 10000000;

        final int n = a.length;
        if (n < 2) {
            return 0;
        }

        final long[] points = new long[2 * n];

        for (int i = 0, j = 0; i < n; i++) {
            final long r = a[i];
            final long c = i;

            // start point (comes first on sort)
            points[j++] = ((c - r) << 1);

            // end point (comes after on sort)
            points[j++] = ((c + r) << 1) + 1;
        }

        Arrays.sort(points);

        int result = 0;
        int tracker = 0;

        for (long point : points) {
            if ((point & 0x01) == 0) {
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
