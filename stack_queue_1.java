import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len=progresses.length;
        int [] p = new int [len]; 
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            p[i]=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0)
            {
                p[i]+=1;
            }
        }
        Stack<Integer> stack = new Stack<>();
        int count;
        for(int i=0;i<len;i++)
        {
            stack.push(p[i]);
            count=0;
            if(i==len-1)
            {
                while(!stack.empty())
                {
                    stack.pop();
                    count++;
                }
                arrayList.add(count);
            }
            else if(p[i]<p[i+1]) //이부분이 문제.. 바로이전이랑 비교하지말고 큐를 이용해서 가장큰거랑 비교하면 풀수 있을듯
            {
                while(!stack.empty())
                {
                    stack.pop();
                    count++;
                }
                arrayList.add(count);
            }
        }
        int[] answer = new int[arrayList.size()];
        int size=0;
        for(int temp:arrayList){
            answer[size++]=temp;
        }
        return answer;
    }
}
