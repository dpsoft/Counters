package minmaxcounters

import java.util.concurrent.atomic.{AtomicLong, LongAdder}

import org.jctools.util.JvmInfo
import updaters.{FixedStripedLongMaxUpdater, MaxUpdater}

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

  def max():Long = value.get()
  def set(newValue:Long):Long = value.getAndSet(newValue)

  override def maxAndReset(): Long = ???
}


object LongMaxUpdater {
  def apply(): LongMaxUpdater = new LongMaxUpdater(new AtomicLong(Long.MinValue))
}


//object Test extends App {
////  val updater = LongMaxUpdater()
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
//  updater.update(100L)
//  updater.update(1)
//
//  println(updater.max())
//  println(updater.maxAndReset())
//  println(updater.max())
//}