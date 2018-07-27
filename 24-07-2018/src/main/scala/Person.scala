/*class Person(var firstName: String, var lastName: String) {
    def contentsEqual(other: Any) = other match {
      case that: Person => this.firstName == that.firstName && this.lastName == that.lastName
      case _ => false
    }
  }

  val p1= new Person("Nikhil", "Sharma")
  import scala.collection._
  val coll = mutable.HashSet(p1)
  p1.firstName ="Nikhil"
  coll contains p1
  //coll.iterator contains p1

*/