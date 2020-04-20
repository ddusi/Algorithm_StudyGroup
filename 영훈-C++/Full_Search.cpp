#include "pch.h"
#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;


//2020.03.19 못품
int num1912() {

	int num = 0, i, j, max = -1000, sum;
	scanf_s("%d", &num);
	int *arr = new int[num];
	for (i = 0; i < num; i++) scanf_s("%d", arr + i);
	for (i = 0; i < num; i++) {
		sum = 0;
		for (j = i; j < num; j++) {
			sum += arr[j];
			if (sum > max) max = sum;
		}
	}
	cout << max;
	return 0;
}

int num2309() {
	int arr[9];
	int i, j, k, max = 0, sum;
	bool loop = false;
	for (i = 0; i < 9; i++) {
		scanf_s("%d", arr + i);
		max += arr[i];
	}
	sort(arr, arr + 9);
	for (i = 0; i < 8; i++) {
		sum = arr[i];
		for (j = 0; j < 9; j++) {
			if (max - sum - arr[j] == 100) {
				for (k = 0; k < 9; k++) if (k != i && k != j) printf("%d\n", arr[k]);
				loop = true;
				break;
			}
		}
		if (loop) break;
	}
	return 0;
}
void num2231() {
	int num, i, j, result = 0, sum;
	scanf_s("%d", &num);
	string str;
	for (i = 1; i < num; i++) {
		sum = i;
		str = to_string(i);
		for (j = 0; j < str.size(); j++) {
			sum += str[j] - '0';
			//str변환
		}
		if (sum == num) {
			result = i;
			break;
		}
	}
	printf("%d", result);

}

int maximum(int a, int b, int c) {
	return a > b ? (c > a ? c : a) : (b > c ? b : c);
}


int count(int size, char **arr) {
	int maxn = 0;
	for (int i = 0; i < size; i++) {
		int count = 1;
		for (int j = 0; j < size - 1; j++) {

			if (arr[i][j] == arr[i][j + 1])
				count++;
			else
			{
				maxn = max(count, maxn);
				count = 1;
			}
		}
		maxn = max(count, maxn);
	}

	for (int i = 0; i < size; i++) {
		int count = 1;
		for (int j = 0; j < size - 1; j++) {
			if (arr[j][i] == arr[j + 1][i])
				count++;
			else {
				maxn = max(count, maxn);
				count = 1;
			}
		}
		maxn = max(count, maxn);
	}
	return maxn;
}

void num3085() {
	int size, i, j, k, maxn = 0;
	scanf_s("%d", &size);
	char **arr = new char*[size];

	for (i = 0; i < size; i++) {
		arr[i] = new char[size];
		cin >> arr[i];
	}
	for (i = 0; i < size; i++) {
		for (j = 0; j < size - 1; j++) {
			swap(arr[i][j], arr[i][j + 1]);
			maxn = max(maxn, count(size, arr));
			swap(arr[i][j], arr[i][j + 1]);
		}
		if (i < size - 1) {
			for (j = 0; j < size; j++) {

				swap(arr[i][j], arr[i + 1][j]);
				maxn = max(maxn, count(size, arr));
				swap(arr[i][j], arr[i + 1][j]);

			}
		}
	}
	printf("%d", maxn);
}
void githubtest() {
	cout << "github is working";
}
int num10448() {
	int i, j, size, x, y, z, num, *ans;
	bool out;
	int t[45];
	for (i = 0; i < 45; i++) {
		t[i] = ((i + 1)*(i + 2)) / 2;
	}
	scanf_s("%d", &size);
	ans = new int[size];
	for (i = 0; i < size; i++) {
		scanf_s("%d", &num);
		int point = 0;
		for (j = 1; j < 45; j++) {
			if (num <= t[j]) point = j - 1;
		}
		out = false;
		for (x = point; x > -1; x--) {
			for (y = 0; y < 45; y++) {
				for (z = 0; z < 45; z++) {
					if (t[x] + t[y] + t[z] == num) {
						out = true;
						break;
					}
				}
				if (out) break;
			}
			if (out) break;
		}
		if (out) ans[i] = 1;
		else ans[i] = 0;
	}
	for (i = 0; i < size; i++) {
		printf("%d", ans[i]);
	}

	return 0;
}
int num2503() {
	int line, i, j, k, st_count, bl_count, ans = 0;
	int num, st, bl;
	scanf_s("%d", &line);

	int **pos = new int *[line];
	for (i = 0; i < line; i++) {
		pos[i] = new int[100];
	}

	for (i = 0; i < line; i++) {
		scanf_s("%d%d%d", &num, &st, &bl);
		for (int i = 123; i <= 999; i++) {
			st_count = 0;
			bl_count = 0;
			string s1 = to_string(num);
			string s2 = to_string(i);
			for (k = 0; k < 3; k++)
				for (j = 0; j < 3; j++) {
					if (k == j && s1[k] == s2[j])
						st_count++;
					if (k != j && s1[k] == s2[j])
						bl_count++;
				}
			if (st_count == st && bl_count == bl)
				ans++;
		}

	}
	return 0;
}
int num2503_2() {
	bool board[1000]; //정답 가능성있는 숫자 배열
	int num = 0;
	int n1, n2, n3, ans = 0;
	scanf_s("%d", &num);
	for (int i = 123; i <= 999; i++)
	{
		//숫자중복,0 제거
		string s1 = to_string(i);
		if (s1[0] == s1[1] || s1[0] == s1[2] || s1[1] == s1[2])
			board[i] = false;
		if (s1[0] - '0' == 0 || s1[1] - '0' == 0 || s1[2] - '0' == 0)
			board[i] = false;
		s1.clear();
	}
	for (int i = 0; i < num; i++)
	{
		scanf_s("%d %d %d", &n1, &n2, &n3);
		if (n2 == 3) {
			printf("%d", 1);
			return 0;
		}
		for (int j = 123; j <= 999; j++)
		{
			int strike_count = 0;
			int ball_count = 0;
			string s2 = to_string(n1);
			string s3 = to_string(j);
			for (int x = 0; x < 3; x++)
			{
				for (int y = 0; y < 3; y++)
				{
					//자리수와 값 모두일치시 스트라이크, 값만일치시 볼카운트
					if (x == y && s2[x] == s3[y])
						strike_count++;
					if (x != y && s2[x] == s3[y])
						ball_count++;
				}
			}
			//스트라이크,볼이 한개라도 다르면 불가능함으로 제외
			if (strike_count != n2 || ball_count != n3)
				board[j] = false;
			s2.clear();
			s3.clear();

		}

	}
	for (int i = 123; i <= 999; i++)
	{
		if (board[i])
			ans++;
	}
	printf("%d", ans);
	return 0;
}

/*
int main() {
	//num1912(); //못품
	//num2309();
	//num2231();
	//num3085();
	//githubtest();
	//num10448();
	//num2503_2(); //못품

}*/