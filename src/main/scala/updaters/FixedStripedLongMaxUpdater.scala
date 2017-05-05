package updaters

import org.jctools.updaters.FixedSizeStripedLongUpdater
import org.jctools.util.UnsafeAccess.{UNSAFE => Unsafe}

trait MaxUpdater {
  def update(value:Long):Unit
  def max:Long
  def maxAndReset():Long
}

class FixedStripedLongMaxUpdater(stripes:Int) extends FixedSizeStripedLongUpdater(stripes) {
  override protected def update(cells: Array[Long], offset: Long, value: Long): Unit = {
    var current:Long = 0L
    var v:Long = 0L

    do {
      current = Unsafe.getLongVolatile(cells, offset)
      v = if(current > value) current else value
    } while(!Unsafe.compareAndSwapLong(cells, offset, current, v))
  }

  override protected def getAndReset(cells: Array[Long], offset: Long): Long = Unsafe.getAndSetLong(cells, offset, 0L)
}
