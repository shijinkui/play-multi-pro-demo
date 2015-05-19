Common.moduleSettings("agent")

libraryDependencies ++= Common.commonDependencies ++: Seq(
  "io.netty" % "netty-all" % "4.0.28.Final" withSources()
)

