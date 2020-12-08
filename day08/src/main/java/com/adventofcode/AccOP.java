package com.adventofcode;

public class AccOP implements Instruction {
    private final Accumulator accumulator;
    private final int value;

    public AccOP(Accumulator accumulator, int value) {
        this.accumulator = accumulator;
        this.value = value;
    }

    @Override
    public int getArgument() {
        return value;
    }

    @Override
    public int execute(int currentAddress) {
        accumulator.increment(value);
        return currentAddress + 1;
    }
}
