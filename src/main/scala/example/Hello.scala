package example

object Hello extends Greeting with App {

  def printGreetings() {
    println(greeting)
  }
  printGreetings()
}

trait Greeting {
  lazy val greeting: String = "hello"
}
