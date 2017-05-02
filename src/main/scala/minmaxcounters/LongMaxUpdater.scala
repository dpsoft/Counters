package minmaxcounters

import java.util.concurrent.atomic.{AtomicLong, LongAdder}

import scala.annotation.tailrec

class LongMaxUpdater(value:AtomicLong) {
  def update(newMax:Long):Long = {
    @tailrec def compare():Long = {
      val currentMax = value.get()
      if(newMax > currentMax){
        if (!value.compareAndSet(currentMax, newMax)) compare()
        else newMax
      } else currentMax
    }
    compare()
  }

  def get():Long = value.get()
  def set(newValue:Long):Long = value.getAndSet(newValue)
}


object LongMaxUpdater {
  def apply(): LongMaxUpdater = new LongMaxUpdater(new AtomicLong(Long.MinValue))
}


//object Test extends App {
//  val updater = LongMaxUpdater()

//  updater.update(1L)
//  println(updater.update(5L))
//  updater.update(1L)
//  updater.update(1L)
//  updater.update(8L)
//  updater.update(-10002L)
//  updater.update(-8L)
//  updater.update(8L)
//  updater.update(102L)
//  updater.update(101L)
//  updater.update(100L)
//  updater.update(1)

//  println(updater.get())
//}