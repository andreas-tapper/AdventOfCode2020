package com.adventofcode;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SecondTravelMap {
    private List<String> rows = new ArrayList<>();

    public long countTrees() {
        return countTrees(1, 1) *
                countTrees(3, 1) *
                countTrees(5, 1) *
                countTrees(7, 1) *
                countTrees(1, 2);
    }

    public long countTrees(int step, int down) {
        var trees = 0;
        var index = 0;

        for(var i=0; i < rows.size(); i += down) {
            var c = rows.get(i).charAt(index);
            if(c == (int)'#') {
                trees += 1;
            }

            index = (index + step) % rows.get(i).length();
        }
        return trees;
    }

    public static SecondTravelMap of(BufferedReader reader) {
        var map = new SecondTravelMap();
        map.rows.addAll(reader.lines().collect(toList()));
        return map;
    }
}
