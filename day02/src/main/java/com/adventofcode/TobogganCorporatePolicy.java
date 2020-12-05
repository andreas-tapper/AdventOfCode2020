package com.adventofcode;

public class TobogganCorporatePolicy extends SledRentalPlacePolicy {
    public TobogganCorporatePolicy(Integer lowerBound, Integer upperBound, char letter) {
        super(lowerBound, upperBound, letter);
    }

    @Override
    public boolean match(String password) {
        char first = password.charAt(lowerBound - 1);
        char second = password.charAt(upperBound - 1);
        return (first == letter || second == letter) &&
                !(first == letter && second == letter);
    }
}
