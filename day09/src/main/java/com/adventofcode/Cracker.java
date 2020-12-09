package com.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static java.util.stream.Collectors.toList;

public class Cracker {
    private int preambleSize;
    private LinkedList<Long> buffer = new LinkedList<>();

    public Cracker(int preambleSize) {
        this.preambleSize = preambleSize;
    }

    public long findWeakSpot(BufferedReader reader) {
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                var num = Long.parseLong(line);
                if(buffer.size() < preambleSize) {
                    buffer.addFirst(num);
                    continue;
                }

                if(isValidNumber(num)) {
                   buffer.addFirst(num);
                   buffer.removeLast();
                   continue;
                }

                return num;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }

    public long findMagicRange(BufferedReader reader, long weakSpot) {
        var encrypted = reader.lines()
                .map(Long::parseLong)
                .collect(toList());

        for(var i=0; i < encrypted.size(); i += 1) {
            var sum = encrypted.get(i);
            var range = new ArrayList<Long>();
            range.add(encrypted.get(i));
            for(var j=i + 1; j < encrypted.size(); j += 1) {
                sum += encrypted.get(j);
                range.add(encrypted.get(j));

                if(sum > weakSpot) {
                    break;
                }

                if(sum == weakSpot) {
                    var min = range.stream().min(Long::compareTo).orElseThrow();
                    var max = range.stream().max(Long::compareTo).orElseThrow();
                    return min + max;
                }
            }
        }

        return -1;
    }

    private boolean isValidNumber(long num) {
        for(var i=0; i < buffer.size(); i += 1) {
            for(var j=0; j < buffer.size(); j += 1) {
                if(buffer.get(i) + buffer.get(j) == num) {
                    return true;
                }
            }
        }

        return false;
    }
}
