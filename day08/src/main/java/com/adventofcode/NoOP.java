package com.adventofcode;

public class NoOP implements Instruction {
    private int value;

    public NoOP(int value) {
        this.value = value;
    }

    public int getArgument() {
        return value;
    }

    @Override
    public int execute(int currentAddress) {
        return currentAddress + 1;
    }
}
