#include <string>
#include <vector>
#include<iostream>
#include<cstdio>
#define ll long long
using namespace std;

long long solution(int N) {
    ll answer = 0;
    ll num[n+1];
    num[0]=0;
    num[1]=1;
    for(int i=2;i<=N;i++){
    	num[i]=num[i-1]+num[i-2];
	}
	answer = num[N]*4+num[N-1]*2;
    return answer;
}
