#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
vector <int> h;
int answer = 0;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
void getValue(string now, string target, vector<string>words, int level)
{
    level++;
    if (now == target)
    {
        answer = level;
    }
    else
    {
        int i, j, dif;
        bool check = false;
        for (i = 0;i < words.size();i++)
        {
            if (words[i] == "")
                continue;
            dif = 0;
            for (j = 0;j < now.length();j++)
            {
                if (words[i][j] != now[j])
                    dif++;
            }
            if (dif == 1)
                check = true;
            pq.push(make_pair(h[i] + dif * 2, i));
        }
        if (check == false)
        {
            answer = 0;
            return;
        }
        string next = words[pq.top().second];
        words.at(pq.top().second) = "";
        pq.pop();
        getValue(next, target, words, level);
    }
}
int solution(string begin, string target, vector<string> words) {
    int i, j;
    int score;
    int level = -1;
    for (i = 0;i < words.size();i++)
    {
        score = 0;
        for (j = 0;j < target.length();j++)
        {
            if (words[i][j] != target[j])
                score++;
        }
        h.push_back(score);
    }
    if (find(h.begin(), h.end(), 0) == h.end())
        return 0;
    getValue(begin, target, words, level);
    return answer;
}