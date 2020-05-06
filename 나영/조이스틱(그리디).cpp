#include<algorithm>
#include<iostream>
#include<cstdio>
#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    int point = 0;
    string tmp;
    
    for (int i = 0; i < name.size(); i++) {
        tmp += "A";
    }
    while (tmp != name) {
        int next = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < name.size(); i++) {
            if (point + i < name.size()) right = point + i;
            else right = point + i - name.size();
            
            if (point - i >= 0) left = point - i;
            else left = point - i + name.size();
            
            if (tmp[right] != name[right]) next = right;
            else if (tmp[left] != name[left]) next = left;
            else continue;
            
            answer += i;
            answer += min(name[next] - 'A', 'Z' - name[next] + 1);
            tmp[next] = name[next];
            break;
        }
        point = next;
    }
    
    return answer;
}
