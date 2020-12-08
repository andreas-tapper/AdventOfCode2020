package com.adventofcode;

public class JumpOP implements Instruction {
    private int jump;

    public JumpOP(int jump) {
        this.jump = jump;
    }

    public int getArgument() {
        return jump;
    }

    @Override
    public int execute(int currentAddress) {
        return currentAddress + jump;
    }
}
