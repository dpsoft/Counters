package counters.bench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Group)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class LongMaxUpdaterJSRBench {

  val updater = new backport.jsr166.LongMaxUpdater(0L)

  @Benchmark
  @Group("rw")
  def update(): Unit = {
    for(v <- UpdatersInfo.values) updater.update(v)
  }

  @Benchmark
  @Group("rw")
  def max(): Long = updater.max
}