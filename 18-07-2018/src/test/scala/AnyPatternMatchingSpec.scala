

import org.scalatest.{FunSuite, Matchers}

class AnyPatternMatchingSpec extends FunSuite with Matchers {

  val anypattern = new AnyPatternMatching
  test("passing a integer") {

    val actualResult = anypattern.matchAnyPattern(5)
    val expectedResult = "thanks for the int: 5"

    actualResult should equal(expectedResult)
  }

  test("passing a string") {

    val actualResult = anypattern.matchAnyPattern("Hello")
    val expectedResult = "you gave me this string: Hello"

    actualResult should equal(expectedResult)
  }

  test("passing a float") {

    val actualResult = anypattern.matchAnyPattern(5.54f)
    val expectedResult = "thanks for the float: 5.54"

    actualResult should equal(expectedResult)
  }

  test("passing an array of integer") {

    val actualResult = anypattern.matchAnyPattern(Array(1, 2, 3, 4, 5))
    val expectedResult = "an array of int: 1,2,3,4,5"

    actualResult should equal(expectedResult)
  }

  test("passing an array of string") {

    val actualResult = anypattern.matchAnyPattern(Array("my", "name", "is", "nikhil", "sharma"))
    val expectedResult = "an array of strings: my,name,is,nikhil,sharma"

    actualResult should equal(expectedResult)
  }

  test("passing a case class") {

    val caseClass=anypattern.Pet("dog")
    val actualResult = anypattern.matchAnyPattern(caseClass)
    val expectedResult = "pet: dog"

    actualResult should equal(expectedResult)
  }

  test("passing a list") {

    val actualResult = anypattern.matchAnyPattern(List(1,2,6,5))
    val expectedResult = "thanks for the List: List(1, 2, 6, 5)"

    actualResult should equal(expectedResult)
  }

  test("passing a map") {

    val actualResult = anypattern.matchAnyPattern(Map(1->55,2->"hello"))
    val expectedResult = "thanks for the map: Map(1 -> 55, 2 -> hello)"

    actualResult should equal(expectedResult)
  }

  test("passing a wrong input") {

    val actualResult = anypattern.matchAnyPattern(8.9)
    val expectedResult =  "Unknown"

    actualResult should equal(expectedResult)
  }
}