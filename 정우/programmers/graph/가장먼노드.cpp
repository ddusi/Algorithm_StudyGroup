#include <string>
#include <vector>
#include <queue>
#include <map>
#include <iostream>
using namespace std;
vector<int> graph[20001];
bool visited[20001];
map<int, int> m;
int max_cnt = 0;
void bfs(int cur){
    queue<pair<int, int>> q;
    q.push({cur, 0});
    visited[cur] = true;
    while(!q.empty()){
        int here = q.front().first, cnt = q.front().second;
        q.pop();
        
        if(m.find(cnt) == m.end()) 
            m.insert({cnt, 1});
        else 
            m.find(cnt)->second++;
        
        if(cnt > max_cnt){
            max_cnt = cnt;
        }
        
        for(auto it : graph[here]){
            int next = it;
            if(visited[next]) continue;
            visited[next] = true;
            q.push({next, cnt+1});
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    for(int i=0;i<edge.size();i++){
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
    bfs(1);
    answer = m.find(max_cnt)->second;
    return answer;
}
