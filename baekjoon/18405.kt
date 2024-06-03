import java.util.LinkedList
import java.util.Queue

val nextLoc = arrayOf(Pair(0, -1), Pair(1, 0), Pair(-1, 0), Pair(0, 1))
lateinit var array: Array<IntArray>
var N = 0
var K = 0

fun main(args: Array<String>) {
    var line = readln().split(" ")
    N = line[0].toInt()
    K = line[1].toInt()
    array = Array(N) { IntArray(N) }
    val virusList = mutableListOf<Triple<Int, Int, Int>>()

    for (i in 0 until N) {
        line = readln().split(" ")
        for (j in 0 until N) {
            array[i][j] = line[j].toInt()
            if (array[i][j] != 0) {
                virusList.add(Triple(array[i][j], i, j))
            }
        }
    }

    val (S, X, Y) = readln().split(" ").map { it.toInt() }
    virusList.sortBy { it.first }
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList(virusList)

    var time = 0
    while (time < S) {
        val size = queue.size
        for (i in 0 until size) {
            val (virusType, x, y) = queue.poll()
            for (l in nextLoc) {
                val nextX = x + l.first
                val nextY = y + l.second
                if (nextX !in 0 until N || nextY !in 0 until N ) continue
                if (array[nextX][nextY] != 0) continue
                array[nextX][nextY] = virusType
                queue.offer(Triple(virusType, nextX, nextY))
            }
        }
        time++
    }
    println(array[X - 1][Y - 1])
}
