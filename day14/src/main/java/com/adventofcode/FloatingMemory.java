package com.adventofcode;

import java.util.*;
import java.util.stream.Collectors;

public class FloatingMemory implements Memory {
    private Map<Long, Long> memory = new HashMap<>();
    private long bitOnMask = 0;
    private long bitFloatingMask = 0;

    @Override
    public long check() {
        return memory.values().stream()
                .reduce(Long::sum)
                .orElseThrow();
    }

    @Override
    public void setMemory(long position, long value) {
        var addresses = new HashSet<Long>();
        generateMemoryAddresses(0L, position, new ArrayList<>(), addresses);

        for(var address : addresses.stream().sorted(Long::compareTo)
                .collect(Collectors.toList())) {
            memory.put(address, value);
        }
    }

    @Override
    public void setBitOnMask(long bitOnMask) {
        this.bitOnMask = bitOnMask;
    }

    @Override
    public void setBitOffMask(long bitOffMask) {
        // Discard
    }

    @Override
    public void setBitFloatingMask(long bitFloatingMask) {
        this.bitFloatingMask = bitFloatingMask;
    }

    private void generateMemoryAddresses(long position, long address, List<Boolean> acc, Set<Long> addresses) {
        if(position >= 36) {
            var a = 0L;
            for (var i=0; i < acc.size(); i += 1) {
                if(acc.get(i)) {
                    a = a | (long)Math.pow(2, i);
                }
            }

            addresses.add(a);
            return;
        }

        var x = (long)Math.pow(2, position);
        if((bitFloatingMask & x) == x) {
            var on = new ArrayList<>(acc);
            on.add(true);
            generateMemoryAddresses(position + 1, address, on, addresses);
            var off = new ArrayList<>(acc);
            off.add(false);
            generateMemoryAddresses(position + 1, address, off, addresses);
        } else if((bitOnMask & x) == x) {
            var on = new ArrayList<>(acc);
            on.add(true);
            generateMemoryAddresses(position + 1, address, on, addresses);
        } else {
            var leave = new ArrayList<>(acc);
            leave.add((address & x) == x);
            generateMemoryAddresses(position + 1, address, leave, addresses);
        }
    }
}
