package com.adventofcode;

public class WayPoint {
    private int x;
    private int y;

    public WayPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(TravelInstruction instruction) {
        switch (instruction.getDirection()) {
            case 'S':
                y -= instruction.getLength();
                break;
            case 'N':
                y += instruction.getLength();
                break;
            case 'E':
                x += instruction.getLength();
                break;
            case 'W':
                x -= instruction.getLength();
                break;
        }
    }

    public void rotateClockwise(int degrees) {
        if(degrees < 90) {
            throw new RuntimeException("Rotation not supported.");
        }

        if(degrees > 90) {
            for(var i= degrees / 90; i > 0; i -= 1)
                rotateClockwise(90);
            return;
        }

        var oldX = x;
        x = y;
        y = oldX * -1;
    }

    public void rotateCounterClockwise(int degrees) {
        if(degrees < 90) {
            throw new RuntimeException("Rotation not supported.");
        }

        if(degrees > 90) {
            for(var i= degrees / 90; i > 0; i -= 1)
                rotateCounterClockwise(90);
            return;
        }

        var oldX = x;
        x = y * -1;
        y = oldX;
    }

}
