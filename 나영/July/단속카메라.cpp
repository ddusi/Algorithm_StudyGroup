#include<string>
#include<vector>
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;

// 단속용 카메라를 적어도 한번은 만나도록 설치
// 이동경로 - routes 
// 최소 카메라 설치
// routes[i][0] - 진입 지점
// routes[i][1] - 나간 지점 

int solution(vector<vector<int>> routes) {
    int answer = 1;
    
    sort(routes.begin(),routes.end());
    int tmp = routes[0][1];
    
    for(int i=1;i<routes.size();i++){
        // 현재 차가 이전차가 나오고 난 다음에 온경우
    	if(tmp<routes[i][0]){
    		answer++;
    		tmp=routes[i][1];
		} 
        // 현재차가 이전차가 나가기 전에 나간경우
		if(tmp>=routes[i][1]){
			tmp = routes[i][1];	
		}
        // 사이에 있는 경우
        if(tmp>=routes[i][0] && tmp<=routes[i][1]) {
            continue;
        }
	}
    return answer;
}
int main(){
	
	vector<vector<int>> routes{{-20,15},{-14,-5},{-18,-13},{-5,-3}};
	int ans =solution(routes); 
	cout<<ans;
}
