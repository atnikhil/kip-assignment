
import org.scalatest.{FunSuite, Matchers}


class EmailParsingSpec extends FunSuite with Matchers {

  val email = new EmailParsing
  test("passing wrong input") {

    val actualResult = email.emailRegex("nikhil sharma")
    val expectedResult = None
    actualResult should equal(expectedResult)
  }

  test("passing valid input"){

    val actualResult = email.emailRegex("nikhil.sharma@knoldus.com")
    val expectedResult = Some("nikhil.sharma","knoldus.com")
    actualResult should equal(expectedResult)
  }
}
