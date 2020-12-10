package com.adventofcode;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdapterChain {
    private List<Integer> adapters;
    private Map<Integer, Long> memory = new HashMap<>();

    public LongestChain getLongestChain() {
        var longest = new LongestChain();

        for(var i=1; i < adapters.size(); i += 1) {
            var difference = adapters.get(i) - adapters.get(i - 1);
            if(difference > 3) throw new RuntimeException("Invalid chain.");
            longest.addDifference(difference);
        }

        return longest;
    }

    public long findDistinctArrangements() {
        return findDistinctArrangements(0);
    }

    private long findDistinctArrangements(int index) {
        var arrangements = 1L;
        if(memory.containsKey(index)) return memory.get(index);

        for(var i=index; i < adapters.size(); i += 1) {
            var lower = adapters.get(i);
            for(var j=2; ; j += 1) {
                if(i + j >= adapters.size()) break;
                var upper = adapters.get(i + j);
                if(upper - lower > 3) break;
                arrangements += findDistinctArrangements(i + j);
            }
        }

        memory.put(index, arrangements);
        return arrangements;
    }

    public static AdapterChain parse(BufferedReader reader) {
        var chain = new AdapterChain();

        chain.adapters = reader.lines()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        // Add outlet
        chain.adapters.add(0, 0);
        // Add device adapter
        chain.adapters.add(chain.adapters.stream()
                .max(Integer::compareTo)
                .orElseThrow() + 3);

        return chain;
    }
}
