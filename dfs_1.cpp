#include <string>
#include <vector>

using namespace std;
int answer = 0;
void dfs(vector<int> numbers,int target, int sum, int level)
{
    if(level==numbers.size())
    {
        if(target==sum)
        {
            answer++;
        }
        return;
    }
    dfs(numbers,target,sum+numbers[level],level+1);
    dfs(numbers,target,sum-numbers[level],level+1);
}
int solution(vector<int> numbers, int target) {
    dfs(numbers,target,0,0);
    return answer;
}
