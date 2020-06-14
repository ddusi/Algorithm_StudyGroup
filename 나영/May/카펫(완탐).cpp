#include <string>
#include <vector>
#include<cstdio>
#include<math.h>
#include<iostream>
using namespace std;
// 가로>=세로
vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int x=0; int y=0; //x=가로, y=세로
    y = sqrt(yellow);
    while(y>0){
        if(yellow%y==0) {
            x=yellow/y;
            if((x+y)*2+4==brown) break;
        }
        y--;
    }
    answer.push_back(x+2);
    answer.push_back(y+2);
    return answer;
}
int main(){
	vecotr<int> ans = solution(10,2);
	for(auto i: ans){
		cout<<i<<endl;
	}
}
