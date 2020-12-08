package com.adventofcode;

public interface Instruction {
    int getArgument();
    int execute(int currentAddress);
}
