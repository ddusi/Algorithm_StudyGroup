import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for(int num : scoville){
            que.offer(num);
        }
        
        while(que.peek() < K){
            
            if(que.size() == 1){
                return -1;
            }
            
            que.offer(que.poll() + (que.poll()*2));
            cnt++;
        }
        
        return cnt;
    }
}