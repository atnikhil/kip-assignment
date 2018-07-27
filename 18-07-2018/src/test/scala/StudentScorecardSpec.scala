import org.scalatest.{FunSuite, Matchers}

class StudentScorecardSpec extends FunSuite with Matchers {


  val listOfStudents: List[Student] = List(
    Student(1, "Bob", "11", "A"),
    Student(2, "Dab", "10", "C"),
    Student(3, "Tab", "10", "B")
  )
  val listOfStudentsNew: List[Student] = List(
    Student(1, "Bob", "11", "A"),
    Student(2, "Dab", "10", "C"),
  )

  val listOfScoreCard: List[ScoreCard] = List(
    ScoreCard(1, 88.0f, 45.0f, 79.0f),
    ScoreCard(2, 67.0f, 80.0f, 45.0f),
    ScoreCard(3, 99.0f, 87.0f, 85.0f)
  )

  val listOfScoreCardNew: List[ScoreCard] = List(
    ScoreCard(1, 88.0f, 45.0f, 79.0f),
    ScoreCard(2, 67.0f, 80.0f, 45.0f),
  )

  val marksheet = new StudentScorecard

  test("Top three students in class.") {
    val actualResult = marksheet.topThreeStudents(listOfStudents, listOfScoreCard)
    val expectedResult = List((3, "Tab", "10", "B"), (1, "Bob", "11", "A"), (2, "Dab", "10", "C"))
    actualResult should equal(expectedResult)
  }

  test("Top three students in class when list size is less than 2.") {
    assertThrows[Exception](marksheet.topThreeStudents(listOfStudentsNew, listOfScoreCardNew))
  }

  test("For Subject1 topper") {
    val actualResult = marksheet.subject1Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

  test("For Subject2 topper") {
    val actualResult = marksheet.subject2Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

  test("For Subject3 topper") {
    val actualResult = marksheet.subject3Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

  test("Test for displaying marksheet") {
    val actualResult = marksheet.displayFullMarksheet(1, listOfStudents, listOfScoreCard)
    val expectedResult = "ID : 1 \n" +
      "NAME : Bob \n" +
      "DIVISION-SECTION : 11 - A \n" +
      "MARKS : \n" +
      "SUBJECTS : \n" +
      "  SUBJECT1 : 88.0 \n" +
      "  SUBJECT2 : 45.0 \n" +
      "  SUBJECT3 : 79.0 \n" +
      "  TOTAL MARKS : 212.0 \n"

    actualResult should equal(expectedResult)
  }

}
