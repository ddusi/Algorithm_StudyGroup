#include "pch.h"
#include <cstdio>
#include <iostream>
#include <algorithm>
#include <utility>

using namespace std;

void num1449() {
	int N, L, A[1000];
	scanf_s("%d %d", &N, &L);
	for (int i = 0; i < N; i++)
		scanf_s("%d", A + i);
	sort(A, A + N);

	int result = 0, p = 0;
	do {
		result++;
		p = lower_bound(A + p, A + N, A[p] + L) - A;
	} while (p < N);
	printf("%d\n", result);
}
bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first)
		return a.second < b.second;
	return a.first > b.first;
}
void num13904() {
	int N, d, w;
	pair<int, int> A[1000];
	int sum[1000];
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d %d", &d, &w);
		A[i] = { w,d };
	}
	sort(A, A + N,compare);
	

	for (int i = 0; i < N; i++)
		printf("%d %d\n", A[i].first, A[i].second);
	int score = 0 , day = 0;
	for (int i = 0; i<N; i++,day++) {
		if (A[i].second >= day) {
			score += A[i].first;
			printf("%d %d", A[i].first, A[i].second);
		}
	}
	printf("%d", score);

}
void num13904_2() {
	int N;
	pair<int,int> p[1000];
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++)
		scanf_s("%d %d", &p[i].first, &p[i].second);
	sort(p, p + N, [](pair<int,int> &a, pair<int,int> &b) {
		if (a.second != b.second) return a.second > b.second;
		return a.first < b.first;
	});
	for (int i = 0; i < N; i++)
		printf("%d %d\n", p[i].first, p[i].second);

	int result[1000] = { 0 }, pos = 0;
	for (int i = 0; i < N; i++) {
		int j = p[i].first - 1;
		for (; result[j] && j >= 0; j--);
		if (j >= 0) result[j] = p[i].second;
	}
	int sum = 0;
	for (int i = 0; i < 1000; i++)
	{
		printf("%d\n", result[i]);
		sum += result[i];
	}
	printf("%d\n", sum);
}
bool compare2(pair<int,int> a,pair<int,int> b) {
	if (a.second == b.second)
		return a.first > b.first;
	return a.second > b.second;
}
void num17509() {
	pair<int, int> probs[11];
	int sum = 0; int time = 0;
	int ver = 0;


	for (int i = 0; i < 11; i++) {
		scanf_s("%d %d", &probs[i].first, &probs[i].second);
	}
	sort(probs, probs + 11);
	for (int i = 0; i < 11; i++) {
		time += probs[i].first;
		sum += time + probs[i].second*20;
	}
}
int main() {
	//num1449();
	//num13904();
	//num13904_2();
	num17509();
}