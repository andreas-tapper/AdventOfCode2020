package com.adventofcode;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BagRuleSet {
    private static Pattern Rule = Pattern.compile("^(?<color>.*)\\s(bags)\\s(contain)\\s(?<rule>.*)$");
    private static Pattern AmountOfBags = Pattern.compile("^(?<amount>\\d+)\\s+(?<color>.*)$");
    private Map<String, Bag> bags = new HashMap<>();

    public int howManyBagsCanContain(String bagOfColor) {
        var count = 0;

        for (var bag : bags.values()) {
            if(bag.getColor().equalsIgnoreCase(bagOfColor)) continue;

            if(bagCanContainColor(bag, bagOfColor)) {
                count += 1;
            }
        }

        return count;
    }

    public int howManyBagsAreIn(String bagOfColor) {
        var count = 0;

        var bag = bags.get(bagOfColor);
        for (String color : bag.canContain()) {
            count += bag.canContainOf(color) * (1 + howManyBagsAreIn(color));
        }

        return count;
    }

    private boolean bagCanContainColor(Bag bag, String bagOfColor) {
        if(bag.canContain().contains(bagOfColor)) return true;

        for (var color : bag.canContain()) {
            if(bagCanContainColor(bags.get(color), bagOfColor)) {
                return true;
            }
        }

        return false;
    }

    public static BagRuleSet parse(BufferedReader reader) {
        var ruleSet = new BagRuleSet();

        reader.lines().forEach(line -> {
            var rule = Rule.matcher(line);
            if(!rule.matches()) throw new RuntimeException(String.format("Could not parse line '%s'", line));

            var bag = new Bag(rule.group("color").trim());
            ruleSet.bags.put(bag.getColor(), bag);

            var contains = rule.group("rule").trim();
            if("no other bags.".equalsIgnoreCase(contains)) return;

            Arrays.stream(contains.split(","))
                    .map(String::trim)
                    .map(x -> x.replaceAll("\\sbags*\\.*", ""))
                    .forEach(x -> {
                        var match = AmountOfBags.matcher(x);
                        if(!match.matches()) throw new RuntimeException(String.format("Could not parse '%s'", x));

                        bag.addRestriction(match.group("color").trim(), Integer.parseInt(match.group("amount")));
                    });

        });

        return ruleSet;
    }
}
