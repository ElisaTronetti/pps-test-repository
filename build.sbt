import Dependencies._

ThisBuild / scalaVersion := "2.12.8"

lazy val root = (project in file("."))
  .settings(
    name := "pps-test-repository",
    libraryDependencies += scalaTest % Test
  )

ThisBuild / description := "Some description about your project." //TODO
ThisBuild / homepage    := Some(url("https://github.com/example/project")) //TODO

// Tests Configurations
val NumberOfTestProcessors = 4
// Run tests in parallel
IntegrationTest / testForkedParallel := true
concurrentRestrictions in Global := Seq(Tags.limitAll(NumberOfTestProcessors))

/* Plugins Configurations */

// a publish job is not desired
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

// scoverage plugin keys
coverageEnabled := true
coverageMinimum := 60 //%
coverageFailOnMinimum := true
coverageHighlighting := true

// Add scoverage to the workflow
ThisBuild / githubWorkflowBuildPostamble ++= List(
  WorkflowStep.Sbt(List("coverageReport"), name = Some("Coverage"))
)