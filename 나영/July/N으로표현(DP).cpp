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
	// �ڷ��� set���� �迭�� ����� 
	// 2, 22, 222, 2222 .... 
	for(int i=0;i<MAX;i++){
		tmp=10*tmp+1;
		num[i].insert(tmp*N);
	
	}
	// 2 ���� 
	for(int i=1;i<MAX;i++){
		// ������ SET�迭�̶� �� 
		for(int j=0;j<i;j++){
			// SET�� ���Ҹ� �ϳ������� 
			for(auto a:num[j]){
				// ����� TARGET SET�� ���ҵ� �ϳ��� ���� 
				for(auto b:num[i-j-1]){
					 // ex ) SET[0] �� 2�ο��ҵ��� �ϳ��� �����ͼ� set[1]�� ���� ������ 22�� ���ְ� set[0]�� ������ 2�� ����� �ִ°���� ���� set[1]�� ����   
					num[i].insert(a+b);
					num[i].insert(a-b);
					num[i].insert(a*b);
					if(b!=0) {
						num[i].insert(a/b);
					}
				}
			}
		}	
		// �ڷ��� set ���� count �Լ� number�� ������ ��ȯ 
		// num[0]���� �����ؼ� +1�ؾ��� 
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
