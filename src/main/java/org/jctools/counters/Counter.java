package org.jctools.counters;

/**
 * Base counter interface.
 *
 * @author Tolstopyatov Vsevolod
 */
public interface Counter {

    void increment();

    void increment(long delta);

    long get();

    long getAndReset();
}