#include<iostream>
#include<cstdio>
#include<vector>
#include<math.h>
#include<algorithm>
#include<unordered_set>
#define MAX 8
using namespace std;
int solution(int N,int number){
	int answer=EOF;
	int tmp=0;
	unordered_set<int> num[MAX];
	// 자료형 set으로 배열을 만든다 
	// 2, 22, 222, 2222 .... 
	for(int i=0;i<MAX;i++){
		tmp=10*tmp+1;
		num[i].insert(tmp*N);
	
	}
	// 2 갯수 
	for(int i=1;i<MAX;i++){
		// 이전의 SET배열이랑 비교 
		for(int j=0;j<i;j++){
			// SET의 원소를 하나씩뺴옴 
			for(auto a:num[j]){
				// 계산한 TARGET SET의 원소들 하나씩 빼옴 
				for(auto b:num[i-j-1]){
					 // ex ) SET[0] 즉 2인원소들을 하나씩 꺼내와서 set[1]에 이전 원소인 22는 들어가있고 set[0]의 원소인 2로 만들수 있는경우의 수를 set[1]로 넣음   
					num[i].insert(a+b);
					num[i].insert(a-b);
					num[i].insert(a*b);
					if(b!=0) {
						num[i].insert(a/b);
					}
				}
			}
		}	
		// 자료형 set 에서 count 함수 number의 갯수를 반환 
		// num[0]부터 시작해서 +1해야함 
		if(num[i].count(number)>0){
			answer=i+1;
			break;
		}
	}
	return answer;
}
int main(){
	int N=2;
	int number=11;
	int answer=solution(N,number);
	cout<<answer<<"\n";
	
}
