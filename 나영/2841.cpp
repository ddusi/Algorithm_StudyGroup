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
	// s[p]�� ������� �ʰ�  ������ ���� q���� Ŭ���
	// �ϳ������鼭 q���� �۰ų� ������ ���� �ݺ�  
	while(!s[p].empty() && s[p].top()>q){
		s[p].pop();
		answer++;
	}
	// S[P]�� ����ְų� ������ ���� q���� ���� ��� ������ ����
	// s[p]�� ������ ���� q�� ���� ��쿡�� �� 
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
