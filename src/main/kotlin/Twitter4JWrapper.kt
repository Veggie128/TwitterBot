package Main

import twitter4j.Paging
import twitter4j.TwitterFactory

class Twitter4JWrapper{
    companion object {
        var twitter = TwitterFactory.getSingleton()
    }

    fun getMessagesFromUser(user: String, numberOfMessages: Int): TweetCluster {
        var ret = TweetCluster(user)
        var count = 1;
        while (ret.size < numberOfMessages) {
            var paging = Paging(count, numberOfMessages - ret.size)
            var currentpage = twitter.getUserTimeline(user, paging)
            for (tweet in currentpage){
                ret.add(tweet.text, tweet.createdAt)
            }
            count++
        }
        return ret
    }

    fun getTweetsfrom(){

    }
}