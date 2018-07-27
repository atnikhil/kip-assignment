

import org.scalatest.{FunSuite, Matchers}


class UrlExtractorSpec extends FunSuite with Matchers {

  val url = new UrlExtractor

  test("passing url in parts") {

    val actualResult = url.URL.apply("https", "aws.amazon.com", "console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))
    val expectedResult = "https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112"
    actualResult should equal(expectedResult)
  }

  test("passing empty url in apply") {

    assertThrows[Exception](url.URL.apply("", "awka", "bhjh", Map()))
  }
  test("passing a url unapply") {

    val actualResult = url.URL.unapply("https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112")
    val expectedResult = Some("https", "aws.amazon.com", "console/home", Map("state" -> "hash", "isauthcode" -> "true",
      "code" -> "112"))
    actualResult should equal(expectedResult)
  }
  test("passing an empty url in unapply") {

    assertThrows[Exception](url.URL.unapply(""))
  }
}
