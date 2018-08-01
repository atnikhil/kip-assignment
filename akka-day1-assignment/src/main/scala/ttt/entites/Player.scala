package ttt.entites

import akka.actor.{Actor, ActorRef}

class Player extends Actor with TicTacToeMapper {
  override def receive: Receive = {
    case TicTacToeMap(msg) => printMapInArray(msg)
    case Play(playStep: PlayStep, game) => game ! playStep
    case PlaceAlreadyFilled => println("the place is already filled")
    case GameOver => println("game is over")
  }
}

class Game extends Actor with TicTacToeLogic {
  var map = Array(0, 0, 0, 0, 0, 0, 0, 0, 0)

  override def receive: Receive = {
    case PlayStep(index, player) =>
      if (index - 1 < 0 || (index - 1) > 8) {
        sender() ! TicTacToeMap(map)
      }
      else {
        if (map(index - 1) != 0) {
          sender() ! PlaceAlreadyFilled(index - 1)
        }
        else {
          map(index - 1) = player
          if (isGameOver(map)) {
            sender() ! GameOver
          }
          else
            sender() ! TicTacToeMap(map)
        }
      }

  }
}

sealed trait Message

case class Play(playStep: PlayStep, actorRef: ActorRef) extends Message

case class PlayStep(index: Int, player: Int) extends Message

case class TicTacToeMap(map: Array[Int]) extends Message

case class PlaceAlreadyFilled(place: Int) extends Message

case object GameOver extends Message

trait TicTacToeMapper {
  def printMapInArray(elements: Array[Int]): Unit = {
    (0 to 8).foreach { index =>
      elements(index) match {
        case 0 => print(" - ")
        case 1 => print(" X ")
        case 2 => print(" Y ")
      }
      if ((index + 1) % 3 == 0) println("\n\n") else print("")
    }
  }
}

trait TicTacToeLogic {
  def isGameOver(map: Array[Int]): Boolean = {
    val validTriples =
      List(
        (1, 2, 3),
        (4, 5, 6),
        (7, 8, 9),
        (1, 4, 7),
        (2, 5, 8),
        (3, 6, 9),
        (1, 5, 9),
        (3, 5, 7)
      ) map (triple =>
        (map(triple._1 - 1), map(triple._2 - 1), map(triple._3 - 1)) match {
          case (1, 1, 1) => true
          case (2, 2, 2) => true
          case _ => false
        })
    validTriples.reduce((a, b) => a || b)
  }
}