#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include<algorithm>
using namespace std;
bool compare(pair<int, int> a, pair<int, int> b){
	if(a.first == b.first){
		return a.second > b.second;
	}
	return a.first < b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
	vector<int> answer;
	
    unordered_map<string, int> m;
    for(int i=0;i<genres.size();i++){
        m[genres[i]]+=plays[i];
    }
    vector<pair<int, string>> tmpv;
    for(auto it=m.begin();it!=m.end();it++){
        tmpv.push_back({it->second, it->first});
    }
   sort(tmpv.begin(), tmpv.end());
    while(!tmpv.empty()) {
        string genre = tmpv.back().second;
        int play=tmpv.back().first;
        tmpv.pop_back();
        
        vector<pair<int, int>> count;
        for(int i=0;i<genres.size();i++){
            if(genres[i].compare(genre)==0) {
            	count.push_back({plays[i], i});
            }
        }
        sort(count.begin(), count.end(), compare);
        int cnt =0;
        for(int i=count.size()-1;i>=0;i--){
            if(cnt>=2) break;
            answer.push_back(count[i].second);
            cnt++;
        }
    }
    return answer;
}
