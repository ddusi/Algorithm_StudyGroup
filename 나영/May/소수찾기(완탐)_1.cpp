#include <cstring>
#include <vector>
#include<algorithm>
#include<iostream>
#include<cstdio>
#include<string>
#include<set>
#define ll long long

//string �� sort�Լ� �� �� ���� 
// ���̵��
// check () : �Ҽ� �Ǻ� �Լ�
//     - while������ ���� �� �ð� �ʰ� ����
// Ǯ�̰���
// 1. string �� sort 
// 2. �Ҽ����� �Ǵ� �迭�� ���� �����佺�׳׽� ����� �̿��� �Ҽ� �Ǵ�
// 3. next_permutation �� �̿��� �������� �Ҽ� ���� �˻� ��ĥ ���� ������ �ڷᱸ���� set����
using namespace std;
bool check(ll num){
    if(num == 1) return false;
    if(num == 2) return true;
    // ��Ʈ �� �� ���� ������ �������� 0�� ��� > �Ҽ�
    for(int i=2; i<=sqrt(num); i++) {
        if(num % i == 0) return false;
    }
    return true;
}

int solution(string num){
	string s=num;
    // string ���� �״�� �� �ؼ� sort
	sort(s.begin(),s.end(),greater<char>());
    // �Ҽ� �Ǻ��� ���� bool vector
	vector<bool> prime(stoi(s)+1);
	prime[0]=false;
	for(ll i=1;i<prime.size();i++){
        // �Ҽ� ���� �Ǻ� 1���� �ִ� ���ڱ���~
		prime[i]=check(i);
	}
	sort(num.begin(),num.end());
    
    // set�� �̿��� ����
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
