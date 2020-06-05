#include <string>
#include <vector>

using namespace std;

bool solution(vector<string> phone) {
    bool answer = true;
    for(int i=0;i<phone.size();i++){
        for(int j=0;j<phone.size();j++){
            string a = phone[i];
            string b = phone[j];
            if(i==j || a.size()>b.size()) continue;
            
            // 문자열 자르기
            string tmp = b.substr(0,a.size());
            if(a.compare(tmp)==0) {
                answer=false;
                return answer;
            }
        }
    }
    
    return answer;
}
