# WIP #

### Some partials results

```text
vendor_id       : GenuineIntel
cpu family      : 6
model           : 78
model name      : Intel(R) Core(TM) i5-6300U CPU @ 2.40GHz


[info] # Threads: 5 threads (1 group; 1x "get", 4x "increment" in each group), will synchronize iterations

jmh:run ".*.Count.*" -bm avgt -tg 1,4
[info] # Run complete. Total time: 00:04:10
[info] 
[info] Benchmark                                     Mode  Cnt        Score        Error  Units
[info] AtomicLongCounterBench.rw                     avgt   20       92.323 ±      2.860  ns/op
[info] AtomicLongCounterBench.rw:get                 avgt   20       65.600 ±      9.876  ns/op
[info] AtomicLongCounterBench.rw:increment           avgt   20       99.004 ±      3.603  ns/op

[info] PaddedAtomicLongCounterBench.rw               avgt   20       94.347 ±      1.726  ns/op
[info] PaddedAtomicLongCounterBench.rw:get           avgt   20       64.718 ±      8.505  ns/op
[info] PaddedAtomicLongCounterBench.rw:increment     avgt   20      101.754 ±      2.756  ns/op

[info] FixedStripedCounterBench.rw                   avgt   20       44.207 ±      3.112  ns/op
[info] FixedStripedCounterBench.rw:get               avgt   20       93.082 ±     13.767  ns/op
[info] FixedStripedCounterBench.rw:increment         avgt   20       31.988 ±      5.776  ns/op

[info] LongAdderBackportCounterBench.rw              avgt   20       45.611 ±      2.085  ns/op
[info] LongAdderBackportCounterBench.rw:get          avgt   20       87.773 ±     10.605  ns/op
[info] LongAdderBackportCounterBench.rw:increment    avgt   20       35.070 ±      4.434  ns/op

[info] LongAdderCounterBench.rw                      avgt   20       42.078 ±      2.068  ns/op
[info] LongAdderCounterBench.rw:get                  avgt   20       83.283 ±      9.965  ns/op
[info] LongAdderCounterBench.rw:increment            avgt   20       31.776 ±      3.453  ns/op

[info] LongAdderCounterWithPhaserBench.rw            avgt   20   240762.736 ±  40611.919  ns/op
[info] LongAdderCounterWithPhaserBench.rw:get        avgt   20  1203117.858 ± 203064.130  ns/op
[info] LongAdderCounterWithPhaserBench.rw:increment  avgt   20      173.955 ±      6.812  ns/op



[info] # Threads: 5 threads (1 group; 1x "max", 5x "update" in each group), will synchronize iterations
> jmh:run ".*.Updater.*" -bm avgt -tg 1,4
[info] # Run complete. Total time: 00:02:48
[info] 
[info] Benchmark                             Mode  Cnt     Score     Error  Units

[info] LongMaxUpdaterBench.rw                avgt   20  1612.587 ± 134.507  ns/op
[info] LongMaxUpdaterBench.rw:max            avgt   20     8.382 ±   1.170  ns/op
[info] LongMaxUpdaterBench.rw:update         avgt   20  2013.638 ± 168.043  ns/op

[info] PaddedLongMaxUpdaterBench.rw          avgt   20  1686.759 ± 204.280  ns/op
[info] PaddedLongMaxUpdaterBench.rw:max      avgt   20     9.250 ±   1.509  ns/op
[info] PaddedLongMaxUpdaterBench.rw:update   avgt   20  2106.137 ± 255.297  ns/op

[info] LongMaxUpdaterJSRBench.rw             avgt   20  1766.902 ± 238.732  ns/op
[info] LongMaxUpdaterJSRBench.rw:max         avgt   20     9.504 ±   1.294  ns/op
[info] LongMaxUpdaterJSRBench.rw:update      avgt   20  2206.251 ± 298.231  ns/op

[info] LongMaxUpdaterStripedBench.rw         avgt   20  2779.829 ± 258.601  ns/op
[info] LongMaxUpdaterStripedBench.rw:max     avgt   20   144.460 ±  13.101  ns/op
[info] LongMaxUpdaterStripedBench.rw:update  avgt   20  3438.671 ± 325.974  ns/op
```
