package com.adventofcode;

public class Bus {
    private int id;

    public Bus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int minutesToDeparture(int from) {
        return (int)Math.ceil(from / (double)id) * id - from;
    }

    public boolean canDepart(long at) {
        return at % id == 0;
    }
}
