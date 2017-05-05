package counters.bench

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

import counters.adder.{AtomicLongCounter, PaddedLongCounter}
import org.jctools.counters.Counter
import org.openjdk.jmh.annotations._

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(2)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class PaddedAtomicLongBench {

  val counter: Counter = new PaddedLongCounter(new AtomicLong(0L))

  @Benchmark
  @Group("rw")
  def increment(): Unit = counter.increment()

  @Benchmark
  @Group("rw")
  def get(): Long = counter.get()
}