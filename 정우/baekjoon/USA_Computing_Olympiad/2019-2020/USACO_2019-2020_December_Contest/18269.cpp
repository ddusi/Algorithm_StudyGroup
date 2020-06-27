/*
[boj] 18269. Where Am I?
link : https://www.acmicpc.net/problem/18269
*/

#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
#define io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;

int n, answer = 1;
string msg;
int main()
{
	io;
    cin>>n;
    cin>>msg;
    while(answer <= n){
        bool ch = true;
        vector<string> v;
        for(int i=0;i<n;i++){
            if(i + answer <= n){
                v.push_back(msg.substr(i, answer));
            }
        }

        for(int i=0;i<v.size()-1;i++){
            string tmp = v[i];
            for(int j=i+1;j<v.size();j++){
                if(tmp == v[j]){
                    ch = false;
                    break;
                }
            }
            if(!ch) break;
        }
        if(ch) break;
        answer++;
    }
    cout<<answer<<"\n";
    return 0;
}
