package com.adventofcode;

public interface Memory {
    long check();
    void setMemory(long position, long value);
    void setBitOnMask(long bitOnMask);
    void setBitOffMask(long bitOffMask);
    void setBitFloatingMask(long bitFloatingMask);
}
