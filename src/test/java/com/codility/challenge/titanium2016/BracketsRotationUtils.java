package com.codility.challenge.titanium2016;

import java.util.Random;

public final class BracketsRotationUtils {

    private BracketsRotationUtils() {
    }

    public static String generateRandom(int length) {
        return generateRandom(length, 0.5, new Random());

    }

    public static String generateRandom(int length, double openBracketProbability, Random random) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            if (random.nextDouble() < openBracketProbability) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }

        return sb.toString();
    }

}
