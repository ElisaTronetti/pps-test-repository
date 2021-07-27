package example

import org.scalatest._

//style FunSuite
class Test1 extends FunSuite {
  test("The Hello object should say hello"){
    assert(Hello.greeting == "ciao angelo")
  }
}

//style FlatSpec
class Test2 extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "ciao angelo"
  }

  "Test " should "finish" in {
    Hello.printGreetings()
  }
}

//style FunSpec
class Test3 extends FunSpec {
  describe("The Hello object"){
    describe("when checked"){
      describe("should say hello"){
        assert(Hello.greeting == "ciao angelo")
      }
    }
  }
}

//style WordSpec
class Test4 extends WordSpec {
  "The Hello object" when {
    "checked" should {
      "say hello" in {
        assert(Hello.greeting == "ciao angelo")
      }
    }
  }
}

//style FeatureSpec
class Test5 extends FeatureSpec with GivenWhenThen {
  info("As the creator of the Hello object")
  info("I want him to be respectful")
  info("So I can call him when I want")
  info("And he has to say hello")

  feature("Check Hello object") {
    scenario("I check when I want") {

      Given("I check the Hello object")

      When("When I want")

      Then("He say hello")
      assert(Hello.greeting == "ciao angelo")
    }
  }
}