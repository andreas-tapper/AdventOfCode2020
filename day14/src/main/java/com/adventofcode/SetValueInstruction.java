package com.adventofcode;

public class SetValueInstruction implements Instruction {
    private final long position;
    private final long value;

    public SetValueInstruction(long position, long value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public void Execute(Memory memory) {
        memory.setMemory(position, value);
    }
}
