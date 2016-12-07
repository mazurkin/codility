package com.codility.challenge.alpha2010;

import java.util.BitSet;

/**
 * https://codility.com/programmers/task/prefix_set/
 */
public class PrefixSet {

    public int solution(int[] a) {
        final int n = a.length;

        final BitSet bs = new BitSet(n);

        int p = 0;
        for (int i = 0; i < n; i++) {
            final int v = a[i];

            if (!bs.get(v)) {
                bs.set(v);
                p = i;
            }
        }

        return p;
    }
}
