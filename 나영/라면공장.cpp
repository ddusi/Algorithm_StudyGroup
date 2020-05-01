#include <string>
#include <vector>
#include<queue>
#include<functional>
using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    priority_queue<int, vector<int>, less<int>> pq;
    int idx=0;

    // i= ½Ã°£
    for(int i=0;i<k;i++){
        if(dates[idx]==i && idx<dates.size()){
            pq.push(supplies[idx]);
            idx++;
        }
        if(stock==0) {
            stock+=pq.top();
            pq.pop();
            answer++;
        }
        stock--;
    }
    return answer;
}
