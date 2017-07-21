package Main

import java.io.File

/**
 * Created by Jonas on 20.07.17.
 */
fun main(args: Array<String>) {
//    val t4j = Twitter4JWrapper()
//    var listofusers = listOf<String>("realDonaldTrump", "BarackObama", "justinbieber", "selenagomez", "taylorswift13")
//    for(user in listofusers){
//        var tc = t4j.getMessagesFromUser(user, 500)
//        tc.saveState()
//    }
    var trump = TweetCluster.loadState(File("realDonaldTrump.ser"))
    var tmp = FunWithTweets.calcWords(trump!!)
    println(tmp)
}