package counters.bench

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

import org.openjdk.jmh.annotations._
import updaters.MaxUpdater

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgsAppend = Array("-XX:-RestrictContended"))
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class PaddedLongMaxUpdaterBench {

  val updater: MaxUpdater = new minmaxcounters.PaddedLongMaxUpdater(new AtomicLong(Long.MinValue))

  @Benchmark
  @Group("rw")
  def update(): Unit = {
      for(v <- UpdatersInfo.values) updater.update(v)
  }

  @Benchmark
  @Group("rw")
  def max(): Long = updater.max
}