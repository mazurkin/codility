package com.codility.challenge.vanadium2016;

/**
 * https://codility.com/programmers/task/winter_lights/
 *
 * Fast solution will be published when the challenge ends
 */
public class WinterLights {

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
        }

        return globalCount;
    }

    private static int bitmask(char c) {
        return 1 << (c - '0');
    }



}
