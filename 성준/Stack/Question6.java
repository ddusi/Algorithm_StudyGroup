
public class Question6 {
	 public int[] solution(int[] prices) {
	      		int len=prices.length;
		        int[] answer = new int[len];

		        for(int start=0;start<len-1;start++) {
		        	for(int end=start+1;end<len;end++) {
		        		if(prices[start]>prices[end]||end==len-1) {
		        			answer[start]=end-start;

		        			break;
		        		}
		        	}
		        }
		       
		        return answer;
	    }
}
