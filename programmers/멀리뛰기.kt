class Solution {
    fun solution(n: Int): Long {
        var arr = LongArray(n+1)
        arr[0] = 1 // 0번째 경우의 수
        arr[1] = 1 // 1번째 경우의 수
        for(i in 2..n){
            arr[i] = (arr[i-2] + arr[i-1])%1234567
        }
        return arr[n] // 마지막칸 경우의 수 
    }
}
