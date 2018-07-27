import scala.language.postfixOps

class UrlExtractor {

  object URL extends App {

    def apply(protocol: String, domain: String, path: String, params: Map[String, String]): String = {
      require(!(protocol.isEmpty || domain.isEmpty || path.isEmpty || params.isEmpty), "give valid parameters")
      s"$protocol://$domain/$path?${params.map(ele => ele._1 + "=" + ele._2).mkString("&")}"
    }

    def unapply(url: String): Option[(String, String, String, Map[String, String])] = {
      require(url.nonEmpty, "give a valid url")
      val part1 = url.split("://", 2)
      val part2 = part1(1).split("/", 2)
      val part3 = part2(1).split('?')
      val part4 = part3(1).split("=|&", 6)


      val map = Map(part4(0) -> part4(1), part4(2) -> part4(3), part4(4) -> part4(5))

      Some(part1(0), part2(0),
        part3(0), map)
      /* if (part1.length == 2 && part2.length == 2 && part3.length == 2 && part4.length == 6) Some(part1(0), part2(0),
         part3(0), map) else None*/

    }

  }

}