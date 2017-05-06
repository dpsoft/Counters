package atomic;

import counters.striped.FixedSizeStripedLongCounterV8;
import minmaxcounters.Padded256LongMaxUpdater;
import org.jctools.counters.Counter;
import org.openjdk.jol.info.ClassLayout;

public class Padded256LongCounter extends LeftRight256PaddedLong implements Counter {

    public Padded256LongCounter(long initialValue) {
        super(initialValue);
    }

    @Override
    public void increment() {
        getAndAdd(1L);
    }

    @Override
    public void increment(long delta) {
        getAndAdd(delta);
    }

    @Override
    public long get() {
        return volatileGet();
    }

    @Override
    public long getAndReset() {
        return getAndSet(0L);
    }

    public static void main(String... str) {
        System.out.println(ClassLayout.parseClass(LeftRight256PaddedLong.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Padded256LongMaxUpdater.class).toPrintable());
        System.out.println(ClassLayout.parseClass(FixedSizeStripedLongCounterV8.class).toPrintable());

    }
}