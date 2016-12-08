package com.codility.challenge.vanadium2016;

/**
 * https://codility.com/programmers/task/winter_lights/
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

//            System.out.printf("'%s'%n", s.substring(0, i + 1));
//            System.out.printf("step=%3d; local=%3d; loss=%3d; total=%3d%n",
//                    i + 1, localCount, i + 1 - localCount, globalCount);
//            System.out.println();
        }

        return globalCount;
    }

    private static int bitmask(char c) {
        return 1 << (c - '0');
    }



}
