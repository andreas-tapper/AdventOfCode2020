package com.adventofcode;

import java.util.HashMap;
import java.util.Map;

public class RewritingMemory implements Memory {
    private Map<Long, Long> memory = new HashMap<>();
    private long bitOnMask = 0;
    private long bitOffMask = 0;

    @Override
    public long check() {
        return memory.values().stream()
                .reduce(Long::sum)
                .orElseThrow();
    }

    @Override
    public void setMemory(long position, long value) {
        var writeValue = value & bitOffMask;
        writeValue |= bitOnMask;
        memory.put(position, writeValue);
    }

    @Override
    public void setBitOnMask(long bitOnMask) {
        this.bitOnMask = bitOnMask;
    }

    @Override
    public void setBitOffMask(long bitOffMask) {
        this.bitOffMask = bitOffMask;
    }

    @Override
    public void setBitFloatingMask(long bitFloatingMask) {
        // Discard this
    }

    @Override
    public String toString() {
        return String.format("Bitmaps:\nOn %s\nOff %s", Long.toBinaryString(bitOnMask), Long.toBinaryString(bitOffMask));
    }
}
