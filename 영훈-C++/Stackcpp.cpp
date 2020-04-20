#include <iostream>
#include "pch.h"
#include <cstdio>
#include <string>
#include <algorithm>
#include <cstdlib>


using namespace std;

#include <iostream>
#include <cstdlib>
using namespace std;

class UnderflowException {};

template<typename T>
class ListNode {
public:
	T value;
	ListNode<T> *next; // 마지막 노드면 nullptr

	// 생성자
	ListNode<T>() : next(nullptr) {}
	ListNode<T>(T value1, ListNode<T> *next1) : value(value1), next(next1) {}
};

template<typename T>
class Stack {
public:
	int size;
	ListNode<T> *tail;

	// 생성자
	Stack<T>() : size(0), tail(nullptr) {}

	// 소멸자
	~Stack<T>() {
		ListNode<T> *t1 = tail, *t2;
		while (t1 != nullptr) {
			t2 = t1->next;
			delete t1;
			t1 = t2;
		}
	}

	// 멤버 함수
	void push(T value) { // 맨 위에 새 원소 삽입
		tail = new ListNode<T>(value, tail);
		size++;
	}

	T top() { // 맨 위의 원소 반환
		try {
			// 예외 처리: 스택이 비어 있음
			if (size == 0) throw UnderflowException();

			return tail->value;
		}
		catch (UnderflowException e) {
			cerr << "스택이 비어 있는데 top 연산을 시도했습니다." << endl;
			exit(1);
		}
	}

	void pop() { // 맨 위의 원소 제거
		try {
			// 예외 처리: 스택이 비어 있음
			if (size == 0) throw UnderflowException();

			ListNode<T> *temp = tail->next;
			delete tail;
			tail = temp;
			size--;
		}
		catch (UnderflowException e) {
			cerr << "스택이 비어 있는데 pop 연산을 시도했습니다." << endl;
			exit(2);
		}
	}
};

template<typename T>
ostream& operator <<(ostream &out, const Stack<T> &LL) { // 원소들을 한 줄에 차례대로 출력
	ListNode<T> *temp = LL.tail;
	out << "top [";
	for (int i = 0; i < LL.size; i++) {
		out << temp->value;
		temp = temp->next;
		if (i < LL.size - 1) out << ", ";
	}
	out << "] bottom";
	return out;
}

char stack[100];
int stackk[100000];
int top = -1;
void push(char item) {
	top++;
	stack[top]=item;
}
/*
char pop() {
	return stack[top--];
}*/
void push(int item) {
	top++;
	stack[top] = item;
}
int pop() {
	return stack[top--];
}
void calculate(char letter) {
	switch (letter) {
	case '+': case '-':
		if (top == -1 || stack[top] == '(')
			push(letter);
		else {
			printf("%c",pop());
			calculate(letter);
		}
		break;
	case '*': case'/':
			if (top == -1 || stack[top] == '(' || stack[top] == '+' || stack[top] == '-')
				push(letter);
			else {
				printf("%c", pop());
				calculate(letter);
			}
			break;
	case '(':
		push(letter);
		break;
	case ')':
		while (true) {
			char temp = pop();
			if (temp == '(') break;
			else printf("%c", temp);
		}
		break;
	default:
		printf("%c", letter);
	}
}
void num1918() {
	string str;
	int num,i;
	cin>>str;
	for (i = 0; i < str.size();i++) {
		calculate(str[i]);
	}
	while (top != -1) {
		printf("%c", pop());
	}
}
void calcal(int num) {

}
void num1725() {
	int rep,num,max=0;
	scanf_s("%d", &rep);
	scanf_s("%d", &num);
	push(num);
	int pre;
	for (int i = 1; i < rep; i++) {
		scanf_s("%d", num);
		if (stack[top] < num)
			push(num);
		else {
			pre = pop();
			if (top == -1) {
				if(max>(pre*i)) max = pre * i;
			}
			else {
				//스택에서바로아래히스토그램까지의거리
				if (max > pre*(i - top + 1)) max = pre * (i - top + 1);
				while (stack[top] >= num) {
					if(max>pre*(i-top+1)) max = pre * (i - top+1);
					pre = pop();
				}
			}
			push(num);
		}
	}

}/*
int main() {
	num1918();

	//히스토그램 어렵네
	//num1725(); 
}*/