package com.adventofcode;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private Set<Character> yesAnswers = new HashSet<>();

    public Person(String yesAnswers) {
        for(Character c : yesAnswers.toCharArray())
            this.yesAnswers.add(c);
    }

    public Set<Character> getYesAnswers() {
        return yesAnswers;
    }
}
