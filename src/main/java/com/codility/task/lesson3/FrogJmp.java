package com.codility.task.lesson3;

public class FrogJmp {

    public int solution(int x, int y, int d) {
        final long distance = y - x;

        return (int) ((distance + (d - 1)) / d);
    }
}
