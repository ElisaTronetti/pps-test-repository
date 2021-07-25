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

resolvers += "Atlassian's Maven Public Repository" at "https://repo.maven.apache.org/maven2/"

// Tests Configurations
val NumberOfTestProcessors = 4
// Run tests in parallel
IntegrationTest / testForkedParallel := true
concurrentRestrictions in Global := Seq(Tags.limitAll(NumberOfTestProcessors))


// Custom task for quality assurance
lazy val check = taskKey[Unit]("Run CPD and Scoverage tasks")

check := {
  cpd.value
  coverageReport.value
}

// Plugins Configurations

// scoverage plugin keys
coverageEnabled := true
coverageMinimum := 70 //%
coverageFailOnMinimum := true
coverageHighlighting := true

// sbt-cpd keys
cpdMinimumTokens := 50
cpdFailOnDuplicates := true

//
ThisBuild / githubWorkflowBuildPostamble ++= List(
  WorkflowStep.Sbt(List("cpd")),
  WorkflowStep.Sbt(List("coverage"))
)