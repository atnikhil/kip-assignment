case class Student(id: Int, name: String, division: String, section: String)

case class ScoreCard(id: Int, subject1: Float, subject2: Float, subject3: Float, totalMarks: Float)

object ScoreCard {
  def apply(id: Int, subject1: Float, subject2: Float, subject3: Float): ScoreCard = {
    val totalMarks = subject1 + subject2 + subject3
    new ScoreCard(id, subject1, subject2, subject3, totalMarks)

  }

}

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

  val scoreIdOfTopThreeStudents = listOfScoreCard.sortWith(_.totalMarks > _.totalMarks)
    .slice(0, 3).map(_.id)
  scoreIdOfTopThreeStudents.map(studentId => listOfStudents.filter(_.id == studentId).head)
    .map(stud => (stud.id, stud.name, stud.division, stud.section))
