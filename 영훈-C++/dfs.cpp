#include "pch.h"
#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int field[50][50] = {};
bool visited[50][50] = { false, };
int rep, M, N, cab, ans;

void dfs(int x,int y) {
	if (!visited[x][y]) {
		visited[x][y] = true;
		if (x - 1 > -1 && field[x-1][y]==1)
			dfs(x - 1, y);
		if (x + 1 < N && field[x+1][y]==1 )
			dfs(x + 1, y);
		if (y - 1 > -1 && field[x][y-1]==1)
			dfs(x, y - 1);
		if (y + 1 < M && field[x][y+1]==1)
			dfs(x, y + 1);
	}

}


void num1012() {
	int x, y;
	scanf_s("%d", &rep);
	for (int i = 0; i < rep; i++) {
		ans = 0;
		for (int j = 0; j < N; j++)
			for (int k = 0; k < M; k++)
			{
				field[j][k] = 0;
				visited[j][k] = false;
			}

		scanf_s("%d %d %d", &M, &N, &cab);
		for (int j = 0; j < cab; j++) {
			scanf_s("%d %d", &x, &y);
			field[y][x] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int p = 0; p < M;p++) {
				if (field[k][p] == 1 && visited[k][p] == false) {
					dfs(k, p);
					ans++;
				}
			}
		}

		printf("%d\n", ans);
	}
	

}

int edge[101][101] = {};
bool visited2[101]= { false, };

void dfs3(int y) {
	visited2[y] = true;
	for(int i=0;i<N;i++)
		if (edge[y][i] == 1&& visited2[i]==false) {
			dfs3(i);
		}
}
void num11403() {
	scanf_s("%d", &N);
	for(int i=0; i<N;i++)
		for (int j = 0; j < N; j++)
		{
			scanf_s("%d", &cab);
			edge[i][j] = cab;
		}
	for (int i = 0; i < N; i++) {
		memset(visited2, false, sizeof(visited2));
		for (int j = 0; j < N; j++)
		{
			if (edge[i][j] == 1 )
				dfs3(j);
		}
		for (int j = 0; j < N; j++)
			if (visited2[j] == true)
				edge[i][j] = 1;
	}

	for (int i = 0; i < N; i++) {
		printf("\n");
		for (int j = 0; j < N; j++)
			printf("%d ", edge[i][j]);
	}
}

int land[100][100];
bool visited3[100][100];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };
void dfs2468(int x,int y,int high) {
	visited3[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nextx = x + dx[i];
		int nexty = y + dy[i];
		if (nextx >= 0 && nextx < N&&nexty >= 0 && nexty < N&&visited3[nextx][nexty] == false&&land[nextx][nexty]>high) {
			dfs2468(nextx, nexty, high);
		}
	}
}
void num2468() {
	scanf("%d", &N);
	int max = 0, maxcomp = 0;
	int count;
	for(int i=0;i<N;i++){
		for (int j = 0; j < N; j++) {
			scanf("%d", &land[i][j]);
			if (land[i][j] > max) max = land[i][j];
		}
		fill(visited3[i], visited3[i] + 100, false);
	}
	for (int i = 0; i < max; i++) {
		count = 0;
		for (int j = 0; j < N; j++)
			for (int k = 0; k < N; k++) {
				if (visited3[j][k] == false&&land[j][k]>i) {
					dfs2468(j, k, i);
					count++;
				}
			}
		for (int i = 0; i < N; i++)
			fill(visited3[i], visited3[i] + 100, false);
		if (maxcomp < count) maxcomp = count;
	}
	printf("%d", maxcomp);
}

bool finished[100001];
bool visited4[100001] ;
int student[100001];
int cnt ;

void dfs9466(int cur) {
	visited4[cur] = true;
	int next = student[cur];
	if (visited4[next]) {
		if (!finished[next]) {
			for (int temp = next; temp != cur; temp = student[temp]) cnt++;
			cnt++;
		}
	}
	else
		dfs9466(next);
	finished[cur] = true;
}
void num9466() {
	int rep,num;
	scanf("%d", &rep);
	for (int i = 0; i < rep; i++) {
		scanf("%d", &num);
		cnt = 0;
		fill(visited4,visited4 + num+1, false);
		fill(finished, finished + num+1, false);
		for (int j = 1; j <= num; j++) {
			scanf("%d", &student[j]);
		}
		for (int j = 1; j <= num; j++) {
			if (visited4[j] == false) {
				dfs9466(j);
			}
		}
		printf("%d", num - cnt);
	}

}


int  S[100000]; // cnt: 싸이클에 속하는 정점 개수
bool visited6[100000], finished2[100000];

void dfs(int curr) {
	visited6[curr] = true;
	int next = S[curr];
	if (visited6[next]) {
		if (!finished2[next]) {
			for (int temp = next; temp != curr; temp = S[temp]) cnt++;
			cnt++; // 자기 자신
		}
	}
	else dfs(next);
	finished2[curr] = true;
}

void num9466_2() {
	int T;
	scanf("%d", &T);
	for (int t = 0; t < T; t++) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			scanf("%d", S + i);
			S[i]--;
		}

		// 각 컴포넌트에 대해 DFS 시작
		fill(visited6, visited6 + N, false);
		fill(finished2, finished2 + N, false);
		cnt = 0;
		for (int i = 0; i < N; i++)
			if (!visited6[i]) dfs(i);
		printf("%d\n", N - cnt);
	}
}


int main() {
	//num11403();
	//num1012();
	//num2468();
	num9466();
	//num9466_2();
}