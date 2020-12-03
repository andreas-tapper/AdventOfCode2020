package com.adventofcode;

public class Policy {
    private final Integer lowerBound;
    private final Integer upperBound;
    private final char letter;

    public Policy(Integer lowerBound, Integer upperBound, char letter) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.letter = letter;
    }

    public boolean match(String password) {
        var count = password.length() - password.replaceAll(String.valueOf(letter), "").length();
        return lowerBound <= count && count <= upperBound;
    }
}
