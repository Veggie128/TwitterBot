package Main

class FunWithTweets(){
    companion object {
        fun calcWords(tc: TweetCluster): Map<String, Int>{
            var ret = mutableMapOf<String, Int>()
            for ((date, text) in tc.content){
                var split = text.split(" ")
                for(word in split){
                    if(ret.containsKey(word)){
                        ret[word] = ret[word]!!.toInt() + 1
                    }else{
                        ret[word] = 0
                    }
                }
            }
            return ret
        }
    }
}