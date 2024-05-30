import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.absoluteValue

data class Sample(val num : Int, val abs: Int)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine().toInt()
    val compare = compareBy<Sample>{it.abs}.thenBy { it.num }
    val pq = PriorityQueue<Sample>(compare)
    val result = StringBuilder()
    for(i in 0 until line){
        var input = br.readLine().toInt()
        when(input){
            0 -> if(pq.isEmpty()) result.append(0).append("\n") else result.append(pq.poll().num).append("\n")
            else -> {pq.add(Sample(input,input.absoluteValue))}
        }
    }
    println(result)
}
