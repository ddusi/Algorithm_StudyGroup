#include "pch.h"
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int N, pos = 0;
bool visited[11][11];
bool block[11][11] = {};


void check(int x, int y, int count) {
	if (count == N) {
		pos++;
		return;
	}
	int cros_r = 1, cros_l = N;
	for (int j = 1; j <= N; j++) {
		block[x][j] = true;
	}
	for (int i = 1; i <= N; i++) {
		block[i][y] = true;
		block[i][cros_r++] = true;
		block[i][cros_l--] = true;
	}
	for (int i = x; i <= N; i++)
		for (int j = y; j <= N; j++) {
			if (block[i][j] == false && visited[i][j]==false) {
				count++;
				check(i, j, count);
			}
		}


}
void n_queen() {
	int rep;
	scanf("%d", &rep);

	for (int p = 0; p < rep; p++) {
		scanf("%d", &N);
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++) {
				check(i, j, 1);
				visited[i][j] = true;
			}
		for (int q = 1; q <= N; q++)
			fill(block[q], block[q] + 11, false);
		printf("%d", pos);
		pos = 0;
	}

}
int main() {
	//num1209();
	n_queen();
}