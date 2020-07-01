#include<cstdio>
#include<queue>
#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;
// 아무작업도 하고있지 않는 경우 먼저 들어온 요청 부터 작업 수행
// idea 
// 1. 실행순으로 입력값을 sort한다 만약 시작 시간이 같으면 진행시간이 더 짧은걸루
// 2. 우선순위 큐 조건에서 실행시간이 짧은 것 먼저 pop
// 
bool jobscompare(vector<int> a, vector<int> b){
	if(a[0]==b[0]){
		return a[1]<b[1];
	}else {
		return a[0]<b[0];
	}
}
struct compare{
	bool operator()(vector<int> a, vector<int> b){
		return a[1]>b[1];
	}
};
int solution(vector<vector<int>> jobs){
	int answer=0;
	int time=0; // 현재 시간
	int idx =0; // 작업 관련 index
	
	sort(jobs.begin(), jobs.end(), jobscompare); 
	priority_queue<vector<int>, vector<vector<int>>, compare> pq;
	while(idx<jobs.size()||!pq.empty()){
		if(idx<jobs.size()&&time>=jobs[idx][0]){
			pq.push(jobs[idx]);
			idx++;
			continue;
		}
		if(!pq.empty()){
			vector<int> tmp = pq.top();
			time+=tmp[1];
			answer+=time-tmp[0];
			pq.pop();
		} else {
			// pq가 비어있으면서 다음 값이 있는데 엄청 멀리 있는경우 time을 멀리있는 작업의 시작시간으로 설정 
            time=jobs[idx][0];
		}
	}
	return answer/jobs.size();
} 
int main(){
	vector<vector<int>> jobs{{0,3},{1,9},{2,6}};
	int ans = solution(jobs);
	cout<<ans;
}
