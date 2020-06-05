#include<iostream>
#include<cstdio>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;
int solution(vector<int> citations){
	int answer=0;
	sort(citations.begin(), citations.end(), greater<int>());
	for(int i=0;i<citations.size();i++){
		if(citations[i]>answer){
			answer++;
		} else {
			break;
		}
	}
	return answer;
}
int main(){
	vector<int> citations{3,0,6,1,5};
	int answer= solution(citations);
	cout<<answer<<"\n";
}
