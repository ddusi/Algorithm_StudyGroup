package programmers.exercise.stackqueue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class Tower {
    public static void main(String[] args) {
//        int[] heights = {6,9,5,7,4};
//        int[] heights = {3,9,9,3,5,7,2};
//        int[] heights = {1,5,3,6,7,6,5};
        int[] heights = {7, 5, 3, 5, 3, 5, 3};
        int[] answer = solution(heights);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(heights[i]);
            }else{
                Stack<Integer> tmp = new Stack<>();
                while(!stack.isEmpty() && stack.peek() >= heights[i]){
                    tmp.push(stack.pop());
                }
                while(!stack.isEmpty() && stack.peek() < heights[i]){
                    map.put(stack.pop(), i + 1);
                }
                while(!tmp.isEmpty()){
                    stack.push(tmp.pop());
                }
                stack.push(heights[i]);
            }
        }

        for(int i = heights.length - 1; i >= 0; i--){
            if(map.containsKey(heights[i])){
                answer[i] = map.remove(heights[i]);
            }
        }
        return answer;
    }
}
