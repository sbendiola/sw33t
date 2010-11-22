import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val scalatest = "org.scalatest" % "scalatest" % "1.2" % "test"
  val mockito =   "org.mockito" % "mockito-core" % "1.8.5"
}
