import Dependencies._
import sbt.Developer

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example" //TODO
ThisBuild / organizationName := "TeFaTaPs"

lazy val root = (project in file("."))
  .settings(
    name := "pps-test-repository",
    libraryDependencies += scalaTest % Test
  )

ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / description := "Some description about your project." //TODO
ThisBuild / homepage    := Some(url("https://github.com/example/project")) //TODO

 ThisBuild / developers := List(
   Developer(
     id    = "AngeloFilaseta",
     name  = "Filaseta Angelo",
     email = "angelo.filaseta@studio.unibo.it",
     url   = url("https://github.com/AngeloFilaseta")
   ),
   Developer(
     id    = "PieroSanchi",
     name  = "Sanchi Piero",
     email = "piero.sanchi@studio.unibo.it",
     url   = url("https://github.com/PieroSanchi")
   ),
   Developer(
     id    = "Tale152",
     name  = "Talmi Alessandro",
     email = "alessandro.talmi@studio.unibo.it",
     url   = url("https://github.com/Tale152")
   ),
   Developer(
     id    = "ElisaTronetti",
     name  = "Tronetti Elisa",
     email = "elisa.tronetti@studio.unibo.it",
     url   = url("https://github.com/ElisaTronetti")
   )
 )

 ThisBuild / pomIncludeRepository := { _ => false }
 ThisBuild / publishTo := {
   val nexus = "https://oss.sonatype.org/"
   if (isSnapshot.value) {
      Some("snapshots" at nexus + "content/repositories/snapshots")
   } else {
     Some("releases" at nexus + "service/local/staging/deploy/maven2")
   }
 }
 ThisBuild / publishMavenStyle := true

// Tests Configurations
val NumberOfTestProcessors = 4
// Run tests in parallel
IntegrationTest / testForkedParallel := true
concurrentRestrictions in Global := Seq(Tags.limitAll(NumberOfTestProcessors))

// Plugins Configurations

// scoverage plugin keys
coverageEnabled := true
coverageMinimum := 60 //%
coverageFailOnMinimum := true
coverageHighlighting := true

// Add scoverage to the workflow
ThisBuild / githubWorkflowBuildPostamble ++= List(
  WorkflowStep.Sbt(List("coverageReport"), name = Some("Coverage")),
)