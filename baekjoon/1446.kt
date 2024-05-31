fun main(args: Array<String>) {
    var line = readln()!!.split(" ")
    val N = line[0].toInt()
    val D = line[1].toInt()
    val distArr = IntArray(D+1){it}
    var list = mutableListOf<Triple<Int,Int,Int>>()
    for(i in 0 until N){
        line = readln()!!.split(" ")
        val start = line[0].toInt()
        val end = line[1].toInt()
        val dist = line[2].toInt()
        if(end > D) continue
        list.add(Triple(start,end,dist))
    }
    for(i in 0..D){
        if(i > 0){
            distArr[i] = minOf(distArr[i],distArr[i-1]+1)
        }
        for((start,end,dist) in list){
            if(i==start && i + dist < D+1){
                distArr[end] = minOf(distArr[end], distArr[start] + dist) // 거리 갱신
            }
        }
    }
    println(distArr[D])
}
