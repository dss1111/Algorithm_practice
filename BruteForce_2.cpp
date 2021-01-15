#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
int IsPrimeNumber(int n)
{
    int i = 0;
    int last = n / 2; 
    if (n <= 1)
    {
        return 0;
    }
    for (i = 2; i <= last; i++) 
    {
        if ((n % i) == 0) 
        {
            return 0; 
        }
    }
    return 1;
}
int solution(string numbers) {
    vector <string> v;
    vector <int> res;
    int answer = 0;
    char ch[2];
    ch[1] = '\0';
    for (int i = 0;i < numbers.length();i++)
    {
        ch[0] = numbers.at(i);
        string a(ch);
        v.push_back(a);
    }
    for (int i = 0;i < v.size();i++)
    {
        if (IsPrimeNumber(stoi(v.at(i))))
        {
            if (find(res.begin(), res.end(), stoi(v.at(i))) == res.end())
            {
                res.push_back(stoi(v.at(i)));
                answer++;
            }
        }
    }
    sort(v.begin(),v.end());
    do{
        string r="";
        for (int i = 0; i < v.size();i++)
        {
            r += v.at(i);
        }
        if (IsPrimeNumber(stoi(r)))
        {
            if (find(res.begin(), res.end(), stoi(r)) == res.end())
            {
                res.push_back(stoi(r));
                answer++;
            }
        }
    }while (next_permutation(v.begin(), v.end()));
    return answer;
}
