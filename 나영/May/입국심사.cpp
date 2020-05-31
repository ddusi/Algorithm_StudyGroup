#include<string>
#include<vector>
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;
typedef long long ll;
// �ѽɻ�뿡 �Ѹ�
// ���� �Ǿտ� ���ִ� ����� ����ִ� �ɻ��� ���� ���� ���ִ�
// Ư�� �ð��� �ΰ� �� �ð��ȿ� ��������
// ���ǻ���
// 1. ���� ���� ���� ã�ƾ���
// 2. max ���Ҷ� �ڷ��� long long
//    but) items, n �ڷ��� long long > �ڷ����� ������� 
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
