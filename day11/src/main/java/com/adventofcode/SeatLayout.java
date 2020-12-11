package com.adventofcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.adventofcode.SeatState.*;

public class SeatLayout {
    private List<List<SeatState>> rows = new ArrayList<>();

    public void addRow(List<SeatState> row) {
        rows.add(row);
    }

    public int iterate() {
        int changes = 0;
        var newLayout = new ArrayList<List<SeatState>>();

        for(var i=0; i < rows.size(); i += 1) {
            var row = rows.get(i);
            var newRow = new ArrayList<SeatState>();
            newLayout.add(newRow);

            for(var j=0; j < row.size(); j += 1) {
                var adjacent = new Adjacent();
                // Row above
                adjacent.increment(at(i - 1, j - 1));
                adjacent.increment(at(i - 1, j));
                adjacent.increment(at(i - 1, j + 1));
                // To the left and right
                adjacent.increment(at(i, j - 1));
                adjacent.increment(at(i, j + 1));
                // Row below
                adjacent.increment(at(i + 1, j - 1));
                adjacent.increment(at(i + 1, j));
                adjacent.increment(at(i + 1, j + 1));

                var from = row.get(j);
                var to = from;

                if(from == FREE && adjacent.getOccupied() == 0) {
                    to = OCCUPIED;
                } else if(from == OCCUPIED && adjacent.getOccupied() >= 4) {
                    to = FREE;
                }

                newRow.add(to);

                if(from != to) {
                    changes += 1;
                }
            }
        }

        rows = newLayout;
        return changes;
    }

    public int iterateV2() {
        int changes = 0;
        var newLayout = new ArrayList<List<SeatState>>();

        for(var i=0; i < rows.size(); i += 1) {
            var row = rows.get(i);
            var newRow = new ArrayList<SeatState>();
            newLayout.add(newRow);

            for(var j=0; j < row.size(); j += 1) {
                var adjacent = new Adjacent();
                // Row above
                adjacent.increment(at(i, -1, j, -1));
                adjacent.increment(at(i, -1, j, 0));
                adjacent.increment(at(i, -1, j, 1));
                // To the left and right
                adjacent.increment(at(i, 0, j, -1));
                adjacent.increment(at(i, 0, j, 1));
                // Row below
                adjacent.increment(at(i, 1, j, -1));
                adjacent.increment(at(i, 1, j, 0));
                adjacent.increment(at(i, 1, j, 1));

                var from = row.get(j);
                var to = from;

                if(from == FREE && adjacent.getOccupied() == 0) {
                    to = OCCUPIED;
                } else if(from == OCCUPIED && adjacent.getOccupied() >= 5) {
                    to = FREE;
                }

                newRow.add(to);

                if(from != to) {
                    changes += 1;
                }
            }
        }

        rows = newLayout;
        return changes;
    }


    public long count(SeatState state) {
        return rows.stream()
                .flatMap(Collection::stream)
                .filter(x -> x == state)
                .count();
    }

    private Optional<SeatState> at(int x, int y) {
        if(x < 0) return Optional.empty();
        if(x >= rows.size()) return Optional.empty();

        var row = rows.get(x);
        if(y < 0) return Optional.empty();
        if(y >= row.size()) return Optional.empty();

        return Optional.of(row.get(y));
    }

    private Optional<SeatState> at(int x, int modifierX, int y, int modifierY) {
        Optional<SeatState> state;
        do {
            x += modifierX;
            y += modifierY;

            state = at(x, y);

        } while (state.isPresent() && state.get() == FLOOR);

        return state;
    }

    static class Adjacent {
        private int free;
        private int occupied;

        public void increment(Optional<SeatState> state) {
            if(state.isEmpty()) return;

            if (state.get() == FREE) {
                free += 1;
            } else if (state.get() == OCCUPIED) {
                occupied += 1;
            }
        }

        public int getFree() {
            return free;
        }

        public int getOccupied() {
            return occupied;
        }
    }
}
