#include "pch.h"
#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <climits>
const int MAX = 1000001;

using namespace std;
int dp[MAX];
int f(int n) {
	if (n == 1) return 0; // base case
	if (dp[n] != -1) return dp[n]; // 이미 계산함

	int result = f(n - 1) + 1;
	if (n % 3 == 0) result = min(result, f(n / 3) + 1);
	if (n % 2 == 0) result = min(result, f(n / 2) + 1);
	dp[n] = result;
	return result;
}
void num1463() {
		int N;
		scanf("%d", &N);
		fill(dp, dp + MAX, -1);
		printf("%d\n", f(N));
}
const int MAX2 = 100000;
int N, value[2][MAX2], dp2[MAX2][3];
int sticker(int c, int status) {
	if (c == N) return 0; // base case
	if (dp2[c][status] != -1) return dp2[c][status]; // 이미 계산됨

	int result = sticker(c + 1, 0);
	if (status != 1) result = max(result, sticker(c + 1, 1) + value[0][c]);
	if (status != 2) result = max(result, sticker(c + 1, 2) + value[1][c]);
	// dp 배열 갱신
	dp2[c][status] = result;
	return result;
}
void num9465() {
	int T;
	scanf("%d", &T);
	for (int t = 0; t < T; t++) {
		scanf("%d", &N);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < N; j++)
				scanf("%d", &value[i][j]);
		// dp 배열 초기화
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++)
				dp2[i][j] = -1;
		// dp로 문제 품
		printf("%d\n", sticker(0, 0));
	}
}
int coins[100];
int dp3[101][10001];
int check(int n,int k) {
	if (n == N) return (k == 0 ? 0 : 1000000000); // base case
	if (dp3[n][k] != -1) return dp3[n][k]; // 이미 계산됨

	int result = check(n + 1, k);
	if (k >= coins[n]) result = min(result, check(n, k - coins[n]) + 1);
	dp3[n][k] = result; // dp 배열 값 갱신
	return result;
}
void num2294() {
	int n, k;
	int low=INT_MAX;
	scanf_s("%d %d", &n, &k);
	for (int i = 0; i < n; i++) 
		scanf_s("%d", &coins[i]);
	N = n;
	for (int i = 0; i <= N; i++)
		for (int j = 0; j <= k; j++)
			dp3[i][j] = -1;
	int result = check(0, k);
	if (result == 1000000000) result = -1;
	printf("%d", result);
}


int coins2[100], dp22[101][10001];

int dp2193[90][2];
int pinary(int n, int digit) {
	if (n == N) return 0;
	if (dp2193[n][digit] != -1) return dp2193[n][digit];
	
	int result;
	 result = pinary(n + 1, 0)+1;
	if (digit == 0) result += pinary(n + 1, 1)+1;
	dp2193[n][digit] = result;
	return result;

}
void num2193() {
	scanf("%d", &N);
	for (int i = 0; i <= 89; i++)
		for (int j = 0; j <= 1; j++)
			dp2193[i][j] = -1;
	printf("%d",pinary(0, 1));

}
int main() {
	//num1463();
	//num9465();
	num2294();
	//num2193();
}