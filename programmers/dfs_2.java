class Solution {
    int min=51;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean include=false;
        boolean [] visited=new boolean [words.length];
        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(target))
                include=true;
        }
        if(!include)
            return 0;
        dfs(begin,target,visited,words,0);
        return min;
    }
    boolean check(String a, String b)
    {
        int cnt=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
                cnt++;
            if(cnt>1)
                return false;
        }
        return true;
    }
    void dfs(String now, String target ,boolean []visited,String[] words,int level)
    {
        if(now.equals(target))
        {
            if(min>level-1)
                min=level-1;
        }
        boolean go=false;
        for(int i=0;i<words.length;i++)
        {
            if(check(now,words[i]))
            {
                go=true;
                if(!visited[i])
                {
                    visited[i]=true;
                    dfs(words[i],target,visited,words,level+1);
                }
            }
        }
        if(go==false)
        {
            min=0;
        }
    }
}
