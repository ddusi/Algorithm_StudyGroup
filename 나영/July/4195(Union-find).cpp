#include<cstdio>
#include<map>
#include<iostream>
#include<algorithm>
#include<cstring>
#define MAX 10001
using namespace std;

int parent[MAX];
int rankSize[MAX];
int F;
int find(int u) {
	if(u==parent[u]) return u;
	return parent[u]=find(parent[u]);
}
void merge(int u, int v) {
	u=find(u);
	v=find(v);
	
	if(v==u) return;
	if(rankSize[u]<rankSize[v]) swap(u,v);
	parent[v]=u;	
	rankSize[u] += rankSize[v];
}

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int test;
	cin>>test;
	for(int i=0;i<test;i++){
		cin>>F;
		for(int j=0;j<MAX;j++){
			parent[j]=j;
			rankSize[j]=1;
		}
		map<string, int> person;
		int idx=1;
		
		for(int j=0;j<F;j++){
			string str1,str2;
			cin>>str1>>str2;
			if(person.count(str1) == 0) 
				person[str1] = idx++;
			if(person.count(str2) == 0) 
				person[str2]=idx++;
			
			int tmpA = find(person[str1]);
			int tmpB = find(person[str2]);
			
			if(tmpA==tmpB) {
				cout<<max(rankSize[tmpA], rankSize[tmpB])<<"\n";
			} else {
				merge(tmpA, tmpB);
				cout<<max(rankSize[tmpA], rankSize[tmpB])<<"\n";
			}
			
		}
	}
	return 0;
}


