package Main

import java.io.*
import java.util.*

class TweetCluster(val user: String): Serializable{
    var content = mutableMapOf<Date, String>()
    var size = 0;

    fun add(text: String, date: Date){
        if(!content.containsKey(date)){//only add tweet is not already in list
            content[date] = text.replace("\n", "")
            size++
        }

    }

    //to load serialized data back in Object
    companion object {
        fun loadState(target: File): TweetCluster? {
            try {
                val inputStream = FileInputStream(target.absolutePath)
                val input = ObjectInputStream(inputStream)
                val tc = input.readObject() as TweetCluster
                input.close()
                inputStream.close()
                return tc
            } catch (i: IOException) {
                i.printStackTrace()
                return null
            } catch (c: ClassNotFoundException) {
                c.printStackTrace()
                return null
            }

        }
    }

    //to serialize data
    fun saveState(){
        try {
            val fileOut = FileOutputStream(File("$user.ser").absolutePath)
            val out = ObjectOutputStream(fileOut)
            out.writeObject(this)
            out.close()
            fileOut.close()
        } catch (i: IOException) {
            i.printStackTrace()
        }

    }

    override fun toString(): String {
        var ret = "Collected $size Tweets form @$user\n"
        for ((key, value) in content){
            ret += "$key ->($value)\n"
        }
        return ret
    }
}