package example

object Hello extends Greeting with App {
  def printGreetings() {
    println(greeting)
  }
}

trait Greeting {
  lazy val greeting: String = "ciao angelo"
  val lalala: Int = 10
  val myNameIsYoshikageKiraIm33YearsOld = "I live in Morio"
}
