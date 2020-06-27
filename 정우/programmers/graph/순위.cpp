#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;
int player[101][101];
set<int> relation[101];
bool visited[101];
int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    for(int i=0;i<results.size();i++){
        int winer = results[i][0], loser = results[i][1];
        player[winer][loser] = 1;
    }
    
    for(int z=1;z<=n;z++){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(player[i][z] == 1 && player[z][j] == 1) player[i][j] = 1;
            }
        }
    }
    
    for(int i=1;i<=n;i++){
        int cnt = 0;
        for(int j=1;j<=n;j++){
            if(player[i][j] != 0 || player[j][i] != 0) cnt++;
        }
        if(cnt == n-1) answer++;
    }

    return answer;
}
