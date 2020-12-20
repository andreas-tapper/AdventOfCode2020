package com.adventofcode;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DockingProgram {
    private static Pattern SetMemory = Pattern.compile("^mem\\[(?<pos>\\d+)\\]\\s=\\s(?<value>\\d+)$");

    private List<Instruction> instructions = new ArrayList<>();

    public long run() {
        var memory = new RewritingMemory();

        for (var instruction : instructions) {
            instruction.Execute(memory);
        }

        return memory.check();
    }

    public long runWithFloatingMemory() {
        var memory = new FloatingMemory();

        for (var instruction : instructions) {
            instruction.Execute(memory);
        }

        return memory.check();
    }


    public static DockingProgram parse(BufferedReader reader) {
        var program = new DockingProgram();

        reader.lines().forEach(line -> {
            if(line.startsWith("mask")) {
                program.instructions.add(new SetMaskInstruction(line.substring(7)));
            } else if(line.startsWith("mem")) {
                var matcher = SetMemory.matcher(line);
                if(!matcher.matches()) throw new RuntimeException(String.format("Cannot parse line '%s'.", line));
                program.instructions.add(new SetValueInstruction(Long.parseLong(matcher.group("pos")),
                        Long.parseLong(matcher.group("value"))));
            }
        });

        return program;
    }
}
