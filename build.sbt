name := "Counters"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.jctools" % "jctools-core" % "2.0.1"

libraryDependencies += "org.openjdk.jol" % "jol-core" % "0.8"

libraryDependencies += "org.openjdk.jmh" % "jmh-core" % "1.18"

enablePlugins(JmhPlugin)

fork in run := true

javaOptions += "-XX:-RestrictContended"

//in order to run:
// taskset -c 0-4 sbt
// jmh:run ".*.Ben.*" -bm avgt -tg 1,11 -prof gc