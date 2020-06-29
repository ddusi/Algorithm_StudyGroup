#include<string>
#include<vector>
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;

// �ܼӿ� ī�޶� ��� �ѹ��� �������� ��ġ
// �̵���� - routes 
// �ּ� ī�޶� ��ġ
// routes[i][0] - ���� ����
// routes[i][1] - ���� ���� 

int solution(vector<vector<int>> routes) {
    int answer = 1;
    
    sort(routes.begin(),routes.end());
    int tmp = routes[0][1];
    
    for(int i=1;i<routes.size();i++){
        // ���� ���� �������� ������ �� ������ �°��
    	if(tmp<routes[i][0]){
    		answer++;
    		tmp=routes[i][1];
		} 
        // �������� �������� ������ ���� �������
		if(tmp>=routes[i][1]){
			tmp = routes[i][1];	
		}
        // ���̿� �ִ� ���
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
