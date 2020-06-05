#include <string>
#include <vector>
#include <deque>
using namespace std;

int solution(vector<int> pro, int location) {
   int answer = 1;
    deque<pair<int, int>> dq;
    for(int i=0; i<pro.size();i++){
        dq.push_back({pro[i],i});
    }
 	while(1){
	 	for(int i=0;i<dq.size();i++){
	    	int tmp = dq.front().first;
	    	int cnt = 0;
	    	for(int j = 1 ;j<dq.size();j++){
	    		int compare = dq.at(j).first;
	    		if(tmp<compare) {
	    			cnt = j;
	    			break;
				}
			}
			while (cnt > 0) {
				int first = dq.front().first;
	            int second = dq.front().second;
	            dq.pop_front();
	            dq.push_back({first, second});
	            cnt --;
			}
	    }
		if(dq.front().second == location) {
			break;
		} else {
			dq.pop_front();
			answer ++;
		}
	}

    return answer;
}
