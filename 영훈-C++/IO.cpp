// Algo Study.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//
//C++ 입출력 백준문제풀이
#include "pch.h"
#include <iostream>
#include <cstdio>
#include <string>

using namespace std;



void num10950() {
	int num = 0;
	cin >> num;
	int **abs = new int*[num];
	for (int i = 0; i < num; i++) {
		abs[i] = new int[2];
		cin >> abs[i][0] >> abs[i][1];
		cout << (abs[i][0] + abs[i][1]) << '\n';
	}
}

int num10951() {
	int a, b;
	while (scanf_s("%d%d", &a, &b) != EOF)
		printf("%d\n", a + b);
	return 0;
}
int num10952() {
	int a = -1, b = -1;
	while (scanf_s("%d%d", &a, &b) != EOF && a != 0 && b != 0)
		printf("%d\n", a + b);
	return 0;
}

int num2675() {
	int num;
	scanf_s("%d", &num);
	while (num--) {
		int n;
		string str;
		cin >> n >> str;
		for (int i = 0; i < str.size(); i++)
			for (int j = 0; j < n; j++) {
				printf("%c", str[i]);
			}
		printf("\n");
	}
	return 0;
}
int num1100() {
	int var = 0, count = 0;
	string str;
	for (int i = 0; i < 8; i++) {
		cin >> str;
		for (int j = var % 2; j < 8; j += 2) {
			if (str[j] == 'F') {
				count++;
			}
		}
		var++;
	}
	printf("%d", count);
	return 0;
}

/*int main()
{

	//num10950();
	//num10951();
	//num10952();
	//num2675();
	//num1100();
} */
// 프로그램 실행: <Ctrl+F5> 또는 [디버그] > [디버깅하지 않고 시작] 메뉴
// 프로그램 디버그: <F5> 키 또는 [디버그] > [디버깅 시작] 메뉴

// 시작을 위한 팁: 
//   1. [솔루션 탐색기] 창을 사용하여 파일을 추가/관리합니다.
//   2. [팀 탐색기] 창을 사용하여 소스 제어에 연결합니다.
//   3. [출력] 창을 사용하여 빌드 출력 및 기타 메시지를 확인합니다.
//   4. [오류 목록] 창을 사용하여 오류를 봅니다.
//   5. [프로젝트] > [새 항목 추가]로 이동하여 새 코드 파일을 만들거나, [프로젝트] > [기존 항목 추가]로 이동하여 기존 코드 파일을 프로젝트에 추가합니다.
//   6. 나중에 이 프로젝트를 다시 열려면 [파일] > [열기] > [프로젝트]로 이동하고 .sln 파일을 선택합니다.
