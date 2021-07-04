name := "otus-less2-countries"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-jackson" % "4.0.1"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}