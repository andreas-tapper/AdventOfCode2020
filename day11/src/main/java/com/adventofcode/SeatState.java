package com.adventofcode;

public enum SeatState {
    FLOOR,
    FREE,
    OCCUPIED;

    public static SeatState parseState(int c) {
        switch (c) {
            case (int)'.':
                return FLOOR;
            case (int)'L':
                return FREE;
            case (int)'#':
                return OCCUPIED;
            default:
                throw new RuntimeException(String.format("Cannot parse %d into state.", c));
        }
    }
}
