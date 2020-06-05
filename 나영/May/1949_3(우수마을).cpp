#include<vector>
#include<cstdio>
#include<functional>
#include<queue>
#include<algorithm>
#include<iostream>
#include<string.h>
#include<math.h>
#include<map>
#define MAX 10001
using namespace std;
// 우수선정 마을 주민수의 합은 최대
// 두 마을은 인접, 우수마을 끼리는 인접 불가
// 선정 못한 마을에 경각심을 불러일으키기 위해 우수마을로 선정되지 못한 마을은 적어도 하나의 우수마을과 인접해야함 
int answer;
int village[MAX],dp[MAX][2];
bool visit[MAX];
int cnt;
vector<int> near[MAX];
int func(int idx,bool flag){
	int &sum = dp[idx][flag];
    if(sum != -1) return sum;
    sum = 0;
	visit[idx]=true;
	for(int i=0;i<near[idx].size();i++){
		int tmpV = near[idx][i];
		if(visit[tmpV]) continue;
		//현재 마을이 우수 마을인 경우 
		if(flag) {
			sum+=func(tmpV,0);
		} else {
			// 마을을 방문 한거랑 안한거랑 비교 
			sum += max(func(tmpV,0), func(tmpV,1)+village[tmpV]);
		}
	}
	visit[idx]=false;
	return sum;
}
void input(){
	cin>>cnt;
	for(int i=1;i<=cnt;i++){
		cin>>village[i];
	}
	for(int i=0;i<cnt-1;i++){
		int a,b;
		cin>>a>>b;
		near[a].push_back(b);
		near[b].push_back(a);
	}
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	input();
	memset(dp,-1,sizeof(dp));
	answer = max(func(1,0),func(1,1)+village[1]);

	cout<<answer;
}
