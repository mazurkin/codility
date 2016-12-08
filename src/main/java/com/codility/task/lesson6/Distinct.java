package com.codility.task.lesson6;

import java.util.Arrays;

public class Distinct {

    public int solution(int[] a) {
        final int n = a.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(a);

        int d = 0;

        for (int l = 0, r = 1; r < n; r++) {
             if (a[l] == a[r]) {
                 d++;
             } else {
                 l = r;
             }
        }

        return n - d;
    }
}
