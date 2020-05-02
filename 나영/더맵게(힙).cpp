#include <string>
#include <vector>
#include<queue>
#include<functional>
using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> q;
    int answer = 0;
    for(int i=0;i<scoville.size();i++){
    	q.push(scoville[i]);
	}
	// q ����� 1���� Ŀ����
	while(q.top()<K && q.size()>1){
		int sum=q.top();
		q.pop();
		sum=sum+(q.top()*2);
		q.pop();
		q.push(sum);
		answer++;
	}
    // ��� �������� ����� ���� ��쿡�� -1
    if(q.top()<K) return -1;
    return answer;
}
