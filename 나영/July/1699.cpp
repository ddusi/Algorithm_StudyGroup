#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
#define MAX 1000001
using namespace std;
int N;
int num[MAX];
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin>>N;
	for(int i=1;i<=N;i++){
		num[i]=i;
	}
	for(int i=1;i<=N;i++){
		for(int j=1;j*j<=i;j++){	
			if(num[i]>num[i-j*j]+1){
				num[i]=num[i-j*j]+1;
			}
		}
	}
	cout<<num[N];
}

