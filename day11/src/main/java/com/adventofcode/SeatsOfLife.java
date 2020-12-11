package com.adventofcode;

import java.io.BufferedReader;

import static java.util.stream.Collectors.toList;

public class SeatsOfLife {
    private SeatLayout layout = new SeatLayout();

    public long occupiedSeatsWhenV1() {
        while (layout.iterate() > 0) {
            // Maybe a sanity check here?
        }

        return layout.count(SeatState.OCCUPIED);
    }

    public long occupiedSeatsWhenV2() {
        while (layout.iterateV2() > 0) {
            // Maybe a sanity check here?
        }

        return layout.count(SeatState.OCCUPIED);
    }

    public static SeatsOfLife parse(BufferedReader reader) {
        var game = new SeatsOfLife();

        reader.lines().forEach(line -> {
            game.layout.addRow(line.chars()
                    .mapToObj(SeatState::parseState)
                    .collect(toList()));
        });

        return game;
    }
}
