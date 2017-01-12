package com.codility.challenge.scandium2016;

/**
 * https://codility.com/programmers/task/even_sums_game/
 */
public class EvenSumsGame {

    private static final String NO_SOLUTION_TEXT = "NO SOLUTION";

    public String solution(int[] a) {
        if (a == null || a.length == 0) {
            return NO_SOLUTION_TEXT;
        }

        final int n = a.length;

        long sum = 0;
        for (int v : a) {
            sum = sum + v;
        }

        // if the total sum is even - the result is the sequence itself
        if (isEven(sum)) {
            return Range.of(0, n - 1).toString();
        } else {
            Range solution = loop(a);
            return solution.toString();
        }
    }

    private static Range loop(int[] a) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            final int count = r - l + 1;

            // INVARIANT1: we know that total sum(a[l]..a[r]) is odd here

            // we have single odd number - we lose
            if (count == 1) {
                return Range.NO_SOLUTION;
            }

            // INVARIANT2: we know that count > 1 here
            // if count == 2 then one of a[l] or a[r] is odd for sure

            // if a[r] is odd then sum(a[l]..a[r-1]) is even
            if (isOdd(a[r])) {
                return new Range(l, r - 1);
            }

            // if a[l] is odd then sum(a[l+1]..a[r]) is even
            if (isOdd(a[l])) {
                return new Range(l + 1, r);
            }

            // INVARIANT3: we know that both a[l] and a[r] are even, so sum(a[l+1]..a[r-1]) is odd (because of INVARIANT1)

            // so we are moving to the inner sequence
            l++;
            r--;
        }

        throw new IllegalStateException("Impossible");
    }

    private static boolean isOdd(long v) {
        return v % 2 == 1;
    }

    private static boolean isEven(long v) {
        return v % 2 == 0;
    }

    private static class Range {

        private static final Range NO_SOLUTION = new Range(-1, -1);

        private final int l;

        private final int r;

        private Range(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public static Range of(int l, int r) {
            return new Range(l, r);
        }

        @Override
        public String toString() {
            if (l >= 0 && r >= l) {
                return String.format("%d,%d", l, r);
            } else {
                return NO_SOLUTION_TEXT;
            }
        }
    }

}
