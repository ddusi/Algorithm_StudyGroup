#include<string>
#include<vector>
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;
typedef long long ll;
// 한심사대에 한명
// 가장 맨앞에 서있는 사람은 비어있는 심사대로 가서 받을 수있다
// 특정 시간을 두고 이 시간안에 가능한지
// 주의사항
// 1. 가장 작은 수를 찾아야함
// 2. max 구할때 자료형 long long
//    but) items, n 자료형 long long > 자료형을 맞춰야함 
ll solution(int n, vector<int> items){
	ll min=1;
	ll mid;
	ll max=*max_element(items.begin(),items.end())*(ll)n;
	ll answer= 0;
	while(min<=max){
		ll sum =0;
		mid=(max+min)/2;
		for(int i=0;i<items.size();i++){
			sum+=mid/items[i];
		}
		if(n<=sum) {
			max=mid-1;
			answer=mid;
		}else {
			min=mid+1;
		}
	}
	return answer;
}
int main(){
	int n =1;
	vector<int> items{5,5};
	int answer=solution(n, items);
	cout<<answer;
}
