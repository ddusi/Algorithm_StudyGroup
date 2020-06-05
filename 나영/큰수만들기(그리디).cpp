#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int tmp=number.length()-k;
    int max;
    int cnt;
    vector<int> v;
    for(int i=tmp;i>0;i--){
        max=0;
        cnt=0;
        for(int j=0;j<=number.length()-i;j++){
            if(max<number[j]){
                max=number[j];
                cnt=j;
            }
        }
        
        number.replace(0,cnt+1," ");
        v.push_back(max);
    }
    for(int i=0;i<v.size();i++){
        answer+=v[i];
    }
    return answer;
}
