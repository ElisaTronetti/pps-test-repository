package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "ciao angelo"
  }

  "Test " should "finish" in {
    Hello.printGreetings()
  }

}
