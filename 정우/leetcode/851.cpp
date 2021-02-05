/*
[LeetCode] 851. Loud and Rich
https://leetcode.com/problems/loud-and-rich/

Input: 
richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
quiet = [3,2,5,4,6,1,7,0]

Output: 
[5,5,2,5,4,5,6,7]
*/

#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>
#define io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;

/*
먼저 입력받는 벡터값을 통해 단방향 그래프를 만든다. 
따라서 문제에서 나온 가난한 사람이 자신보다 부자인 사람들을 dfs돌면서 quiet를 비교해 가장 작은 값을 
현재 내위치 결과값에 계속 갱신한다. 
quiet를 비교할 때는 dfs로 그래프 끝까지 탐색하기 때문에 가장 작은 quiet값을 한번에 찾아서 재사용 할수 있다.
*/

class Solution {
public:
    vector<int> ans;
    vector<int> path[501];
    int dfs(int idx, vector<int>& quiet) {
        if(ans[idx] >= 0) return ans[idx];
        ans[idx] = idx;
        for(auto it : path[idx]) {
            if(quiet[ans[idx]] > quiet[dfs(it, quiet)])
                ans[idx] = ans[it];
        }
        return ans[idx];
    }
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        for(int i=0;i<richer.size();i++) {
            path[richer[i][1]].push_back(richer[i][0]);
        }
        ans.resize(quiet.size(), -1);
        for(int i=0;i<quiet.size();i++) {
            ans[i] = dfs(i, quiet);
        }

        return ans;
    }
};

int main()
{
    io;
    //Solution solution = Solution();
    //vector<int> result = solution.loudAndRich();

    return 0;
}
