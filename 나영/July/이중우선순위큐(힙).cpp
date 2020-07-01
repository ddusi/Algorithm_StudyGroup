#include <string>
#include <vector>
#include<queue>
#include<string>
#include<iostream>
#include<cstdio>
#include<functional>
#include<deque>
#include<algorithm>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    deque<int> dq;
    for(int i=0;i<operations.size();i++){
    	string s=operations.at(i);
    	int num = stoi(s.substr(2, s.length()-2));
    	
    	if(s[0]=='I'){
    		dq.push_back(num);
    		sort(dq.begin(),dq.end());
		} else if(!dq.empty()) {
              if (num==1){
                dq.pop_back();
                } else if (num == -1){
                dq.pop_front();
            }
        }
	}
	if(dq.empty()){
		answer.push_back(0);
		answer.push_back(0);
	} else {
		answer.push_back(dq.back());
		answer.push_back(dq.front());
	}
    return answer;
}

int main(){
	vector<string> operations{"I 7","I 5","I -5","D -1";
    //vector<string> operations{"1 16", "D 1"};
	vector<int> ans = solution(operations);
	cout<<ans[1]<<ans[0]<<endl;
}

