package com.adventofcode;

public class TravelInstruction {
    private char direction;
    private int length;

    public TravelInstruction(char direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public char getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }
}
