package minmaxcounters

import java.util.concurrent.atomic.AtomicLong

import updaters.MaxUpdater

import scala.annotation.tailrec

class LongMaxUpdater(value:AtomicLong) extends MaxUpdater{
  def update(newMax:Long):Unit = {
    @tailrec def compare():Long = {
      val currentMax = value.get()
      if(newMax > currentMax){
        if (!value.compareAndSet(currentMax, newMax)) compare()
        else newMax
      } else currentMax
    }
    compare()
  }

  override def max:Long = value.get()
  override def maxAndReset(): Long = value.getAndSet(0L)
}


object LongMaxUpdater {
  def apply(): LongMaxUpdater = new LongMaxUpdater(new AtomicLong(Long.MinValue))
}

class PaddedLongMaxUpdater(value:AtomicLong) extends LongMaxUpdater(value) {
  @volatile var p1, p2, p3, p4, p5, p6 = 7L

  protected def sumPaddingToPreventOptimisation() = p1 + p2 + p3 + p4 + p5 + p6
}


object Test extends App {
//  val updater = LongMaxUpdater()
//  val updater = new FixedStripedLongMaxUpdater(JvmInfo.CPUs)
//
//  updater.update(1L)
////  println(updater.update(5L))
//  updater.update(1L)
//  updater.update(1L)
//  updater.update(8L)
//  updater.update(-10002L)
//  updater.update(-8L)
//  updater.update(8L)
//  updater.update(104L)
//  updater.update(102L)
//  updater.update(101L)
//  updater.update(10000L)
//  updater.update(1)

//  println(updater.max())
//  println(updater.maxAndReset())
//  println(updater.max())
}