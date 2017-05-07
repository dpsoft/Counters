# WIP #

### Some partials results

### Counters

```text
vendor_id       : GenuineIntel
cpu family      : 6
model           : 78
model name      : Intel(R) Core(TM) i5-6300U CPU @ 2.40GHz

[info] # VM version: JDK 1.8.0_121, VM 25.121-b13

//only throughput
jmh:run ".*.Counter.*" -bm avgt -tg 0,4

[info] # Threads: 4 threads (1 group; 0x "get", 4x "increment" in each group), will synchronize iterations

[info] Benchmark                                     Mode  Cnt       Score       Error  Units
[info] AtomicLongCounterBench.rw                     avgt   10   81.890 ±  3.080  ns/op
[info] AtomicLongCounterBench.rw:increment           avgt   10   81.890 ±  3.080  ns/op

[info] Padded256LongCounterBench.rw                  avgt   10   94.358 ±  0.798  ns/op
[info] Padded256LongCounterBench.rw:increment        avgt   10   94.358 ±  0.798  ns/op

[info] PaddedAtomicLongCounterBench.rw               avgt   10   86.248 ±  3.353  ns/op
[info] PaddedAtomicLongCounterBench.rw:increment     avgt   10   86.248 ±  3.353  ns/op

[info] FixedStripedCounterBench.rw                   avgt   10   26.929 ± 16.229  ns/op
[info] FixedStripedCounterBench.rw:increment         avgt   10   26.929 ± 16.229  ns/op

[info] LongAdderBackportCounterBench.rw              avgt   10   16.021 ±  0.661  ns/op
[info] LongAdderBackportCounterBench.rw:increment    avgt   10   16.021 ±  0.661  ns/op

[info] LongAdderCounterBench.rw                      avgt   10   15.493 ±  0.210  ns/op
[info] LongAdderCounterBench.rw:increment            avgt   10   15.493 ±  0.210  ns/op

[info] LongAdderCounterWithPhaserBench.rw            avgt   10  176.559 ±  1.276  ns/op
[info] LongAdderCounterWithPhaserBench.rw:increment  avgt   10  176.559 ±  1.276  ns/op


jmh:run ".*.Counter.*" -bm avgt -tg 1,3

[info] # Threads: 4 threads (1 group; 1x "get", 3x "increment" in each group), will synchronize iterations

[info] Benchmark                                     Mode  Cnt       Score       Error  Units
[info] AtomicLongCounterBench.rw                     avgt   20      70.600 ±     2.256  ns/op
[info] AtomicLongCounterBench.rw:get                 avgt   20      55.400 ±    12.860  ns/op
[info] AtomicLongCounterBench.rw:increment           avgt   20      75.667 ±     5.169  ns/op

[info] Padded256LongCounterBench.rw                  avgt   20      73.545 ±     6.007  ns/op
[info] Padded256LongCounterBench.rw:get              avgt   20      79.103 ±    32.840  ns/op
[info] Padded256LongCounterBench.rw:increment        avgt   20      71.692 ±     5.874  ns/op

[info] PaddedAtomicLongCounterBench.rw               avgt   20      69.870 ±     3.767  ns/op
[info] PaddedAtomicLongCounterBench.rw:get           avgt   20      57.992 ±     7.932  ns/op
[info] PaddedAtomicLongCounterBench.rw:increment     avgt   20      73.830 ±     6.379  ns/op

[info] FixedStripedCounterBench.rw                   avgt   20      51.730 ±     4.883  ns/op
[info] FixedStripedCounterBench.rw:get               avgt   20      85.112 ±     5.173  ns/op
[info] FixedStripedCounterBench.rw:increment         avgt   20      40.603 ±     6.473  ns/op

[info] LongAdderBackportCounterBench.rw              avgt   20      48.746 ±     3.566  ns/op
[info] LongAdderBackportCounterBench.rw:get          avgt   20      70.848 ±     7.885  ns/op
[info] LongAdderBackportCounterBench.rw:increment    avgt   20      41.378 ±     5.355  ns/op

[info] LongAdderCounterBench.rw                      avgt   20      48.032 ±     0.825  ns/op
[info] LongAdderCounterBench.rw:get                  avgt   20      68.421 ±     6.193  ns/op
[info] LongAdderCounterBench.rw:increment            avgt   20      41.235 ±     2.156  ns/op

[info] LongAdderCounterWithPhaserBench.rw            avgt   20  191734.989 ± 24220.804  ns/op
[info] LongAdderCounterWithPhaserBench.rw:get        avgt   20  766529.687 ± 96865.309  ns/op
[info] LongAdderCounterWithPhaserBench.rw:increment  avgt   20     136.757 ±    10.185  ns/op


jmh:run ".*.Counter.*" -bm avgt -tg 1,11

[info] # Threads: 12 threads (1 group; 1x "get", 11x "increment" in each group), will synchronize iterations

[info] Benchmark                                     Mode  Cnt         Score        Error  Units
[info] AtomicLongCounterBench.rw                     avgt   20       240.146 ±      5.865  ns/op
[info] AtomicLongCounterBench.rw:get                 avgt   20       193.430 ±     54.211  ns/op
[info] AtomicLongCounterBench.rw:increment           avgt   20       244.393 ±      6.931  ns/op

[info] Padded256LongCounterBench.rw                  avgt   20       247.020 ±      9.893  ns/op
[info] Padded256LongCounterBench.rw:get              avgt   20       220.722 ±     57.835  ns/op
[info] Padded256LongCounterBench.rw:increment        avgt   20       249.411 ±     12.143  ns/op

[info] PaddedAtomicLongCounterBench.rw               avgt   20       227.369 ±      4.171  ns/op
[info] PaddedAtomicLongCounterBench.rw:get           avgt   20       183.654 ±     28.023  ns/op
[info] PaddedAtomicLongCounterBench.rw:increment     avgt   20       231.343 ±      4.356  ns/op

[info] FixedStripedCounterBench.rw                   avgt   20       104.551 ±      7.981  ns/op
[info] FixedStripedCounterBench.rw:get               avgt   20       224.540 ±     25.393  ns/op
[info] FixedStripedCounterBench.rw:increment         avgt   20        93.643 ±      8.152  ns/op

[info] LongAdderBackportCounterBench.rw              avgt   20        70.130 ±      1.444  ns/op
[info] LongAdderBackportCounterBench.rw:get          avgt   20       210.661 ±     13.647  ns/op
[info] LongAdderBackportCounterBench.rw:increment    avgt   20        57.355 ±      1.195  ns/op

[info] LongAdderCounterBench.rw                      avgt   20        65.629 ±      0.617  ns/op
[info] LongAdderCounterBench.rw:get                  avgt   20       201.449 ±     14.101  ns/op
[info] LongAdderCounterBench.rw:increment            avgt   20        53.281 ±      1.037  ns/op

[info] LongAdderCounterWithPhaserBench.rw            avgt   20   1037134.480 ±  60274.763  ns/op
[info] LongAdderCounterWithPhaserBench.rw:get        avgt   20  12441185.367 ± 723382.746  ns/op
[info] LongAdderCounterWithPhaserBench.rw:increment  avgt   20       402.581 ±     20.244  ns/op
```

