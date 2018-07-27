
import FutureApplication.{futureObject, result}
import scala.concurrent.ExecutionContext.Implicits.global

import org.scalatest.{FunSuite, Matchers}

import scala.util.{Failure, Success}

class FutureFileSpec extends FunSuite with Matchers {

  val  file=new FutureFile

  test("passing directory") {

    val actualResult = file.findDirectory("src/main/scala") onComplete {
      case Success(ans) => println(ans)
      case Failure(e) => println(e.getMessage)}
    val expectedResult =
      Thread.sleep(5000)
    actualResult should equal(expectedResult)
  }

  test("passing another directory") {

    val actualResult = file.findDirectory("src/main/test") onComplete {
      case Failure(e) => println(e.getMessage)}
    val expectedResult =
      Thread.sleep(5000)
    actualResult should equal(expectedResult)
  }
}
