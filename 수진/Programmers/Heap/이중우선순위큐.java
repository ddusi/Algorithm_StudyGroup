import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        
        for(String operation : operations){
            String[] arr = operation.split(" ");
            
            //I
            if("I".equals(arr[0])){
                maxQue.offer(Integer.parseInt(arr[1]));
                minQue.offer(Integer.parseInt(arr[1]));
            }
            
            //D1
            else if("D".equals(arr[0]) && "1".equals(arr[1])){
                if(!maxQue.isEmpty()){
                    int max = maxQue.peek();
                    maxQue.remove(max);
                    minQue.remove(max);
                }               
            }
            
            //D-1
            else if("D".equals(arr[0]) && "-1".equals(arr[1])){
                if(!maxQue.isEmpty()){
                    int min = minQue.peek();
                    maxQue.remove(min);
                    minQue.remove(min);
                } 
            }
        }
        
        if(!maxQue.isEmpty() && !minQue.isEmpty()){
            answer[0] = maxQue.peek();
            answer[1] = minQue.peek();
        }
        
        return answer;
    }
}