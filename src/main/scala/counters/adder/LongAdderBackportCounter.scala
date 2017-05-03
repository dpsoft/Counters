package counters.adder

import backport.jsr166.LongAdder
import org.jctools.counters.Counter

class LongAdderBackportCounter extends Counter {
  val counter = new LongAdder()

  override def increment(): Unit = counter.increment()

  override def get(): Long = counter.sum()

  override def increment(delta: Long): Unit = ???

  override def getAndReset(): Long = ???
}
