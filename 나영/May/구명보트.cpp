#include <string>
#include <vector>
#include<algorithm>
#include<functional>
#include<iostream>
#include<cstdio>
using namespace std;
// 최대 두명 무게 제한 있음

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());

    int left = 0;
    int right = people.size()-1;
    while(left<=right){
    	if(people[left]+people[right]<=limit){
    		left++;
		}
		right--;
		answer++;
    	
	}
    return answer;
}
int main(){
	vector<int> people{20,70,80,30};
	int limit = 100;
	int answer = solution(people,limit);
	cout<<answer;
	
}

