package counters.adder

import java.util.concurrent.atomic.AtomicLong

import org.jctools.counters.Counter

class AtomicLongCounter extends Counter {
  val counter = new AtomicLong()

  override def increment(): Unit = counter.incrementAndGet()
  override def get(): Long = counter.get()
  override def increment(delta: Long): Unit = counter.getAndAdd(delta)
  override def getAndReset(): Long = counter.getAndSet(0L)
}


class PaddedLongCounter(value:AtomicLong) extends AtomicLongCounter {
  @volatile var p1, p2, p3, p4, p5, p6 = 7L
  protected def sumPaddingToPreventOptimisation() = p1 + p2 + p3 + p4 + p5 + p6
}


