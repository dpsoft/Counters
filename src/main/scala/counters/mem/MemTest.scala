package counters.mem

import java.util.concurrent.Executors

import counters.adder.LongAdderCounter
import counters.striped.FixedSizeStripedLongCounterV8
import minmaxcounters.LongAdderWithPhaser
import org.jctools.counters.{Counter, FixedSizeStripedLongCounter}

class Incrementer(counter: Counter) extends Runnable {
  override def run(): Unit = {
    while (true) {
      counter.increment()
    }
  }
}

class Geter(counter: Counter) extends Runnable {
  override def run(): Unit = {
    for (_ <- 1 to 100000) {
      println(counter.get()+ " " + Thread.currentThread().getName)
      Thread.sleep(100)
    }
  }
}

//object MemTest extends App {
//  val pool = Executors.newFixedThreadPool(50)
//
//    val counters = Seq.newBuilder[Counter]
////    for(_ <- 1 to 2) {
////      counters += FixedSizeStripedLongCounterV8()
////      counters += new LongAdderCounter()
//      counters += new LongAdderWithPhaser()
////    }
//
//    counters.result().foreach { counter =>
//      for (_ <- 1 to 500) {
//        pool.submit(new Incrementer(counter))
//        pool.submit(new Geter(counter))
//      }
//    }
//
//  Thread.sleep(90000)
//  pool.shutdownNow()
//}
