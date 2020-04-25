#include<iostream>
#include<stdio.h>
#include<queue>
#include<string>
#include<unordered_map>
#include<vector>
#include<stack>
using namespace std;
int a,b; 
int answer=0;
stack<int> s[7];
void func(int p, int q){
	// s[p]가 비어있지 않고  맨위에 수가 q보다 클경우
	// 하나씩빼면서 q보다 작거나 같을때 까지 반복  
	while(!s[p].empty() && s[p].top()>q){
		s[p].pop();
		answer++;
	}
	// S[P]가 비어있거나 맨위에 수가 q보다 작을 경우 넣을수 있음
	// s[p]의 맨위의 수가 q랑 같을 경우에는 무 
	if(s[p].empty() || s[p].top()<q) {
		s[p].push(q);
		answer++;	
	}
}
void input(){	
	cin>>a>>b;
	for(int i=0;i<a;i++){
		int p, q;
		cin>>p>>q;
		func(p,q);		
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	input();
	cout<<answer<<endl;
}
