package com.adventofcode;

public class Accumulator {
    private int value;

    public void increment(int other) {
        value += other;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }
}
