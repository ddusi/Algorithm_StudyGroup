#include "pch.h"
#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

struct Point{
	int x; int y; int move;
};

void num7562() {
	int rep;
	int L, s_x, s_y, e_x, e_y;
	scanf_s("%d", &rep);
	
	int visited[300][300] = {};
	int move_x[8] = { -1, -2,-1 ,-2 , +1,+2,+1,+2};
	int move_y[8] = { -2, -1, +2 ,+1, -2,-1,+2,+1};
	for (int i = 0; i < rep; i++) {
		scanf_s("%d", &L);
		scanf_s("%d %d", &s_x, &s_y);
		scanf_s("%d %d", &e_x, &e_y);
		queue<pair<int, int>> q;
		q.push({ s_x,s_y });
		int count = 0;
		memset(visited, 0, sizeof(visited));
		while (!q.empty()) {
			int cur_x = q.front().first;
			int cur_y = q.front().second;
			q.pop();
			if (cur_x == e_x && cur_y == e_y) {
				printf("%d\n", visited[e_x][e_y]);
				break;
			}
			for (int j = 0; j < 8; j++) {
				int next_x = cur_x + move_x[j];
				int next_y = cur_y + move_y[j];
				if (next_x > -1 && next_x<L&&next_y>-1 
					&& next_y < L && visited[next_x][next_y]==0) {
					visited[next_x][next_y] = visited[cur_x][cur_y] + 1;
					q.push({ next_x,next_y });
				}
			}
		}
	}
}

void num13913() {
	int n, m;
	int best;
	scanf_s("%d %d", &n, &m);
	pair<int,int> dp[100001] = {};
	int parent[100001] = {};
	queue<int> q;
	q.push(n);
	int jump[3] = { -1,1,2 };
	while (!q.empty()) {
		int cur = q.front();
		int next;
		q.pop();
		if (cur == m) {
			best = dp[cur].first;
			break;
		} 
		for (int i = 0; i < 2; i++) {
			next=cur + jump[i];
			if (cur > -1 && cur < 100001 && (dp[next].first ==0) ) {
				dp[next].first = dp[cur].first + 1;
				dp[next].second = cur;
				q.push(next);
			}
		}
		next = cur * jump[2];
		if (next < 100001 && (dp[next].first == 0)) {
			dp[next].first = dp[cur].first + 1;
			dp[next].second = cur;
			q.push(next);
		}
	}
	printf("%d\n", best);
	vector<int> out;
	int i = m;
	do {
		out.insert(out.begin(), dp[i].second);
		i = dp[i].second;
	} while (i != n);
	vector<int>::iterator it;
	for (it = out.begin(); it < out.end(); it++)
		printf("%d ", *it);
	printf("%d", m);
}

int main() {

	
	num7562();
	//num13913();

}