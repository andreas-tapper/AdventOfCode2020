package com.adventofcode;

import java.util.HashMap;
import java.util.Map;

public class LongestChain {
    private Map<Integer, Integer> differences = new HashMap<>();

    public void addDifference(int difference) {
        var count = differences.getOrDefault(difference, 0) + 1;
        differences.put(difference, count);
    }

    public int getDifferenceCount(int difference) {
        return differences.getOrDefault(difference, 0);
    }
}
