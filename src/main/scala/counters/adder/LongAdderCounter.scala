package counters.adder

import java.util.concurrent.atomic.LongAdder

import org.jctools.counters.Counter

class LongAdderCounter extends Counter {
  val counter = new LongAdder()

  override def increment(): Unit = counter.increment()
  override def get(): Long = counter.sum()
  override def increment(delta: Long): Unit = counter.add(delta)
  override def getAndReset(): Long = counter.sumThenReset()
}


class CustomLongAdderCounter extends Counter {
  val counter = new jsr.custom.LongAdder()

  override def increment(): Unit = counter.increment()
  override def get(): Long = counter.sum()
  override def increment(delta: Long): Unit = counter.add(delta)
  override def getAndReset(): Long = counter.sumAndReset()
}

