import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    for(i in 0 until n){
        val input = br.readLine().split(" ")
        when(input[0]){
            "1" -> deque.addFirst(input[1].toInt())
            "2" -> deque.addLast(input[1].toInt())
            "3" -> if(!deque.isEmpty()) sb.append(deque.removeFirst()).append("\n") else sb.append(-1).append("\n")
            "4" -> if(!deque.isEmpty()) sb.append(deque.removeLast()).append("\n") else sb.append(-1).append("\n")
            "5" -> sb.append(deque.size).append("\n")
            "6" -> if(deque.isEmpty()) sb.append(1).append("\n") else sb.append(0).append("\n")
            "7" -> if(!deque.isEmpty()) sb.append(deque.first()).append("\n") else sb.append(-1).append("\n")
            "8" -> if(!deque.isEmpty()) sb.append(deque.last()).append("\n") else sb.append(-1).append("\n")
        }
    }
    println(sb)
}
