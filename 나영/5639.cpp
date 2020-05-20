#include<queue>
#include<stdlib.h>
#include<iostream>
#include<vector>
#define MAX 100001
using namespace std;
vector<int> v;
void post(int left, int right){
	if(left==right) return;
	if(left==right-1){
		cout<<v[left]<<endl;
		return;
	}
	int idx=left+1;
	while(1){
		if(idx>=right || v[idx]>v[left]) break;
		idx++;
	}
	post(left+1, idx);
	post(idx,right);
	cout<<v[left]<<endl;
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	int tmp;
	while(cin>>tmp){
		v.push_back(tmp);
	}
	post(0,v.size());
}
