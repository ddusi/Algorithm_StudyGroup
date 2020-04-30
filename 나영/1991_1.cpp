#include<iostream>
#include<cstdio>
#define MAX 27
using namespace std;
int tree[MAX][2];
int cnt;

void pre(int node){
	if(node ==-1) return;
	cout<<char(node+'A');
	pre(tree[node][0]);
	pre(tree[node][1]);
}
void mid(int node) {
	if(node ==-1) return;
	mid(tree[node][0]);
	cout<<char(node+'A');
	mid(tree[node][1]);	
}
void post(int node) {
	if(node ==-1) return;
	post(tree[node][0]);
	post(tree[node][1]);
	cout<<char(node+'A') ;
	
}
void input(){
	cin>>cnt;
	char root,left,right;

	for(int i=0;i<cnt;i++){
		cin>>root>>left>>right;
		tree[root-'A'][0] = left!='.'?left-'A':-1;
		tree[root-'A'][1] = right!='.'?right-'A':-1;
	}
	
}

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	
	input();
	pre(0);
	cout<<endl;
	mid(0);
	cout<<endl;
	post(0);
}
