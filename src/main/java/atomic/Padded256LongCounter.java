package atomic;

import counters.striped.FixedSizeStripedLongCounterV8;
import minmaxcounters.Padded256LongMaxUpdater;
import org.jctools.counters.Counter;
import org.openjdk.jol.info.ClassLayout;

public class Padded256LongCounter implements Counter {
    private LeftRight256PaddedLong volatileLong = new LeftRight256PaddedLong(0L);

    @Override
    public void increment() {
        volatileLong.getAndAdd(1L);
    }

    @Override
    public void increment(long delta) {
        volatileLong.getAndAdd(delta);
    }

    @Override
    public long get() {
        return volatileLong.volatileGet();
    }

    @Override
    public long getAndReset() {
        return volatileLong.getAndSet(0L);
    }

    public static void main(String... str) {
        System.out.println(ClassLayout.parseClass(LeftRight256PaddedLong.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Padded256LongMaxUpdater.class).toPrintable());
        System.out.println(ClassLayout.parseClass(FixedSizeStripedLongCounterV8.class).toPrintable());

    }
}