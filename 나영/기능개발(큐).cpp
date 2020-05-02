#include <string>
#include <vector>
#include<queue>
#include<math.h>
#include<iostream>
#include<stdio.h>
using namespace std;

vector<int> solution(vector<int> pro, vector<int> spd) {
    vector<int> answer;
    queue<int> q;
    for(int i=0;i<pro.size();i++){
        q.push(ceil((100-pro[i])/spd[i]));
    }
    while(!q.empty()){
        int cnt=1;
        int tmp=q.front();
        q.pop();
        while(1){
        	if(q.front()>tmp || q.empty()) break;
			q.pop();
			cnt++;
        }
        answer.push_back(cnt);
    }
    return answer;
}
