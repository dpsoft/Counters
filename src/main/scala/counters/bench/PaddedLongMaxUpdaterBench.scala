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

  val values:Array[Long] = Array(
    720, 190, 1320, 663, 520, 3646, 653, 1691, 201, 2959, 183, 2534, 632, 565, 2844,
    3421, 1645, 480, 894, 290, 1465, 1972, 752, 623, 1500, 2422, 1708, 755, 287, 1116,
    1806, 88, 676, 2118, 533, 766, 1090, 1066, 97, 437, 103, 1148, 684, 645, 2673,
    738, 1151, 757, 459, 2302, 671, 1080, 2775, 663, 762, 11448, 1442, 2726, 942, 1203,
    3435, 3509, 788, 1149, 3363, 1495, 3758, 4678, 5421, 493, 1072, 1702, 603, 1191, 726,
    3878, 866, 1136, 291, 1025, 863, 443, 786, 615, 676, 962, 136, 681, 1031, 970,
    822, 712, 735, 387, 596, 248, 1175, 275, 955, 1300, 677, 323, 408, 633, 745,
    623, 550, 522, 719, 334, 1614, 1238, 546, 296, 1090, 392, 828, 519, 2444, 257)

  @Benchmark
  @Group("rw")
  def update(): Unit = {
      for(v <- values) updater.update(v)
  }

  @Benchmark
  @Group("rw")
  def max(): Long = updater.max
}