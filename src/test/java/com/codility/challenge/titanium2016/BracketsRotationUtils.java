package com.codility.challenge.titanium2016;

import java.util.Random;

public final class BracketsRotationUtils {

    private BracketsRotationUtils() {
    }

    public static String generateRandom(int length) {
        return generateRandom(length, 0.5, new Random());

    }

    public static String generateRandom(int n, double openBracketProbability, Random random) {
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            if (random.nextDouble() < openBracketProbability) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }

        return sb.toString();
    }

    public static String generateRandomValid(int n, Random random) {
        StringBuilder sb = new StringBuilder(n);

        int balance = 0;

        for (int i = 0; i < n; i++) {
            if (balance > 0) {
                if (balance < n - i) {
                    if (random.nextBoolean()) {
                        sb.append("(");
                        balance++;
                    } else {
                        sb.append(")");
                        balance--;
                    }
                } else {
                    sb.append(")");
                    balance--;
                }
            } else {
                sb.append("(");
                balance++;
            }
        }

        return sb.toString();
    }

    public static String generateRandomInvalid(int n, int openLimit, int closedLimit, Random random) {
        StringBuilder sb = new StringBuilder(n + openLimit + closedLimit);

        int balance = 0;
        int openCount = openLimit;
        int closeCount = closedLimit;

        for (int i = 0; i < n; i++) {
            if (balance > 0) {
                if (balance < n - i) {
                    if (random.nextBoolean()) {
                        sb.append("(");
                        balance++;
                    } else {
                        sb.append(")");
                        balance--;
                    }
                } else {
                    while (openCount > 0 && random.nextBoolean()) {
                        sb.append("(");
                        openCount--;
                    }

                    sb.append(")");
                    balance--;
                }
            } else {
                while (closeCount > 0 && random.nextBoolean()) {
                    sb.append(")");
                    closeCount--;
                }

                sb.append("(");
                balance++;
            }
        }

        for (int i = 0; i < openCount; i++) {
            sb.insert(sb.length(), '(');
        }

        for (int i = 0; i < closeCount; i++) {
            sb.insert(0, ')');
        }

        return sb.toString();
    }

}
