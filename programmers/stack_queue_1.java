import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int len=progresses.length;
        int p=0;
        for(int i=0;i<len;i++)
        {
            p=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0)
            {
                p+=1;
            }
            q.add(p);
        }

        int target = q.poll();
        int cnt = 1;
        int num=0;
        while(!q.isEmpty()) 
        {
            num = q.poll();
            if(target >= num) 
            {
                cnt++;
            }
            else 
            {
                arrayList.add(cnt);
                cnt = 1;
                target = num;
            }
        }
        arrayList.add(cnt);
        int[] answer = new int[arrayList.size()];
        int size=0;
        for(int temp:arrayList){
            answer[size++]=temp;
        }
        return answer;
    }
}
