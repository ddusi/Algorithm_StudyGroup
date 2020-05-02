
public class Question1 {
	public static int[] solution(int[] heights) {
        Stack<Integer> stk= new Stack<Integer>();
        int[] answer= new int[heights.length];
        for(int i=0;i<heights.length;i++) {
       	 stk.push(heights[i]);
        }
        while(!stk.isEmpty()) {
       	 int tmp=stk.pop();
       	 
       	 for(int i=stk.size();i>=0;i--) {
       		 if(tmp<heights[i]) {
       			 answer[stk.size()]=i+1;
       			 break;
       		 }
       	 }
        }
        return answer;
   }
}
