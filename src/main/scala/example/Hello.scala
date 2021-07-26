package example

object Hello extends Greeting with App {
  def printGreetings() {
    println(greeting)
  }
}

trait Greeting {
  lazy val greeting: String = "ciao angelo"
  lazy val greetingButEnglish: String = "Hello Angelo"
}
