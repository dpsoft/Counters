package atomic;

import org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

abstract class PrePad {
    long l01, l02, l03, l04, l05, l06, l07, l08;
    long l9, l10, l11, l12, l13, l14, l15;
}


abstract class LeftRightLongPadded extends PrePad {
    public volatile long value;
    private static final long OFFSET;
    private static final Unsafe UNSAFE = (Unsafe) UnsafeAccess.UNSAFE;

    static {
        try {
            Field field = LeftRightLongPadded.class.getDeclaredField("value");
            OFFSET = UNSAFE.objectFieldOffset(field);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public LeftRightLongPadded(long initialValue) {
        this.value = initialValue;
    }

    public long volatileGet() {
        return value;
    }

    public void volatileSet(long update) {
        value = update;
    }

    public void lazySet(long update) {
        UNSAFE.putOrderedLong(this, OFFSET, update);
    }

    public boolean compareAndSet(long current, long update) {
        return UNSAFE.compareAndSwapLong(this, OFFSET, current, update);
    }

    public long getAndSet(long update) {
        return UNSAFE.getAndSetLong(this, OFFSET, update);
    }

    public long getAndAdd(long delta) {
        return UNSAFE.getAndAddLong(this, OFFSET, delta);
    }
}

public class LeftRight256PaddedLong extends LeftRightLongPadded {
    long l02, l03, l04, l05, l06, l07, l08;
    long l9, l10, l11, l12, l13, l14, l15, l16;

    public LeftRight256PaddedLong(long initialValue) {
        super(initialValue);
    }
}
