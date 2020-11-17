#include <string>
#include <vector>
#include <algorithm>
using namespace std;
bool dfs(string now,vector<vector<string>>&tickets,vector<bool>&visit,vector<string>&answer,vector<string>&route,int level)
{
    route.push_back(now); //경로 추가
    if(level==tickets.size())   //모든항공권 사용
    {
        answer = route; 
        return true;
    }
    for(int i=0;i<tickets.size();i++)
    {
        if(!visit[i]&&tickets[i][0]==now) //미방문이고 방문가능하면
        {
            visit[i]=true;  //방문체크
            if(dfs(tickets[i][1],tickets,visit,answer,route,level+1))//다음 경로
            {
                return true;
            }
            visit[i]=false; //미방문처리
        }
    }
    route.pop_back();
    return false;
}
vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    vector<string> route;
    vector<bool> visit(tickets.size(),false);
    sort(tickets.begin(),tickets.end());
    answer=tickets[0];
    dfs("ICN",tickets,visit,answer,route,0);
    return answer;
}