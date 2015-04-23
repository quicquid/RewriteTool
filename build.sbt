lazy val testDependencies = Seq(
  "junit" % "junit" % "4.12",
  "org.specs2" %% "specs2-core" % "3.4" withSources(),
  "org.specs2" %% "specs2-matcher" % "3.4" withSources(),
  "org.specs2" %% "specs2-mock" % "3.4" withSources(),
  "org.specs2" %% "specs2-junit" % "3.4" withSources(),
  "org.scalacheck" %% "scalacheck" % "1.12.2"  withSources()
)
lazy val commonSettings = Seq(
  resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console"),
  libraryDependencies ++= testDependencies map(_ % Test)
)
lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "RewriteTool",
    version := "1.0",
    scalaVersion := "2.11.4",
    mainClass := Some("Main")
  )
  libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3" withSources()
  )
