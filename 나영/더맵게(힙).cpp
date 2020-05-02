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
	// q 사이즈가 1보다 커야함
	while(q.top()<K && q.size()>1){
		int sum=q.top();
		q.pop();
		sum=sum+(q.top()*2);
		q.pop();
		q.push(sum);
		answer++;
	}
    // 모든 음식으로 만들수 없는 경우에는 -1
    if(q.top()<K) return -1;
    return answer;
}
