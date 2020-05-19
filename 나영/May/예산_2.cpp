#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
#include<math.h>
#include<cstdio>
using namespace std;
typedef long long ll;
// ���� : �ѿ����� ������� 1.000.000.000 ���� -> ll
// 1. ����
// 2. ������ �� ��
//	1) ������ ���꺸�� �۰ų� ������ ����ū�� = ���Ѿ�
//	2) �̺�Ž��
//	-1.1 �߰� ������ �۰ų� ������  �ش� ���� ���� 
//		> ��? ��û�� �����ɼ� �־ ��û�ݾ� �״�� ���� 
//	  .2 �߰� ���� ���� ������ ������ ���� �����ؼ� ����
//	-2.1 ���� �߰� ���� ���� ���� ������ ���Ѱ����� ����
//	  .2 M < ���� : ���Ѱ�--
//	  .3 M > ���� : ���Ѱ�++ 
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
	// �� �����պ��� �� ���� ���� ���� ������� 
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
