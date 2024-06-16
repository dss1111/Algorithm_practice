var n: Int = 0
var m: Int = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>
var dx = intArrayOf(0,0,-1,1)
var dy = intArrayOf(-1,1,0,0)
var maxSize = 0
var picture = 0
fun main(args: Array<String>) {
    val (strN,strM) = readln().split(" ")
    n = strN.toInt()
    m = strM.toInt()
    arr = Array(n){IntArray(m)}
    visit = Array(n){ BooleanArray(m) }
    for(i in 0 until n ){
        val line = readln().split(" ")
        for(j in 0 until m){
            arr[i][j] =line[j].toInt()
        }
    }
    for(i in 0 until n ){
        for(j in 0 until m){
            if(visit[i][j]) continue
            if(arr[i][j]==0) continue
            visit[i][j] = true
            var size = arrayOf(1)
            dfs(i,j,size)
            maxSize = maxOf(maxSize, size[0])
            picture++
        }
    }
    println(picture)
    println(maxSize)
}
fun dfs(y:Int ,x:Int, size: Array<Int>){
    for(i in 0..3){
        val nextY = y + dy[i]
        val nextX = x + dx[i]
        if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue
        if(visit[nextY][nextX]) continue
        if(arr[nextY][nextX] == 0) continue
        visit[nextY][nextX] = true
        size[0]++
        dfs(nextY,nextX, size)
    }
}
