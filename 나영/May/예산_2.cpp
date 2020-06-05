#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
#include<math.h>
#include<cstdio>
using namespace std;
typedef long long ll;
// 주의 : 총예산의 지방수는 1.000.000.000 이하 -> ll
// 1. 소팅
// 2. 버짓의 총 합
//	1) 총합이 예산보다 작거나 같으면 가장큰수 = 상한액
//	2) 이분탐색
//	-1.1 중간 값보다 작거나 같으면  해당 예산 더함 
//		> 왜? 요청이 배정될수 있어서 요청금액 그대로 배정 
//	  .2 중간 값을 상한 값으로 나머지 값들 가정해서 더함
//	-2.1 만약 중간 값과 예상 값이 같으면 상한값으로 지정
//	  .2 M < 총합 : 상한값--
//	  .3 M > 총합 : 상한값++ 
int solution(vector<int> budgets,  int M) 
	int min =1;
	int max = 100000;
	int sum = 0;
	int mid;
	int answer=0;
	int tmp =0;
	sort(budgets.begin(), budgets.end());
	for(auto i:budgets){
		sum+=i;
	}
	// 총 예산합보다 각 지역 예산 합이 작은경우 
	if(sum<=M) return budgets[budgets.size()-1];
	while(1){
		sum =0;
		mid=(max+min)/2;
		for(int i=0;i<budgets.size();i++){
			if(budgets[i]<=mid){
				sum+=budgets[i];
			} else {
				sum+=mid*(budgets.size()-i);
				break;
			}
		}
		if(mid==tmp) return mid;
		else if(sum>M) max=mid-1;
		else min=mid+1;
		tmp = mid;
	}
	
	return answer;
}
int main(){
	vector<int> budgets{120,110,140,150};
	int M = 485;
	int answer;
	answer=solution(budgets,M);
	cout<<answer;
}
