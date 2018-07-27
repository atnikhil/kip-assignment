import scala.annotation.tailrec

class ListMatching {


  def maxList(list: List[Int]): Int = {
    require(list.nonEmpty, "there must be at least one element in the list.")
    @tailrec
    def tailMax(list: List[Int], max: Int): Int = {
      list match {
        case Nil => max
        case _ => tailMax(list.tail, if (max < list.head) list.head else max)
      }
    }

    tailMax(list.tail, list.head)

  }

  def length(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case _ => length(list.tail) + 1
    }
  }

  def minList(list: List[Int]): Int = {
    require(list.nonEmpty, "there must be at least one element in the list.")
    @tailrec
    def tailMax(list: List[Int], min: Int): Int = {
      list match {
        case Nil => min
        case _ => tailMax(list.tail, if (min > list.head) list.head else min)
      }
    }

    tailMax(list.tail, list.head)
  }


  def nth(list: List[Int], n: Int): Int = {
    @tailrec
    def tailNth(list: List[Int], n: Int, num: Int): Int = {
      n match {
        case 0 => num
        case _ => tailNth(list.init, n - 1, list.last)
      }
    }

    tailNth(list, n, list.head)
  }
}
