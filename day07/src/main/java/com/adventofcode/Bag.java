package com.adventofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bag {
    private final String color;
    private final Map<String, Integer> canContain = new HashMap<>();

    public Bag(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Set<String> canContain() {
        return canContain.keySet();
    }

    public int canContainOf(String color) {
        return canContain.getOrDefault(color, 0);
    }

    public void addRestriction(String color, int count) {
        canContain.put(color, count);
    }
}
