package ttt.playstation

import akka.actor.{ActorSystem, Props}
import ttt.entites.{Game, Play, PlayStep, Player}

object TicTacToe extends App {

  val system = ActorSystem("tic-tac-toe")

  val playerOne = system.actorOf(Props[Player])
  val playerTwo = system.actorOf(Props[Player])
  val game = system.actorOf(Props[Game])


  while (true) {
    println("Enter index for Player 1:")
    playerOne ! Play(PlayStep(scala.io.StdIn.readInt(), 1), game)
    println("Enter index for Player 2:")
    playerOne ! Play(PlayStep(scala.io.StdIn.readInt(), 2), game)
  }

}