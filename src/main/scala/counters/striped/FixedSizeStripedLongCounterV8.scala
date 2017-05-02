package counters.striped

import java.util.concurrent.atomic.LongAdder

import org.jctools.counters.FixedSizeStripedLongCounter
import org.jctools.util.JvmInfo
import org.jctools.util.UnsafeAccess.{UNSAFE => Unsafe}

class FixedSizeStripedLongCounterV8(stripesCount:Int) extends FixedSizeStripedLongCounter(stripesCount) {
  def increment(cells: Array[Long], offset: Long, delta: Long): Unit = Unsafe.getAndAddLong(cells, offset, delta)
  def getAndReset(cells: Array[Long], offset: Long): Long = Unsafe.getAndSetLong(cells, offset, 0L)
}

object FixedSizeStripedLongCounterV8 {
  def apply(): FixedSizeStripedLongCounterV8 = new FixedSizeStripedLongCounterV8(JvmInfo.CPUs)
}


class A {
  val a: Int = 0
  val b: Int = 0
  @sun.misc.Contended val c: Int = 0

}

//object FixedTest extends App {

//  import org.openjdk.jol.info.ClassLayout
//  import org.openjdk.jol.vm.VM
//
//  println(VM.current.details)
//  println(ClassLayout.parseClass(classOf[A]).toPrintable)
//  println(ClassLayout.parseClass(classOf[LongAdder]).toPrintable)
//  println(ClassLayout.parseClass(classOf[FixedSizeStripedLongCounterV8]).toPrintable)
//}