class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size){-1}
        val dq = ArrayDeque<Int>()
        for(i in numbers.indices){
            while(dq.isNotEmpty() && numbers[dq.last()] < numbers[i]){
                val index = dq.removeLast()
                answer[index] = numbers[i]
            }
            dq.addLast(i)
        }
        return answer
    }
}
