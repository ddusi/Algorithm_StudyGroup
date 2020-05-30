#include<iostream>
#include<vector>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;
//* 숫자는 맞지만, 위치가 틀렸을 때는 볼
//* 숫자와 위치가 모두 맞을 때는 스트라이크
//* 숫자와 위치가 모두 틀렸을 때는 아웃
int answer = 0;

bool check(string guess, vector<vector<int>> game){
	for(int k=0;k<game.size();k++){
		int num = game[k][0];
		int a=0;
		int b=0;
		string target=to_string(num);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(i==j &&target[i]==guess[i]){
					a++;
					continue;
				}
				if(i!=j &&target[j]==guess[i]) {
					b++;
					continue;
				}
			}
		}
		if(a!=game[k][1]||b!=game[k][2]) return false;
	}
	return true;
}
void solution(vector<vector<int>> baseball) {
    int guess=123;
    while(guess<=987){
    	string tmpS=to_string(guess);
		if(tmpS[0]!='0'&&tmpS[1]!='0'&&tmpS[2]!='0'&&
		tmpS[0]!=tmpS[1]&&tmpS[1]!=tmpS[2]&&tmpS[0]!=tmpS[2]){
			if(check(tmpS, baseball)){
				answer++;
			}
		}
		guess++;	
	}
}
int main(){
	vector<vector<int>> game{{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
	solution(game);
	cout<<answer<<endl;
}
