#include <string>
#include <vector>
#include<string>
#include<algorithm>
#include<functional>
#include<iostream>
#include<cstdio>
// ���� : {0,0,0,0} > 0 �̾�� �ϴµ� ���� �Ǿ��� 0 �ϋ��� ���� ���������� 0000 �� ��ȯ 
using namespace std;
bool compare(string a, string b){
    return a+b>b+a;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> tmp;
    for(int i=0;i<numbers.size();i++){
        tmp.push_back(to_string(numbers[i]));
        cout<<tmp[i]<<"tmp"<<endl;
    }
    sort(tmp.begin(),tmp.end(), compare);
	for(int i=0;i<tmp.size();i++){
        answer+=tmp[i];
    }
    return answer;
}
int main(){
	vector<int> numbers{0, 0,0,0};
	string n= solution(numbers);
	cout<<n;
	
}
