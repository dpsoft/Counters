package counters.bench

import java.util.concurrent.TimeUnit

import counters.adder.LongAdderCounter
import org.jctools.counters.Counter
import org.openjdk.jmh.annotations._

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgsAppend = Array("-XX:-RestrictContended"))
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class LongAdderCounterBench {

  val counter: Counter = new LongAdderCounter

  @Benchmark
  @Group("rw")
  def increment(): Unit = counter.increment()

  @Benchmark
  @Group("rw")
  def get(): Long = counter.get()
}