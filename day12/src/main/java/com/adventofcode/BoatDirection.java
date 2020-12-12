package com.adventofcode;

public class BoatDirection {
    private char direction;

    public BoatDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public void turnLeft(int degrees) {
        if(degrees < 90) {
            throw new RuntimeException("Turn not supported.");
        }

        if(degrees > 90) {
            for(var i= degrees / 90; i > 0; i -= 1)
                turnLeft(90);
            return;
        }

        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
            default:
                throw new RuntimeException("Cannot execute left turn.");
        }
    }

    public void turnRight(int degrees) {
        if(degrees < 90) {
            throw new RuntimeException("Turn not supported.");
        }

        if(degrees > 90) {
            for(var i= degrees / 90; i > 0; i -= 1)
                turnRight(90);
            return;
        }

        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
            default:
                throw new RuntimeException("Cannot execute left turn.");
        }
    }
}
