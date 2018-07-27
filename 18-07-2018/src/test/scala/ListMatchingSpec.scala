

import org.scalatest.{FunSuite, Matchers}

class ListMatchingSpec extends FunSuite with Matchers {

  val listMatching = new ListMatching


  test("passing a simple list in max method") {

    val actualResult = listMatching.maxList(List(1, 41, 5, 6, 7, 9, 4, 2, 4, 54, 5))
    val expectedResult = 54

    actualResult should equal(expectedResult)
  }

  test("passing an empty list in max method") {

    assertThrows[Exception](
      listMatching.maxList(List())
    )
  }

  test("passing a simple list to calculate length") {

    val actualResult = listMatching.length(List(1, 41, 5, 6, 7, 9, 4, 2, 4, 54, 5))
    val expectedResult = 11

    actualResult should equal(expectedResult)
  }


  test("passing a simple list in min method") {


    val actualResult = listMatching.minList(List(15, 41, 5, 6, 7, 9, 1, 5, 6, 2, 4, 54, 5))
    val expectedResult = 1

    actualResult should equal(expectedResult)
  }

  test("passing empty list in max method") {

    assertThrows[Exception](
      listMatching.minList(List())
    )
  }

  test("passing a simple list to calculate nth element from last") {

    val actualResult = listMatching.nth(List(1, 41, 5, 6, 7, 9, 4, 2, 4, 54, 5), 5)
    val expectedResult = 4

    actualResult should equal(expectedResult)
  }
}
