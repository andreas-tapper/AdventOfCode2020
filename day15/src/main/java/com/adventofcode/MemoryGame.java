package com.adventofcode;

import java.util.*;

public class MemoryGame {
    private int turn;
    private Map<Long, List<Integer>> lastKnownPosition;

    public long play2020(Long... seed) {
        return play(2020, seed);
    }

    public long play30000000(Long... seed) {
        return play(30000000, seed);
    }

    private long play(int size, Long... seed) {
        turn = seed.length + 1;
        lastKnownPosition = new HashMap<>();
        var recent = seed[seed.length - 1];


        for (var i = 0; i < seed.length; i += 1) {
            addNumberAt(i + 1, seed[i]);
        }

        for(var i=seed.length; i < size; i += 1) {
            var wasSpokenAt = spokenAt(recent);

            if(wasSpokenAt == 0) {
                recent = 0L;
            } else {
                recent = (long)(turn - 1 - wasSpokenAt);
            }

            addNumberAt(turn, recent);
            turn += 1;
        }

        return recent;
    }

    private int spokenAt(Long number) {
        if (!lastKnownPosition.containsKey(number)) return 0;

        var list = lastKnownPosition.get(number);

        var p = list.get(list.size() - 1);
        if (p == turn - 1) {
            return list.size() - 2 < 0 ? 0 : list.get(list.size() - 2);
        }

        return p;
    }

    private void addNumberAt(int position, long number) {
        if(!lastKnownPosition.containsKey(number)) {
            lastKnownPosition.put(number, new LinkedList<>());
        }
        var list = lastKnownPosition.get(number);
        list.add(position);
        if(list.size() > 2) {
            list.remove(0);
        }
    }
}
