package counters.bench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import updaters.MaxUpdater

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgsAppend = Array("-XX:-RestrictContended"))
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class Padded256LongMaxUpdaterBench {

  val updater: MaxUpdater = new minmaxcounters.Padded256LongMaxUpdater(Long.MinValue)

  @Benchmark
  @Group("rw")
  def update(): Unit = {
      for(v <- UpdatersInfo.values) updater.update(v)
  }

  @Benchmark
  @Group("rw")
  def max(): Long = updater.max
}