### MaxUpdaters
```text
//only for throughput
jmh:run ".*.Updater.*" -bm avgt -tg 0,4

[info] # Threads: 4 threads (1 group; 0x "max", 4x "update" in each group), will synchronize iterations

[info] Benchmark                               Mode  Cnt    Score    Error  Units
[info] LongMaxUpdaterBench.rw                  avgt   20  194.203 ±  7.431  ns/op
[info] LongMaxUpdaterBench.rw:update           avgt   20  194.203 ±  7.431  ns/op

[info] Padded256LongMaxUpdaterBench.rw         avgt   20  285.549 ±  0.916  ns/op
[info] Padded256LongMaxUpdaterBench.rw:update  avgt   20  285.549 ±  0.916  ns/op

[info] PaddedLongMaxUpdaterBench.rw            avgt   20  186.845 ±  2.195  ns/op
[info] PaddedLongMaxUpdaterBench.rw:update     avgt   20  186.845 ±  2.195  ns/op


[info] LongMaxUpdaterJSRBench.rw               avgt   20  187.844 ±  7.524  ns/op
[info] LongMaxUpdaterJSRBench.rw:update        avgt   20  187.844 ±  7.524  ns/op

[info] LongMaxUpdaterStripedBench.rw           avgt   20  265.281 ± 13.421  ns/op
[info] LongMaxUpdaterStripedBench.rw:update    avgt   20  265.281 ± 13.421  ns/op


jmh:run ".*.Updater.*" -bm avgt -tg 1,3

[info] # Threads: 4 threads (1 group; 1x "max", 3x "update" in each group), will synchronize iterations

[info] Benchmark                               Mode  Cnt    Score    Error  Units
[info] LongMaxUpdaterBench.rw                  avgt   20  139.564 ±  2.640  ns/op
[info] LongMaxUpdaterBench.rw:max              avgt   20    5.747 ±  0.096  ns/op
[info] LongMaxUpdaterBench.rw:update           avgt   20  184.169 ±  3.494  ns/op


[info] Padded256LongMaxUpdaterBench.rw         avgt   20  202.345 ±  0.549  ns/op
[info] Padded256LongMaxUpdaterBench.rw:max     avgt   20    5.465 ±  0.047  ns/op
[info] Padded256LongMaxUpdaterBench.rw:update  avgt   20  267.972 ±  0.737  ns/op

[info] PaddedLongMaxUpdaterBench.rw            avgt   20  140.390 ±  2.598  ns/op
[info] PaddedLongMaxUpdaterBench.rw:max        avgt   20    5.690 ±  0.093  ns/op
[info] PaddedLongMaxUpdaterBench.rw:update     avgt   20  185.290 ±  3.446  ns/op

[info] LongMaxUpdaterJSRBench.rw               avgt   20  280.401 ±  6.522  ns/op
[info] LongMaxUpdaterJSRBench.rw:max           avgt   20    9.455 ±  0.167  ns/op
[info] LongMaxUpdaterJSRBench.rw:update        avgt   20  370.716 ±  8.668  ns/op

[info] LongMaxUpdaterStripedBench.rw           avgt   20  351.211 ± 21.232  ns/op
[info] LongMaxUpdaterStripedBench.rw:max       avgt   20  105.071 ±  3.589  ns/op
[info] LongMaxUpdaterStripedBench.rw:update    avgt   20  433.257 ± 28.395  ns/op

jmh:run ".*.Updater.*" -bm avgt -tg 1,11

[info] # Threads: 12 threads (1 group; 1x "max", 11x "update" in each group), will synchronize iterations

[info] Benchmark                               Mode  Cnt    Score     Error  Units
[info] LongMaxUpdaterBench.rw                  avgt   20  538.958 ±  19.361  ns/op
[info] LongMaxUpdaterBench.rw:max              avgt   20   16.439 ±   2.182  ns/op
[info] LongMaxUpdaterBench.rw:update           avgt   20  586.460 ±  21.019  ns/op

[info] Padded256LongMaxUpdaterBench.rw         avgt   20  798.077 ±  12.315  ns/op
[info] Padded256LongMaxUpdaterBench.rw:max     avgt   20   15.395 ±   1.165  ns/op
[info] Padded256LongMaxUpdaterBench.rw:update  avgt   20  869.230 ±  13.478  ns/op

[info] PaddedLongMaxUpdaterBench.rw            avgt   20  514.410 ±   5.313  ns/op
[info] PaddedLongMaxUpdaterBench.rw:max        avgt   20   16.639 ±   1.595  ns/op
[info] PaddedLongMaxUpdaterBench.rw:update     avgt   20  559.662 ±   5.858  ns/op

[info] LongMaxUpdaterJSRBench.rw               avgt   20  806.834 ± 259.081  ns/op
[info] LongMaxUpdaterJSRBench.rw:max           avgt   20   20.995 ±   5.012  ns/op
[info] LongMaxUpdaterJSRBench.rw:update        avgt   20  878.273 ± 282.214  ns/op

[info] LongMaxUpdaterStripedBench.rw           avgt   20  898.025 ±  39.160  ns/op
[info] LongMaxUpdaterStripedBench.rw:max       avgt   20  298.556 ±  27.354  ns/op
[info] LongMaxUpdaterStripedBench.rw:update    avgt   20  952.522 ±  44.023  ns/op


```
