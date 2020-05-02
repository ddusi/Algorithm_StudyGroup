#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for(int i=0;i<prices.size();i++){
    	int chk = 0;
    	for(int j=i+1;j<prices.size();j++){
    		chk++;
    		 if(prices[j]<prices[i]) {
    		 	break;
			 }
		}
		answer.push_back(chk);
	} 
    return answer;
}
