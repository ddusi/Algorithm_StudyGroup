#include <string>
#include <vector>
#include<iostream>
#include<cstdio>
using namespace std;
int stu[31];
// �������� ������ �� �л��� ���� ���� �� �ִ�, �̶��� ���� ü������ �ϳ��̱⿡ �ٸ��̿��� ü���� ������ ��
// ������ �ִ� �л��� ������ �����ټ� �ִ�
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
