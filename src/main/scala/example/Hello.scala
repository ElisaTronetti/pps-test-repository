package example

object Hello extends Greeting with App {

  def printGreetings() {
    println(greeting)
    println(1+0)
  }

  printGreetings()
}

trait Greeting {
  lazy val greeting: String = "hello"
  println("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
}
