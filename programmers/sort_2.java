import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=1;i<=citations.length;i++)
        {
            if(citations[citations.length-i]>=i)
            {
                answer=i;
            }
        }
        return answer;
    }
}
