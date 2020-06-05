#include <string>
#include <vector>
#include<iostream>
#include<cstdio>
using namespace std;
int stu[31];
// 여벌옷을 가지고 온 학생도 도난 당할 수 있다, 이때는 남은 체육복이 하나이기에 다른이에게 체육복 빌릴수 없
// 여벌이 있는 학생만 남에게 빌려줄수 있다
int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer=0;
	for(int i=0;i<reserve.size();i++){
		stu[reserve[i]]+=1;
	}
    for(int i=0;i<lost.size();i++){
        stu[lost[i]]-=1;
    }
    for(int i=1;i<=n;i++){
        if(stu[i]==-1){
            if(stu[i-1]==1){
                stu[i]=stu[i-1]=0;
            } else if(stu[i+1]==1){
                stu[i]=stu[i+1]=0;
            } else {
                answer++;
            }
        }
    }
    return n-answer;
}
