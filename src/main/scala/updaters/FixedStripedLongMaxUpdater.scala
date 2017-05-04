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


    Unsafe.getAndAddLong(cells, offset, value)
  }

  override protected def getAndReset(cells: Array[Long], offset: Long): Long = Unsafe.getAndSetLong(cells, offset, 0L)
}
