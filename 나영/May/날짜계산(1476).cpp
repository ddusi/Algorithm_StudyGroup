#include<iostream>
#include<cstdio>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;

//E,S,M
//1 ¡Â E ¡Â 15, 1 ¡Â S ¡Â 28, 1 ¡Â M ¡Â 19
int ans=0;
int num[3];
bool check(int n){
	
	int a = n%15==0?15:n%15;
	int b = n%28==0?28:n%28;
	int c = n%19==0?19:n%19;
	if(a==num[0]&&b==num[1]&&c==num[2]){
		return true;
	}
	return false;
}
int func(){
	int max= 15*28*19;
	int numTemp=*max_element(num, num+3);
	while(1){
		if(check(numTemp)) {
			break;
		};
		numTemp++;			
	}
	
	return numTemp;
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	for(int i=0;i<3;i++){
		cin>>num[i];
	}	
	ans = func();
	cout<<ans<<"\n";
}
