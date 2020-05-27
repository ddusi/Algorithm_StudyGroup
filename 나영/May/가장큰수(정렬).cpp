#include <string>
#include <vector>
#include<string>
#include<algorithm>
#include<functional>
#include<iostream>
#include<cstdio>
// 참고 : {0,0,0,0} > 0 이어야 하는데 만약 맨앞이 0 일떄를 생각 하지않으면 0000 을 반환 
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
