/*
[LeetCode] 386. Lexicographical Numbers
https://leetcode.com/problems/lexicographical-numbers/
*/

#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>
#define io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;

/*
N까지의 순차적인 수를 사전순으로 만들기 위해 맵 자료구조에 <문자형, 실제 숫자> 헝식으로 데이터를 저장한다.
맵은 키값 기준으로 정렬되기 때문에 현재 키값인 문자형으로 사전순 정렬이 된다.
이후 키에 매칭된 값만 정답 벡터에 담아서 반환한다.
++ 더 빠른 처리방법은 정렬없이 dfs를 하면서 1, 10, 100, 12, 을 먼저 탐색하도록 구현하면 된다.
*/

class Solution {
public:
    map<string, int> m;
    vector<int> lexicalOrder(int n) {
        vector<int> ans;
        for(int i=1;i<=n;i++) {
            m.insert(make_pair(to_string(i), i));
        }
        for(auto it : m){
            ans.push_back(it.second);
        }
        return ans;
    }
};

int main()
{
    io;
    int n;
    cin>>n;
    Solution solution = Solution();
    vector<int> result = solution.lexicalOrder(n);

    return 0;
}
