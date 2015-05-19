import sbt.Keys._
import sbt._

object Common {
  def appName = "amr-agent"

  // Common settings for every project
  def settings(appName: String) = Seq(
    name := appName,
    organization := "com.aliyun.amr",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.6",
    doc in Compile <<= target.map(_ / "none"),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:reflectiveCalls",
      "-language:postfixOps",
      "-language:implicitConversions"
    )
  )

  // Settings for the app, i.e. the root project
  val appSettings = settings(appName) ++: Seq()

  // Settings for every module, i.e. for every subproject
  def moduleSettings(module: String) = settings(module) ++: Seq(
    javaOptions in Test += s"-Dconfig.resource=application.conf"
  )

  private val play_ver = "2.3.9"
  val commonDependencies = Seq(
    "com.typesafe.play" %% "filters-helpers" % play_ver withSources(),
    "com.typesafe.play" %% "play-cache" % play_ver withSources(),
    "com.typesafe.play" %% "play" % play_ver withSources()
  )
}
