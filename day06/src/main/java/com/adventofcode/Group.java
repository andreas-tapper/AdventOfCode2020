package com.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    public List<Person> persons = new ArrayList<>();

    public Set<Character> anyoneAnsweredYes() {
        var anyone = new HashSet<Character>();

        for(var person : persons) {
            anyone.addAll(person.getYesAnswers());
        }

        return anyone;
    }

    public Set<Character> everyoneAnsweredYes() {
        var everyone = anyoneAnsweredYes();

        for(var person : persons) {
            var intersection = new HashSet<Character>();
            for (Character answer : person.getYesAnswers()) {
                if(everyone.contains(answer)) {
                    intersection.add(answer);
                }
            }

            everyone = intersection;
        }

        return everyone;
    }

    public static List<Group> parse(BufferedReader reader) {
        var groups = new ArrayList<Group>();
        var group = new Group();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.isBlank()) {
                    groups.add(group);
                    group = new Group();
                    continue;
                }

                group.persons.add(new Person(line));
            }

            groups.add(group);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return groups;
    }

}
