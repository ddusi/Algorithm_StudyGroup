#include "pch.h"
#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;



void num1209() {
	int arr[100][100];
	int sumcol[100];
	int rep;
	int max,sum;
	int cross_r, cross_l;
	int cross_r_pt, cross_l_pt;
	freopen("C:\\input.txt", "r", stdin);



	for (int i = 0; i < 10; i++) {
		scanf("%d", &rep);
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++){
				scanf("%d", &arr[j][k]);
				}
		}

		max = 0;
		cross_r = 0; cross_r_pt = 0;
		cross_l = 0; cross_l_pt = 0;
		fill(sumcol, sumcol + 100, 0);
		for (int j = 0; j < 100; j++) {
			sum = 0;
			cross_r += arr[j][cross_r_pt++];
			cross_l += arr[j][cross_l_pt--];
			for (int k = 0; k < 100; k++) {
				sum += arr[j][k];
				sumcol[k] +=arr[j][k];
			}
			if (max < sum) max = sum;
		}
		if (max < cross_r) max = cross_r;
		if (max < cross_l) max = cross_l;
		for (int p = 0; p < 100; p++) {
			if (max < sumcol[p]) max = sumcol[p];
		}
		//printf("\#%d", rep);
		printf(" %d\n", max);
	}

}
int N, pos=0;
bool visit[11][11];


void check(int x, int y,int count) {
	if (count == N) {
		pos++;
		return;
	}
	int cros_r = 1, cros_l = N;
	for (int j = 1; j <= N; j++) {
		visit[x][j] = true;
	}
	for (int i = 1; i <= N; i++) {
		visit[i][y] = true;
		visit[i][cros_r++] = true;
		visit[i][cros_l--] = true;
	}
	for(int i=x;i<=N;i++)
		for (int j = y; j <= N; j++) {
			if (visit[i][j] != 1) {
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

			}
		for (int q = 1; q <= N; q++)
			fill(visit[q], visit[q] + 11, false);
		printf("%d", pos);
		pos = 0;
	}

}
int main() {
	//num1209();
	n_queen();
}