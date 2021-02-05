/*
[LeetCode] 752. Open the Lock
https://leetcode.com/problems/open-the-lock/
*/

#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <unordered_set>
#define io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;

/*
0000부터 bfs를 돌려서 target에 도착하면 끝.
다만 문자열 값을 탐색하기 때문에 구현이 생각보다 어려움.
*/

unordered_set<string> trap, path;

class Solution {
public:
    unordered_set<string> trap, path;
    const int INF = 987654321;
    int ans = INF;
    int move[2] = {1, -1};
    string endpoint;
    void bfs() {
        queue<pair<string, int> > q;
        q.push(make_pair("0000", 0));
        while(!q.empty()){
            string tmp = q.front().first;
            int cnt = q.front().second;
            q.pop();
            if(trap.find(tmp) != trap.end()) continue;
            if(endpoint.compare(tmp) == 0){
                ans = cnt;
                break;
            }

            for(int i=0;i<2;i++){
                for(int j=0;j<4;j++){
                    string buf = tmp;
                    if(move[i] > 0) buf[j] = buf[j] + 1 > '9' ? '0' : buf[j] + 1;
                    else buf[j] = buf[j] - 1 < '0' ? '9' : buf[j] - 1;
                    if(path.find(buf) != path.end()) continue;
                    path.insert(buf);
                    q.push(make_pair(buf, cnt+1));
                }
            }
        }
    }

    int openLock(vector<string>& deadends, string target) {
        endpoint = target;
        for(int i=0;i<deadends.size();i++)
            trap.insert(deadends[i]);
        bfs();
        if(ans == INF) 
            return -1;
        return ans;
    }
};

vector<string> ex_deadends;
string ex_target = "0202";

int main()
{
    io;

    ex_deadends.push_back("0201");
    ex_deadends.push_back("0101");
    ex_deadends.push_back("0102");
    ex_deadends.push_back("1212");
    ex_deadends.push_back("2002");

    Solution solution = Solution();
    cout<<"ans: "<<solution.openLock(ex_deadends, ex_target)<<"\n";

    return 0;
}
