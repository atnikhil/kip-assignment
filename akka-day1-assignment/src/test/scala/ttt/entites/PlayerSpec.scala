package ttt.entites

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}


class PlayerSpec extends TestKit(ActorSystem("MySpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "An Game actor" should {


    "be able to change and return the state of tic tac toe game" in {
      val game = system.actorOf(Props[Game])

      game ! PlayStep(4, 1)
      expectMsgAllClassOf(classOf[TicTacToeMap])

    }

    "be able to send Tic Tac Toe Map and a GameOver when a condition is met" in {
      val game = system.actorOf(Props[Game])
      game ! PlayStep(1, 1)
      game ! PlayStep(2, 1)
      game ! PlayStep(3, 1)
      expectMsgAllClassOf(classOf[TicTacToeMap], classOf[TicTacToeMap])
      expectMsg(GameOver)

    }
    "be able to send PlaceAlreadyFilled Message when a PlayStep is sent on a non empty step" in {
      val game = system.actorOf(Props[Game])
      game ! PlayStep(2, 1)
      game ! PlayStep(2, 2)
      expectMsgAllClassOf(classOf[TicTacToeMap], classOf[PlaceAlreadyFilled])

    }
  }
}