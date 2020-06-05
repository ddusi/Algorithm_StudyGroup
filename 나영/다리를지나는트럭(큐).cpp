#include <string>
#include <vector>
#include<queue>
using namespace std;

int solution(int bridge, int weight, vector<int> truck) {
    int answer = 0;
    queue<int> q;
    int sum=0;
    
    for(int i=0;i<truck.size();i++){
        int tmp = truck[i];
        while(1){
            if(q.size()<bridge){
                answer++;
                if(sum+tmp<=weight){
                    sum+=tmp;
                    q.push(tmp);
                    break;
                } else {
                    q.push(0);
                }
            } else if (q.size()==bridge) {
                sum-=q.front();
                q.pop();
            }  
        }        
    }
    answer+=bridge;
    return answer;
}
