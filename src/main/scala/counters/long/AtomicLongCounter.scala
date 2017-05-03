package counters.adder

import java.util.concurrent.atomic.AtomicLong

import org.jctools.counters.Counter

class AtomicLongCounter extends Counter {
  val counter = new AtomicLong()

  override def increment(): Unit = counter.incrementAndGet()

  override def get(): Long = counter.get()

  override def increment(delta: Long): Unit = ???

  override def getAndReset(): Long = ???
}
