#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> m;
    for(int i=0;i<clothes.size();i++){
    	vector<string> tmp = clothes[i];
    	m[tmp[1]]++;
    }
    for(auto it=m.begin();it!=m.end();it++){
        answer*=(it->second+1);

    }
    return answer-1;
}
