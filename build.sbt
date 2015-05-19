Common.appSettings

lazy val core = project in file("modules/core")

lazy val agent = (project in file("modules/agent")).dependsOn(core)

lazy val admin = (project in file("modules/admin")).enablePlugins(PlayScala).dependsOn(core)

lazy val root = (project in file(".")).enablePlugins(PlayScala).aggregate(core, admin, agent).dependsOn(core, admin, agent)

libraryDependencies ++= Common.commonDependencies