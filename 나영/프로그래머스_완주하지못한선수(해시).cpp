#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> part, vector<string> com) {
    string answer = "";
    unordered_map<string, int> m;
    for(int i=0;i<part.size();i++){
        m[part[i]]++;
    }
    for(int i=0;i<com.size();i++){
        m[com[i]]--;
    }
    for(auto it=m.begin();it!=m.end();it++){
        if(it->second !=0) {
            answer=it->first;
            break;
        }
    }
    return answer;
}
