package org.jctools.counters;

public interface Counter {
    void increment();
    void increment(long delta);
    long get();
    long getAndReset();
}