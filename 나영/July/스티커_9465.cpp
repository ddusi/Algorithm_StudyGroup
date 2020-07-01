#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
#include<stdlib.h>
#include<set>
#define MAX 1000001
using namespace std;
int N;
int num[2][MAX];
int ans[2][MAX];
void func(){
	int cnt;
	cin>>cnt;
	for(int i=0;i<2;i++){
		for(int j=0;j<cnt;j++){
			int tmp;
			cin>>tmp;
			num[i][j]=tmp;
		}
	}
	for(int i=0;i<cnt;i++){
		if(i==0){
			ans[0][i]=num[0][0];
			ans[1][i]=num[1][0];
		} else if(i==1) {
			ans[0][i]=ans[1][i-1]+num[0][i];
			ans[1][i]=ans[0][i-1]+num[1][i];
		} else {
			int tmp = max(ans[0][i-2],ans[1][i-2]);\
			
			ans[0][i]=max(tmp, ans[1][i-1])+num[0][i];
			ans[1][i]=max(tmp, ans[0][i-1])+num[1][i];
		}
	}
	cout<<max(ans[0][cnt-1],ans[1][cnt-1])<<"\n";
	
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	cin>>N;
	for(int i=0;i<N;i++){
		func();
	}
}

