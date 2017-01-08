package com.codility.challenge.titanium2016;

import java.util.Random;
import java.util.function.Consumer;

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

    public static void iterateAll(int depth, Consumer<String> validator) {
        iterateAll(validator, depth, 0, "");
    }

    // http://stackoverflow.com/a/3172190/827139
    public static void iterateAll(Consumer<String> validator, int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            validator.accept(s);
        }

        if (openStock > 0) {
            iterateAll(validator, openStock - 1, closeStock + 1, s + "(");
        }

        if (closeStock > 0) {
            iterateAll(validator, openStock, closeStock - 1, s + ")");
        }
    }

    public static String generateInvalid(int closeCount, int openCount) {
        StringBuilder sb = new StringBuilder(closeCount + openCount);

        for (int i = 0; i < closeCount; i++) {
            sb.append(")");
        }

        for (int i = 0; i < openCount; i++) {
            sb.append("(");
        }

        return sb.toString();
    }

}
