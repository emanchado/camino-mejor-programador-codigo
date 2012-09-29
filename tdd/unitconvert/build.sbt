name := "unitconvert"

version := "0.1"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test->default",
  "org.scalatest" %% "scalatest" % "1.8" % "test",
  "org.apache.httpcomponents" % "httpclient" % "4.2.1" % "test",
  "org.apache.httpcomponents" % "fluent-hc" % "4.2.1" % "test",
  "org.mockito" % "mockito-core" % "1.9.0" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "7.5.2.v20111006"
)

parallelExecution in Test := false