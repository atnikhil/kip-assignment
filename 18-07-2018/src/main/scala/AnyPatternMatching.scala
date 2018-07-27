class AnyPatternMatching {

  def matchAnyPattern(anyType: Any): String = anyType match {
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Pet => s"pet: ${d.s}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => s"thanks for the map: ${m.toString}"
    case _ => "Unknown"
  }

  case class Pet(s: String )


}
