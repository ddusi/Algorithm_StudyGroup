import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long answer = Long.MAX_VALUE;
        long min = 0; //최솟값
        long max = (long) times[times.length-1] * n; //최댓값(최대시간*n)
        long mid = 0;
        
        //이분탐색
        while(min <= max){
            long cnt = 0; //검사받을 수 있는 사람의 수 (mid시간을 기준으로)
            mid = (min + max) / 2;
            
            for(int time : times){
                cnt += mid / time;
            }
            
            //시간 부족.
            if(cnt < n){
                min = mid + 1;
            }
            //시간 충분 or 남음.
            else{
                if(mid < answer){
                    answer = mid;
                }
                max = mid - 1;
            }
        }
              
        return answer;
    }
}