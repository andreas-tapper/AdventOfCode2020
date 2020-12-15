package com.adventofcode;

import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BusDeparture {
    private int earliestTimestamp;
    private List<Bus> buses = new ArrayList<>();

    public int idAndWaitingTime() {
        var bus = buses.stream().map(x -> Pair.with(x.getId(), x.minutesToDeparture(earliestTimestamp)))
                .min(Comparator.comparingInt(Pair::getValue1))
                .orElseThrow();
        return bus.getValue0() * bus.getValue1();
    }

    public long findTimestamp(long lower, long upper) {
        return -1;
    }

    public static BusDeparture parse(BufferedReader reader) {
        var busDeparture = new BusDeparture();

        try {
            busDeparture.earliestTimestamp = Integer.parseInt(reader.readLine());
            busDeparture.buses = Arrays.stream(reader.readLine().split(","))
                    .filter(x -> !x.equalsIgnoreCase("x"))
                    .map(Integer::parseInt)
                    .map(Bus::new)
                    .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return busDeparture;
    }
}
