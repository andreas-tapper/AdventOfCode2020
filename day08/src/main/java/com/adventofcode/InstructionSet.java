package com.adventofcode;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InstructionSet {
    private List<Instruction> instructions = new ArrayList<>();
    private Accumulator accumulator = new Accumulator();

    public int findInfiniteLoop() {
        var visited = new HashSet<Integer>();
        int next = 0;

        while(!visited.contains(next)) {
            var instruction = instructions.get(next);
            visited.add(next);
            next = instruction.execute(next);

            if(next >= instructions.size()) throw new RuntimeException("Cannot find loop.");
        }

        return accumulator.getValue();
    }

    public int repairInstructionSet() {
        for(var i=0; i < instructions.size(); i += 1) {
            try {
                var instruction = instructions.get(i);
                if(instruction instanceof AccOP) continue;

                if(instruction instanceof NoOP) {
                    instructions.set(i, new JumpOP(instruction.getArgument()));
                } else if(instruction instanceof JumpOP) {
                    instructions.set(i, new NoOP(instruction.getArgument()));
                }

                findInfiniteLoop();

                instructions.set(i, instruction);
                accumulator.reset();
            } catch (RuntimeException e) {
                return accumulator.getValue();
            }
        }

        return -1;
    }

    public static InstructionSet parse(BufferedReader reader) {
        var set = new InstructionSet();

        reader.lines()
                .forEach(x -> {
                    int argument = Integer.parseInt(x.substring(4));

                    if(x.startsWith("nop")) {
                        set.instructions.add(new NoOP(argument));
                    } else if(x.startsWith("jmp")) {
                        set.instructions.add(new JumpOP(argument));
                    } else if(x.startsWith("acc")) {
                        set.instructions.add(new AccOP(set.accumulator, argument));
                    }
                });

        return set;
    }
}
