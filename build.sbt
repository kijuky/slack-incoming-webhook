lazy val root = (project in file("."))
  .settings(
    name := "slack-incoming-webhook",
    scalaVersion := "2.13.10",
    scalacOptions ++= Seq("-Werror", "-Xlint"),
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "4.1.0",
      "com.slack.api" % "slack-api-client" % "1.27.2",
      "org.slf4j" % "slf4j-nop" % "1.7.36"
    )
  )
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version),
    buildInfoPackage := "io.github.kijuky.slack.incoming_webhook"
  )
  .enablePlugins(NativeImagePlugin)
  .settings(
    nativeImageVersion := "21.3.0",
    nativeImageOptions ++= Seq(
      "-H:+AllowIncompleteClasspath",
      s"-H:ReflectionConfigurationFiles=${target.value / "native-image-configs" / "reflect-config.json"}",
      s"-H:ConfigurationFileDirectories=${target.value / "native-image-configs"}",
      "-H:+JNI"
    )
  )
