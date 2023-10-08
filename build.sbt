ThisBuild / scalaVersion := "3.3.1"

lazy val root = project
  .in(file("."))
  .aggregate(`silly-brains`.js, `silly-brains`.jvm)
  .settings(
    publish      := {},
    publishLocal := {},
  )

lazy val `silly-brains` = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name    := "silly-brains",
    version := "0.1.0-SNAPSHOT",
  )
  .jvmSettings(
    // Add JVM-specific settings here
  )
  .jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "io.github.pityka" %%% "nspl-canvas-js" % "0.10.0"
    ),
  )
