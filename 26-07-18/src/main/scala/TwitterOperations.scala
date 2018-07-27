
import java.util

import twitter4j.conf.ConfigurationBuilder
import twitter4j.{Query, Status, TwitterFactory}

import scala.annotation.tailrec
import scala.collection.JavaConversions._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class TwitterOperations {

  def setConfigurations(): ConfigurationBuilder = {

    val config = new ConfigurationBuilder
    config.setDebugEnabled(true)
      .setOAuthConsumerKey("U4vRNr1ZCY7jCnDCsEzaOqKgH")
      .setOAuthConsumerSecret("mE0pCdTUcsnATZrResDAb5by79X4tvrZXGJmJbCS48ILSKwsBR")
      .setOAuthAccessToken("723372793270665217-cD2bicHmEKovD0uYk80z3IOEh8TAeOQ")
      .setOAuthAccessTokenSecret("zn8toS7lkOBXDlbIHX3RwdCkZNR1E5EGqvzkEStL8bSW7")

  }

  def retrieveTweet(input: String): util.List[Status] = {
    val twitterFactory = new TwitterFactory(setConfigurations().build)
    val twitter = twitterFactory.getInstance
    twitter.search(new Query("#" + input)).getTweets
  }

  def getTweets(input: String): Future[Int] = Future {
    val tweetList: util.List[Status] = retrieveTweet(input)
    tweetList.size
  }

  def averageTweetsInADay(input: String): Future[Int] = {
    getTweets(input).map(ele => ele / 7)
  }


  def averageLikesPerTweet(input: String): Future[Int] = Future {
    val likes: util.List[Status] = retrieveTweet(input)
    val totalLikes = (for (like: Status <- likes) yield like.getFavoriteCount).toList
    val totalLikesPerTweet = getTotalOfList(totalLikes, 0)
    val tweets = likes.size
    tweets match {
      case 0 => throw new ArithmeticException()
      case _ => totalLikesPerTweet / tweets
    }
  }

  def averageReTweetPerTweet(input: String): Future[Int] = Future {
    val reTweet: util.List[Status] = retrieveTweet(input)
    val totalTweets = (for (like: Status <- reTweet) yield like.getRetweetCount).toList
    val totalTweetsPerTweet = getTotalOfList(totalTweets, 0)
    val tweets = reTweet.size
    tweets match {
      case 0 => throw new ArithmeticException()
      case _ => totalTweetsPerTweet / tweets
    }
  }

  @tailrec
  private def getTotalOfList(list: List[Int], sum: Int): Int = {
    list match {
      case a :: rest => getTotalOfList(rest, sum + a)
      case _ => sum
    }
  }
}

/*to get username and tweet
for (status: Status <- statuses) yield (status.getUser, status.getText)*/
