#include<queue>
#include<iostream>
#include<stdlib.h>
#include<cstdio>
#include<functional>
using namespace std;
int cnt;
int answer=1;
priority_queue<int, vector<int>, less<int>> pq;

void func() {
	int max = 0;
	while(!pq.empty()) {
		answer++;
		if(max<pq.top()+answer){
			max = answer + pq.top();
		}
		pq.pop();
	}
	answer=max;
}
int main(){
	cin>>cnt;
	for(int i=0;i<cnt;i++){
		int tmp;
		cin>>tmp;
		pq.push(tmp);
	}
	func();
	cout<<answer;
}
