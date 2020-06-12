#include <string>
#include <vector>
#include<iostream>
#include<cstdio>
#define MAX 101
#define long long ll
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {

    bool water[MAX][MAX]={true,};
    for(int i=0;i<puddles.size();i++){
    	water[puddles[i][0]][puddles[i][1]]=true;
	}
	int num[MAX][MAX]={0,};
	num[1][0]=1;
	for(int i=1;i<=m;i++){
		for(int j=1;j<=n;j++){
			if(water[i][j]) {
				num[i][j]=0;
			}
			else {
				num[i][j]=(num[i][j-1]+num[i-1][j])%1000000007;				
			}
		}
	}
	
    return num[m][n];
}
int main(){
	int m=4;
	int n=3;
	vector<vector<int>> puddles{{2,2}};
	int ans=solution(m,n,puddles);
	cout<<ans<<"\n";
}

