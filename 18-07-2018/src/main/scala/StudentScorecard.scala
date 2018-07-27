
case class Student(id: Int, name: String, division: String, section: String)

case class ScoreCard(id: Int, subject1: Float, subject2: Float, subject3: Float, totalMarks: Float)

class StudentScorecard {

  val listOfStudents: List[Student] = List(
    Student(1, "Bob", "11", "A"),
    Student(2, "Dab", "10", "C"),
    Student(3, "Tab", "10", "B")
  )

  val listOfScoreCard: List[ScoreCard] = List(
    ScoreCard(1, 88.0f, 45.0f, 79.0f),
    ScoreCard(2, 67.0f, 80.0f, 45.0f),
    ScoreCard(3, 99.0f, 87.0f, 85.0f)
  )

  def topThreeStudents(listOfStudents: List[Student], listOfScorecard: List[ScoreCard]): List[(Int, String, String, String)] = {
    val scoreIdOfTopThreeStudents = listOfScoreCard.sortWith(_.totalMarks > _.totalMarks)
      .slice(0, 3).map(_.id)
    scoreIdOfTopThreeStudents.map(studentId => listOfStudents.filter(_.id == studentId).head)
      .map(stud => (stud.id, stud.name, stud.division, stud.section))
  }

  def subject1Topper(listOfStudents: List[Student], listOfScorecard: List[ScoreCard]): (Int, String, String, String, Float, Float, Float, Float) = {
    val subject1Details = listOfScoreCard.sortWith(_.subject1 > _.subject1).head
    val subject1TopperDetails = listOfStudents.filter(_.id == subject1Details.id).head
    (subject1TopperDetails.id, subject1TopperDetails.name, subject1TopperDetails.division, subject1TopperDetails.section, subject1Details.subject1, subject1Details.subject2, subject1Details.subject3, subject1Details.totalMarks)
  }

  def subject2Topper(listOfStudents: List[Student], listOfScorecard: List[ScoreCard]): (Int, String, String, String, Float, Float, Float, Float) = {
    val subject2Details = listOfScoreCard.sortWith(_.subject1 > _.subject1).head
    val subject2TopperDetails = listOfStudents.filter(_.id == subject2Details.id).head
    (subject2TopperDetails.id, subject2TopperDetails.name, subject2TopperDetails.division, subject2TopperDetails.section, subject2Details.subject1, subject2Details.subject2, subject2Details.subject3, subject2Details.totalMarks)
  }

  def subject3Topper(listOfStudents: List[Student], listOfScorecard: List[ScoreCard]): (Int, String, String, String, Float, Float, Float, Float) = {
    val subject3Details = listOfScoreCard.sortWith(_.subject1 > _.subject1).head
    val subject3TopperDetails = listOfStudents.filter(_.id == subject3Details.id).head
    (subject3TopperDetails.id, subject3TopperDetails.name, subject3TopperDetails.division, subject3TopperDetails.section, subject3Details.subject1, subject3Details.subject2, subject3Details.subject3, subject3Details.totalMarks)
  }

  def displayFullMarksheet(studentId: Int, listOfStudents: List[Student], listOfScoreCard: List[ScoreCard]): String = {
    val scoreCardDetail = listOfScoreCard.filter(_.id == studentId).head
    val studentDetails = listOfStudents.filter(_.id == studentId).head
    s"ID : $studentId \n" +
      s"NAME : ${studentDetails.name} \n" +
      s"DIVISION-SECTION : ${studentDetails.division} - ${studentDetails.section} \n" +
      s"MARKS : \n" +
      s"SUBJECTS : \n" +
      s"  SUBJECT1 : ${scoreCardDetail.subject1} \n" +
      s"  SUBJECT2 : ${scoreCardDetail.subject2} \n" +
      s"  SUBJECT3 : ${scoreCardDetail.subject3} \n" +
      s"  TOTAL MARKS : ${scoreCardDetail.totalMarks} \n"
  }


}

object ScoreCard {
  def apply(id: Int, subject1: Float, subject2: Float, subject3: Float): ScoreCard = {
    val totalMarks = subject1 + subject2 + subject3
    new ScoreCard(id, subject1, subject2, subject3, totalMarks)

  }

}