package counters.bench

import java.util.concurrent.TimeUnit

import atomic.Padded256LongCounter
import org.jctools.counters.Counter
import org.openjdk.jmh.annotations._

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(2)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class Padded256LongCounterBench {

  val counter: Counter = new Padded256LongCounter(Long.MinValue)

  @Benchmark
  @Group("rw")
  def increment(): Unit = counter.increment()

  @Benchmark
  @Group("rw")
  def get(): Long = counter.get()
}