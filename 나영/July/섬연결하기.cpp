#include <string>
#include <vector>
#include<cstdio>
#include<algorithm>
#include<iostream>
#define MAX 101
using namespace std;
int parent[MAX];
int find(int n){
	if(n==parent[n]) return n;
	return parent[n]= find(parent[n]);
}
bool compare (vector<int> a, vector<int> b){
	return a[2]<b[2];
}
int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    for(int i=0;i<n;i++){
    	parent[i]=i;
	}
	sort(costs.begin(), costs.end(), compare);
	
	for(int i=0;i<costs.size();i++){
		int v=find(costs[i][0]);
		int u = find(costs[i][1]);
		int cost = costs[i][2];
		
		if(v!=u){
			parent[u]=v;
			answer+=cost;
		}
	}
	
	
    return answer;
}
int main(){
	int n=4;
	vector<vector<int>> c{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
	int ans = solution(n, c);
	cout<<ans;
}
