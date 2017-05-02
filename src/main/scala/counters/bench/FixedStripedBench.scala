package counters.bench

import java.util.concurrent.TimeUnit

import counters.striped.FixedSizeStripedLongCounterV8
import org.jctools.counters.Counter
import org.jctools.util.JvmInfo
import org.openjdk.jmh.annotations._

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(2)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class FixedStripedBench {

  val counter: Counter = new FixedSizeStripedLongCounterV8(JvmInfo.CPUs)

  @Benchmark
  @Group("rw")
  def increment(): Unit = counter.increment()

  @Benchmark
  @Group("rw")
  def get(): Long = counter.get()
}