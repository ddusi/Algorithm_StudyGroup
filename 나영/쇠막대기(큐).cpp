#include <string>
#include <vector>
#include<queue>
using namespace std;

int solution(string str) {
    int answer = 0;
	queue<int> q;
	for(int i=0;i<str.length();i++){
		if(str[i]=='(') {
			q.push(0);
		}	
		else {
			q.pop();
			if(str[i-1]=='(') answer +=q.size();
			else answer++; //�������� )��� ���� �踷����� ��
		}
	}
    return answer;
}
