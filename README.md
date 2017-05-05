# WIP #

### Some partials results

```text
vendor_id       : GenuineIntel
cpu family      : 6
model           : 78
model name      : Intel(R) Core(TM) i5-6300U CPU @ 2.40GHz


[info] # Threads: 12 threads (1 group; 1x "get", 11x "increment" in each group), will synchronize iterations

jmh:run ".*.Count.*" -bm avgt -tg 1,11
[info] # Run complete. Total time: 00:04:20
[info] 
[info] Benchmark                                     Mode  Cnt         Score         Error  Units

[info] AtomicLongCounterBench.rw                     avgt   20       250.782 ±       4.296  ns/op
[info] AtomicLongCounterBench.rw:get                 avgt   20       166.543 ±      27.189  ns/op
[info] AtomicLongCounterBench.rw:increment           avgt   20       258.441 ±       6.148  ns/op

[info] PaddedAtomicLongCounterBench.rw               avgt   20       217.980 ±      31.456  ns/op
[info] PaddedAtomicLongCounterBench.rw:get           avgt   20       146.438 ±      49.773  ns/op
[info] PaddedAtomicLongCounterBench.rw:increment     avgt   20       224.484 ±      30.482  ns/op

[info] FixedStripedCounterBench.rw                   avgt   20       102.744 ±      10.067  ns/op
[info] FixedStripedCounterBench.rw:get               avgt   20       250.377 ±      25.235  ns/op
[info] FixedStripedCounterBench.rw:increment         avgt   20        89.323 ±      10.079  ns/op

[info] LongAdderBackportCounterBench.rw              avgt   20        72.917 ±       6.791  ns/op
[info] LongAdderBackportCounterBench.rw:get          avgt   20       206.738 ±      32.175  ns/op
[info] LongAdderBackportCounterBench.rw:increment    avgt   20        60.751 ±       6.811  ns/op

[info] LongAdderCounterBench.rw                      avgt   20        68.041 ±       2.536  ns/op
[info] LongAdderCounterBench.rw:get                  avgt   20       215.079 ±      23.818  ns/op
[info] LongAdderCounterBench.rw:increment            avgt   20        54.673 ±       2.458  ns/op

[info] LongAdderCounterWithPhaserBench.rw            avgt   20    989690.950 ±  103638.700  ns/op
[info] LongAdderCounterWithPhaserBench.rw:get        avgt   20  11871183.347 ± 1243740.350  ns/op
[info] LongAdderCounterWithPhaserBench.rw:increment  avgt   20       464.369 ±      19.455  ns/op




[info] # Threads: 12 threads (1 group; 1x "max", 11x "update" in each group), will synchronize iterations
> jmh:run ".*.Updater.*" -bm avgt -tg 1,11
[info] # Run complete. Total time: 00:03:19
[info] 
[info] Benchmark                             Mode  Cnt     Score      Error  Units
[info] LongMaxUpdaterBench.rw                avgt   20  4254.372 ±  196.496  ns/op
[info] LongMaxUpdaterBench.rw:max            avgt   20    17.225 ±    1.844  ns/op
[info] LongMaxUpdaterBench.rw:update         avgt   20  4639.568 ±  214.339  ns/op

[info] PaddedLongMaxUpdaterBench.rw          avgt   20  4422.208 ±  397.754  ns/op
[info] PaddedLongMaxUpdaterBench.rw:max      avgt   20    19.458 ±    3.088  ns/op
[info] PaddedLongMaxUpdaterBench.rw:update   avgt   20  4822.458 ±  433.747  ns/op

[info] LongMaxUpdaterJSRBench.rw             avgt   20  6909.716 ± 1430.737  ns/op
[info] LongMaxUpdaterJSRBench.rw:max         avgt   20    25.103 ±    5.058  ns/op
[info] LongMaxUpdaterJSRBench.rw:update      avgt   20  7535.590 ± 1560.437  ns/op

[info] LongMaxUpdaterStripedBench.rw         avgt   20  7497.682 ±  668.087  ns/op
[info] LongMaxUpdaterStripedBench.rw:max     avgt   20   318.894 ±   39.413  ns/op
[info] LongMaxUpdaterStripedBench.rw:update  avgt   20  8150.299 ±  730.170  ns/op

```
