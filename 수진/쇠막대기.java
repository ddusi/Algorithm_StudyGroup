import java.util.*;
class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
		String [] arr = arrangement.split("");
        
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("(")) stack.push(arr[i]);
		    else {
                if (arr[i-1].equals("(")){
                    stack.pop();
                    answer += stack.size();
                } else{
                    answer += 1;
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
