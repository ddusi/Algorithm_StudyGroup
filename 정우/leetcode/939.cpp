/*
[LeetCode] 939. Minimum Area Rectangle
https://leetcode.com/problems/minimum-area-rectangle/
*/

#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <unordered_set>
#define io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;

/*
입력받은 좌표를 모두 set에 중복없이 저장한다.
그뒤에 모든 좌표를 버블정렬 방식으로 전부 탐색하면서 사각형이 될수 있는지 판별한다.
x1 != y1
x2 != y2
위 조건을 통해 대각선 점을 찾고 set에 count를 통해 남은 좌표도 찾아서 사각형이 된 상태를 찾아 넓이를 계산한다.
*/

class Solution {
public:
    int minAreaRect(vector<vector<int> >& points) {
        set<pair<int, int> > s;
        for(auto p:points){
            s.insert({p[0],p[1]});
        }
        int area=INT_MAX;
        for(int i=0;i<points.size();i++){
            for(int j=i+1;j<points.size();j++){
                if(points[i][0]!=points[j][0] && points[i][1]!=points[j][1]){
                    pair<int,int> op1={points[i][0],points[j][1]};
                    pair<int,int> op2={points[j][0],points[i][1]};
                    if(s.count(op1) && s.count(op2)){
                        int l=abs(points[i][0]-points[j][0]),w=abs(points[i][1]-points[j][1]);
                        area=min(area,l*w);
                    }
                }
            }
        }
        return area==INT_MAX ? 0 : area;
    }
};

int main()
{
    io;
    return 0;
}
