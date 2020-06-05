import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int cnt = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        int idx = 0;
        for(int i = 0; i < k; i++){
            
            if(idx < dates.length && i == dates[idx]){
                que.offer(supplies[idx]);
                idx++;
            }
            
            if(stock == 0){
                stock += que.poll();
                cnt++;
            }
            stock --;
        }
        return cnt;
    }
}