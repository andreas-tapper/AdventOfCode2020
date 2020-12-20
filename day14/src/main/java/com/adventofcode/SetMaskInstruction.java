package com.adventofcode;

public class SetMaskInstruction implements Instruction {
    private long bitOnMask = 0;
    private long bitOffMask = 0;
    private long bitFloatingMask = 0;

    public SetMaskInstruction(String mask) {
        var position = 0;
        for(var i=mask.length() - 1; i >= 0; i -= 1) {
            var c = mask.charAt(i);
            if(c == '0') {
                bitOffMask = bitOffMask | (long)Math.pow(2, position);
            } else if(c == '1') {
                bitOnMask = bitOnMask | (long)Math.pow(2, position);
            } else if(c == 'X') {
                bitFloatingMask = bitFloatingMask | (long)Math.pow(2, position);
            }

            position += 1;
        }

        bitOffMask = ~bitOffMask;
    }

    @Override
    public void Execute(Memory memory) {
        memory.setBitOffMask(bitOffMask);
        memory.setBitOnMask(bitOnMask);
        memory.setBitFloatingMask(bitFloatingMask);
    }
}
