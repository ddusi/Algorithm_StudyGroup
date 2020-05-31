#include <cstring>
#include <vector>
#include<algorithm>
#include<iostream>
#include<cstdio>
#include<string>
#include<set>
#define ll long long

//string 도 sort함수 쓸 수 있음 
// 아이디어
// check () : 소수 판별 함수
//     - while문으로 했을 떄 시간 초과 나옴
// 풀이과정
// 1. string 을 sort 
// 2. 소수여부 판단 배열을 통해 에라토스테네스 방식을 이용해 소수 판단
// 3. next_permutation 을 이용해 조합으로 소수 유무 검사 겹칠 수도 있으니 자료구조는 set으로
using namespace std;
bool check(ll num){
    if(num == 1) return false;
    if(num == 2) return true;
    // 루트 한 값 보다 작을때 나머지가 0인 경우 > 소수
    for(int i=2; i<=sqrt(num); i++) {
        if(num % i == 0) return false;
    }
    return true;
}

int solution(string num){
	string s=num;
    // string 글자 그대로 비교 해서 sort
	sort(s.begin(),s.end(),greater<char>());
    // 소수 판별을 위한 bool vector
	vector<bool> prime(stoi(s)+1);
	prime[0]=false;
	for(ll i=1;i<prime.size();i++){
        // 소수 인지 판별 1부터 최대 숫자까지~
		prime[i]=check(i);
	}
	sort(num.begin(),num.end());
    
    // set을 이용한 조합
	set<int> ans;
	do{
		for(int i=1;i<=num.size();i++){
			string tmp = num.substr(0,i);
			if(prime[stoi(tmp)]){
				ans.insert(stoi(tmp));
			}
		}
	}while(next_permutation(num.begin(),num.end()));

	return ans.size();
}
int main(){
	string numbers="17";
	int answer=solution(numbers);
	cout<<answer;
}
