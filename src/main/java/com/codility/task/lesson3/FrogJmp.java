package com.codility.task.lesson3;

/**
 * https://codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJmp {

    public int solution(int x, int y, int d) {
        final long distance = y - x;

        return (int) ((distance + (d - 1)) / d);
    }
}
