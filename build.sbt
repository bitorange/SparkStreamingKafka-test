import AssemblyKeys._

name := "SparkStreamingKafka"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= {
  val sparkVersion = "1.2.0"
  Seq(
    "org.apache.spark" %% "spark-core" % "1.3.0" % "provided",
    "org.apache.spark" % "spark-sql_2.10" % "1.1.0",
    "org.apache.spark" %% "spark-streaming" % "1.3.0",
    "org.apache.spark" %% "spark-streaming-kafka" % "1.3.0",
    "org.codehaus.jettison" % "jettison" % "1.3.5",
    "net.sourceforge.argparse4j" % "argparse4j" % "0.2.0"
  )
}

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1"


assemblySettings

mergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
  case "log4j.properties" => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") => MergeStrategy.filterDistinctLines
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}