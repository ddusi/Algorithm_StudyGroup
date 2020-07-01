#include<cstdio>
#include<queue>
#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;
// �ƹ��۾��� �ϰ����� �ʴ� ��� ���� ���� ��û ���� �۾� ����
// idea 
// 1. ��������� �Է°��� sort�Ѵ� ���� ���� �ð��� ������ ����ð��� �� ª���ɷ�
// 2. �켱���� ť ���ǿ��� ����ð��� ª�� �� ���� pop
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
	int time=0; // ���� �ð�
	int idx =0; // �۾� ���� index
	
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
			// pq�� ��������鼭 ���� ���� �ִµ� ��û �ָ� �ִ°�� time�� �ָ��ִ� �۾��� ���۽ð����� ���� 
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
