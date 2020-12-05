package com.adventofcode;

public class Seat {
    private int row;
    private int column;

    public int getColumn() {
        return column;
    }

    public int getId() {
        return (row * 8) + column;
    }

    public int getRow() {
        return row;
    }

    public static Seat of(String text) {
        var seat = new Seat();

        var lowerBound = 0;
        var upperBound = 127;
        for(var i=0; i < 7; i += 1) {
            var direction = text.charAt(i);
            var range = upperBound - lowerBound;
            if(direction == 'F') upperBound -= Math.ceil(range / 2f);
            if(direction == 'B') lowerBound += Math.ceil(range / 2f);
        }

        if(lowerBound != upperBound) throw new RuntimeException(String.format("Failed to locate row for '%s'", text));
        seat.row = lowerBound;

        lowerBound = 0;
        upperBound = 7;
        for(var i=7; i < text.length(); i += 1) {
            var direction = text.charAt(i);
            var range = upperBound - lowerBound;
            if(direction == 'L') upperBound -= Math.ceil(range / 2f);
            if(direction == 'R') lowerBound += Math.ceil(range / 2f);
        }

        if(lowerBound != upperBound) throw new RuntimeException(String.format("Failed to locate column for '%s'", text));
        seat.column = lowerBound;

        return seat;
    }
}
