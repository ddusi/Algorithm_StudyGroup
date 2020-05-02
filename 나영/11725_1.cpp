#include<vector>
#include<iostream>
#include<cstdio>
#include<deque>
#define MAX 100001

using namespace std;
vector<int> v[MAX];
int cnt;
int ans[MAX];
bool visit[MAX];
void check(int idx) {
	visit[idx]=true;
	for(int i=0;i<v[idx].size();i++){
		if(!visit[v[idx][i]]){
			ans[v[idx][i]]=idx;
			check(v[idx][i]);
		}
	}
	return;
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	cin>>cnt;
	for(int i=0;i<cnt-1;i++){
		int a,b;
		cin>>a>>b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	check(1);
	
	for(int i=2;i<=cnt;i++){
		cout<<ans[i]<<endl;
	}
	
}
