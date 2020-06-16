#include<iostream>
#include<cstdio>
#include<algorithm>
#include<functional>
using namespace std;
typedef struct student{
	string name;
	int ko;
	int en;
	int math;
}student; 
int num;
// 1. 국어 점수 감소순
// 2. 국어 점수 같으면 영어 점수 증가순
//3. 국어, 영어 같으면 수학 점수 감소 
//4. 세개다 같으면 이름순  
bool compare(student s1, student s2){
	if(s1.ko==s2.ko){
		if(s1.en==s2.en){
			if(s1.math==s2.math){
				return s1.name<s2.name;
			} else {
				return s1.math>s2.math;
			}
		}else {
			return s1.en<s2.en;
		}
	}else {
		return s1.ko>s2.ko; 
	}
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	cin>>num;
	student stu[num];

	for(int i=0;i<num;i++){
		cin>>stu[i].name>>stu[i].ko>>stu[i].en>>stu[i].math;
	}
	sort(stu,stu+num,compare);
	for(int i=0;i<num;i++){
		cout<<stu[i].name<<"\n";
	}
	
}
