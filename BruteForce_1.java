import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] point={0,0,0};
        int [] ans2={1,3,4,5};
        int [] ans3={3,1,2,4,5};
        int now2=0;
        int now3=0;
        for(int i=0;i<answers.length;i++)
        {
            switch(i%5)
            {
                case 0:
                    if(answers[i]==1)
                        point[0]+=1;
                    break;
                case 1:
                    if(answers[i]==2)
                        point[0]+=1;
                    break;
                case 2:
                    if(answers[i]==3)
                        point[0]+=1;
                    break;
                case 3:
                    if(answers[i]==4)
                        point[0]+=1;
                    break;
                case 4:
                    if(answers[i]==5)
                        point[0]+=1;
                    break;
            }
            if(i%2==0)
            {
                if(answers[i]==2)
                   point[1]+=1;
            }
            else
            {
                if(answers[i]==ans2[now2%4])
                    point[1]+=1;    
                now2++;
            }
            if(answers[i]==ans3[now3%5])
                point[2]+=1;
            if(i%2==1)
            {
                now3++;
            }
        }
        int max=point[0];
        for(int i=1;i<3;i++)
        {
            if(max<point[i])
                max=point[i];
        }
        ArrayList <Integer>ans = new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            if(point[i]==max)
                ans.add(i);
        }
        int[] answer = new int[ans.size()];
        for (int i=0; i < answer.length; i++)
        {
            answer[i] = ans.get(i).intValue()+1;
        }
        return answer;
    }
}
