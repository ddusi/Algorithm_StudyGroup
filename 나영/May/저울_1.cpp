#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> weight) {
    int answer = 1;
    sort(weight.begin(), weight.end());
    for(int i=0;i<weight.size();i++){
        if(weight[i]>answer) break;
        answer+=weight[i];
    }
    return answer;
}
int main(){
	vector<int> w{3,1,6,2,30,1};
	int answer = solution(w);
} 
