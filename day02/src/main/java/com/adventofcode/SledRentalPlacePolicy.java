package com.adventofcode;

public class SledRentalPlacePolicy {
    protected final Integer lowerBound;
    protected final Integer upperBound;
    protected final char letter;

    public SledRentalPlacePolicy(Integer lowerBound, Integer upperBound, char letter) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.letter = letter;
    }

    public boolean match(String password) {
        var count = password.length() - password.replaceAll(String.valueOf(letter), "").length();
        return lowerBound <= count && count <= upperBound;
    }
}
