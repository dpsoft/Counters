package minmaxcounters



import java.lang.Math.abs
import java.util.concurrent.atomic.{AtomicLong, LongAdder}

import org.HdrHistogram.WriterReaderPhaser
import org.jctools.counters.Counter


class LongAdderWithPhaser extends Counter {
  val recordingPhaser = new WriterReaderPhaser

  @volatile var activeAdder:LongAdder = new LongAdder
  var inactiveAdder:LongAdder = new LongAdder

  def increment:Unit = withCriticalSection(activeAdder.increment())

  def withCriticalSection[A](thunk: => A):A = {
    val criticalValueAtEnter = recordingPhaser.writerCriticalSectionEnter()
    try thunk finally recordingPhaser.writerCriticalSectionExit(criticalValueAtEnter)
  }

  def withReaderLock[A](thunk: => A):A = {
    recordingPhaser.readerLock()
    try {
      val value = thunk
      recordingPhaser.flipPhase(500000L /* yield in 0.5 msec units if needed */)
      value
    } finally recordingPhaser.readerUnlock()
  }

  def get():Long =  withReaderLock {
    inactiveAdder.reset()
    val tempValues = inactiveAdder
    inactiveAdder = activeAdder
    activeAdder = tempValues
    inactiveAdder.sum()
  }

  override def increment(delta: Long): Unit = ???

  override def getAndReset(): Long = ???
}

//class LongMaxUpdaterWithPhaser {
//  val recordingPhaser = new WriterReaderPhaser
//
//  @volatile var activeMinMax:AtomicMinMax = new AtomicMinMax
//  var inactiveMinMax:AtomicMinMax = new AtomicMinMax
//
//
//  def increment(): Unit = increment(1L)
//  def decrement(): Unit = decrement(1L)
//
//  def increment(newValue:Long):Unit = withCriticalSection(activeMinMax.increment(newValue))
//  def decrement(newValue:Long):Unit = withCriticalSection(activeMinMax.decrement(newValue))
//
//  def withCriticalSection[A](thunk: => A):A = {
//    val criticalValueAtEnter = recordingPhaser.writerCriticalSectionEnter()
//    try thunk finally recordingPhaser.writerCriticalSectionExit(criticalValueAtEnter)
//  }
//
//  def withReaderLock[A](thunk: => A):A = {
//    recordingPhaser.readerLock()
//    try {
//      val value = thunk
//      recordingPhaser.flipPhase(500000L /* yield in 0.5 msec units if needed */)
//      value
//    } finally recordingPhaser.readerUnlock()
//  }
//
//  def get():AtomicMinMax =  withReaderLock {
//      inactiveMinMax.reset(activeMinMax.sum.get())
//      val tempValues = inactiveMinMax
//      inactiveMinMax = activeMinMax
//      activeMinMax = tempValues
//      inactiveMinMax
//  }
//}
//
//case class Values(min:Long, max:Long, current:Long)

//class AtomicMinMax {
//
//  val min = LongMaxUpdater()
//  val max = LongMaxUpdater()
//  val sum  = new AtomicLong(0L)
//
//  def increment(): Unit = increment(1L)
//
//  def increment(times: Long): Unit = {
//    val currentValue = sum.addAndGet(times)
//    max.update(currentValue)
//  }
//
//  def decrement(): Unit = decrement(1L)
//
//  def decrement(times: Long): Unit = {
//    val currentValue = sum.addAndGet(-times)
//    min.update(-currentValue)
//  }
//
//  def reset(current:Long = 0L): Unit = {
//    min.set(-current)
//    max.set(current)
////    sum.set(0L)
//  }
//
//  def sample(): (Long, Long, Long) = {
//    val currentValue = {
//      val value = sum.get()
//      if (value <= 0) 0 else value
//    }
//
//    val currentMin = {
//      val rawMin = min.get()
//      if (rawMin >= 0) 0
//      else abs(rawMin)
//    }
//    val currentMax = max.get()
//
//    min.set(-currentValue)
//    max.set(currentValue)
//    (currentMin, currentMax, currentValue)
//  }
//}


//class Incrementer(atomicMinMax: LongMaxUpdaterWithPhaser) extends Runnable {
//  override def run(): Unit = {
//    while(true){
//      atomicMinMax.increment()
//    }
//  }
//}
//
//class Decrementer(atomicMinMax: LongMaxUpdaterWithPhaser) extends Runnable {
//  override def run(): Unit = {
//    while(true)
//      atomicMinMax.decrement(10)
//  }
//}
//
//class Geter(atomicMinMax: LongMaxUpdaterWithPhaser) extends Runnable {
//  override def run(): Unit = {
//    for(i <- 1 to 10) {
//      println("get" + atomicMinMax.get().sample())
//      Thread.sleep(1000)
//    }
//  }
//}

//  object TestPhaser extends App {
//  val pool = Executors.newFixedThreadPool(4)
//  val updater = new LongMaxUpdaterWithPhaser()
//
//  updater.increment(2000L)

//    pool.submit(new Incrementer(updater))
//    pool.submit(new Decrementer(updater))
//    pool.submit(new Geter(updater))

//  updater.increment(1L)
//  println(updater.update(5L))
//  updater.increment(1L)
//  updater.decrement(100L)
//  updater.decrement(8L)
//  updater.increment(8L)
//  updater.increment(10002L)
//  updater.increment(8L)
//  updater.decrement(102L)
//  updater.increment(101L)
//  updater.increment(100L)
//  updater.decrement(1)
//  updater.increment()
//  updater.increment()
//  updater.increment()
//  updater.decrement()
//  updater.decrement()
//  updater.decrement()
//
//  Thread.sleep(10000)
//  pool.shutdownNow()
//  println(updater.get().sample())
//}