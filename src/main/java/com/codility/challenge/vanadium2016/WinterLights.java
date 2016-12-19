package com.codility.challenge.vanadium2016;

/**
 * https://codility.com/programmers/task/winter_lights/
 */
public class WinterLights {

    private static final int MODULO = 1000000007;

    public int solution(String s) {
        return solutionBest(s, 10);
    }

    /**
     * time: O(n)
     * space: O(n)
     */
    public int solutionBest(String s, int dictionarySize) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (dictionarySize < 1 || dictionarySize > 31) {
            throw new IllegalArgumentException("Dictionary size is invalid");
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        // Space is 2**dictionarySize (each symbol needs 1 bit of address space)
        final int capacity = 1 << dictionarySize;

        // Index of array is bitmask "b9/b8/b7/b6/b5/b4/b3/b2/b1/b0" where
        //   bX == 1 means that symbol X occurred odd times
        //   bX == 0 means that symbol X occurred even times
        final int[] counts = new int[capacity];

        int globalCount = 0;
        int globalMask = 0;

        for (int i = 0; i < n; i++) {
            final char c = chars[i];
            final int localMask = bitmask(c);

            // Non-modified `globalMask` equals to current 0-index
            counts[globalMask]++;

            // Remap internal addressing instead of array copying
            globalMask = globalMask ^ localMask;

            // The only good variants are (with history correction):
            // - when no set bits (all symbol counts are even)
            // - when only 1 bit is set (only 1 symbol count is odd)
            // Modified `globalMask` equals to modified 0-index
            int localCount = counts[globalMask];
            for (int j = 1; j < capacity; j = j << 1) {
                localCount += counts[j ^ globalMask];
            }

            globalCount = globalCount + localCount;
            globalCount = globalCount % MODULO;
        }

        return globalCount;
    }


    /**
     * time: O(n)
     * space: O(n)
     */
    public int solutionGood(String s, int dictionarySize) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        // Space is 2^dictionarySize when each symbol need 1 bit (odd or even)
        final int capacity = 1 << dictionarySize;

        // Index of array is bitmask "b10/b9/b8/b7/b6/b5/b4/b3/b2/b1" where
        //    bX == 1 means that X occurred odd times
        //    bX == 0 means that X occurred even times
        int[] counts1 = new int[capacity];
        int[] counts2 = new int[capacity];

        int globalCount = 0;

        for (int i = 0; i < n; i++) {
            final char c = chars[i];
            final int mask = bitmask(c);

            // Transferring counts for this mask (excessive copying is eliminated in the `best` method):
            // - from odd to even
            // - from even to odd
            for (int j = 0; j < capacity; j++) {
                counts2[j ^ mask] = counts1[j];
            }

            counts2[mask]++;

            // The only good variants are:
            // - when no set bits (all symbol counts are even)
            // - when only 1 bit is set (only 1 symbol count is odd)
            int localCount = counts2[0];
            for (int j = 1; j < capacity; j = j << 1) {
                localCount += counts2[j];
            }

            globalCount = globalCount + localCount;
            globalCount = globalCount % MODULO;

            final int[] tmp = counts1;
            counts1 = counts2;
            counts2 = tmp;
        }

        return globalCount;
    }

    /**
     * time: O(n**2)
     * space: O(1)
     */
    public int solutionSlow(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();

        int globalCount = 0;

        for (int i = 0; i < n; i++) {
            int mask = 0;
            int localCount = 0;

            for (int j = i; 0 <= j; j--) {
                mask = mask ^ bitmask(chars[j]);

                final int bits = Integer.bitCount(mask);
                if (bits < 2) {
                    localCount++;
                }
            }

            globalCount = globalCount + localCount;
            globalCount = globalCount % MODULO;
        }

        return globalCount;
    }

    private static int bitmask(char c) {
        return 1 << (c - '0');
    }

}
