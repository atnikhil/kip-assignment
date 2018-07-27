
import org.scalatest.AsyncFlatSpec

class TwitterOperationsSpec extends AsyncFlatSpec {

  val tweetOperations = new TwitterOperations

  "Twitter class" should "get the tweets" in {
    tweetOperations.getTweets("hello").map(actual => assert(actual >= 1))
  }

  it should "get the average number of tweets" in {
    tweetOperations.averageTweetsInADay("hello").map(actual => assert(actual >= 1))
  }

  it should "get the average number of likes per tweet" in {
    tweetOperations.averageLikesPerTweet("hello").map(actual => assert(actual >= 0))
  }

  it should "give exception when there exists no tweet for likesPerTweet" in {
    recoverToSucceededIf[ArithmeticException] {
      tweetOperations.averageLikesPerTweet("itrdex")
    }
  }

  it should "get the average number of re-tweets per tweet" in {
    tweetOperations.averageReTweetPerTweet("hello").map(actual => assert(actual >= 0))
  }

  it should "give exception when there exists no tweet for reTweet" in {
    recoverToSucceededIf[ArithmeticException] {
      tweetOperations.averageLikesPerTweet("kjhhggd")
    }
  }

}
