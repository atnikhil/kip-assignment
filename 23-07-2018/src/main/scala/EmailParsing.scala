class EmailParsing {

  def emailRegex(string: String):Option[(String, String)]={
    val email = """^([A-Z0-9a-z._%+-]+)@([A-Z0-9a-z._%+-]+[.]+[A-Z0-9a-z._%+-]+)$""".r
    string match {
      case email(user, domain) => Some(user,domain)
      case _ => None
    }
  }
}