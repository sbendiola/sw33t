import sbt._

class config(info: ProjectInfo) extends DefaultProject(info) {
  lazy val scalatest = "org.scalatest" % "scalatest" % "1.2"
}
