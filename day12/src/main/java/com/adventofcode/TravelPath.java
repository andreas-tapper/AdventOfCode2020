package com.adventofcode;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TravelPath {
    private List<TravelInstruction> instructions = new ArrayList<>();

    public int manhattanDistance() {
        var boatDirection = new BoatDirection('E');
        var x = 0;
        var y = 0;

        for (TravelInstruction instruction : instructions) {
            var direction = instruction.getDirection();

            if(direction == 'F') {
                direction = boatDirection.getDirection();
            } else if(direction == 'L') {
                boatDirection.turnLeft(instruction.getLength());
                continue;
            } else if(direction == 'R') {
                boatDirection.turnRight(instruction.getLength());
                continue;
            }

            switch (direction) {
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

        return Math.abs(x) + Math.abs(y);
    }

    public int travelWithWayPoint() {
        var point = new WayPoint(10, 1);
        var x = 0;
        var y = 0;

        for (TravelInstruction instruction : instructions) {
            var direction = instruction.getDirection();

            if(direction == 'F') {
                x += point.getX() * instruction.getLength();
                y += point.getY() * instruction.getLength();
                continue;
            } else if(direction == 'L') {
                point.rotateCounterClockwise(instruction.getLength());
                continue;
            } else if(direction == 'R') {
                point.rotateClockwise(instruction.getLength());
                continue;
            }

            point.move(instruction);
        }

        return Math.abs(x) + Math.abs(y);
    }

    public static TravelPath parse(BufferedReader reader) {
        var path = new TravelPath();

        path.instructions = reader.lines()
                .map(x -> new TravelInstruction(x.charAt(0), Integer.parseInt(x.substring(1))))
                .collect(toList());

        return path;
    }
}
