package com.adventofcode;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TravelMap {
    private List<String> rows = new ArrayList<>();

    public int countTrees() {
        var trees = 0;
        for(var i=0; i < rows.size(); i += 1) {
            var index = (i * 3) % rows.get(i).length();
            var c = rows.get(i).charAt(index);
            if(c == (int)'#') {
                trees += 1;
            }
        }
        return trees;
    }

    public static TravelMap of(BufferedReader reader) {
        var map = new TravelMap();
        map.rows.addAll(reader.lines().collect(toList()));
        return map;
    }
}
