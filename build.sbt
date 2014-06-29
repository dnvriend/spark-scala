name := "spark-scala"

version := "1.0.0"

scalaVersion := "2.11.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "com.sparkjava" % "spark-core" % "2.0.0",
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.3",
  "com.typesafe" % "config" % "1.2.0"
)

com.github.retronym.SbtOneJar.oneJarSettings