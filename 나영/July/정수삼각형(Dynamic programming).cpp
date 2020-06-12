#include <string>
#include <vector>
#include <queue>
#include<iostream>
#include<cstdio>
#include<algorithm>
#define MAX 501
using namespace std;
int solution(vector<vector<int>> triangle) {
    int answer = 0;
    int num[MAX][MAX]={0,};
    int s = triangle.size();
    for(int i=0;i<s;i++){
    	for(int j=0;j<triangle[i].size();j++){
    		if(j==0) {
    			num[i][j]=triangle[i][j]+num[i-1][0];
			} else if(j==triangle[i].size()-1){
				num[i][j]=triangle[i][j]+num[i-1][j-1];
			}else {
				int tmpA=num[i-1][j]+triangle[i][j];
				int tmpB=num[i-1][j-1]+triangle[i][j];
				num[i][j]=tmpA>tmpB?tmpA:tmpB;
		
			}
		}
	}
	for(int i=0;i<s;i++){
		answer=answer>num[s-1][i]?answer:num[s-1][i];
	}
    return answer;
}
int main(){
	vector<vector<int>> v = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
	int ans = solution(v);
	cout<<ans<<endl;
}
