#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
#include<cstdio>
using namespace std;
int p1[5]={1,2,3,4,5};
int p2[8]={2,1,2,3,2,4,2,5};
int p3[10]={3,3,1,1,2,2,4,4,5,5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int num[3]={0,};
    for(int i=0;i<answers.size();i++){
  		int tmp = answers[i];
        if(p1[i%5]==tmp) num[0]++;
        if(p2[i%8]==tmp) num[1]++;
        if(p3[i%10]==tmp) num[2]++;
	}
    int max = *max_element(num,num+3);
    for(int i=0;i<3;i++){
        if(max==num[i]){
            answer.push_back(i+1);
        }
    }
    return answer;
}
int main(){
	vector<int> answer{1,2,3,4,5};
	vector<int> ans=solution(answer);
	cout<<ans[1]<<endl;
	
}
