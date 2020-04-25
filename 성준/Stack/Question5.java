
public class Question5 {
	public int solution(String arrangement) {
        String copyArray = arrangement.replace("()", "0");
        int answer = 0;
        
        ArrayList<Character> copy = new ArrayList<Character>();
        
        for(int i = 0; i < copyArray.length(); i++){ copy.add(copyArray.charAt(i)); }
        
        ArrayList<Character> stack = new ArrayList<Character>();
        
        for(int i = 0; i < copy.size(); i++){
            if(copy.get(i) == '('){
                stack.add(copy.get(i));
            }else if(copy.get(i) == ')'){
                stack.remove(stack.size()-1);
                answer += 1;
            }else if(copy.get(i) == '0'){
                answer += stack.size();
            }
        }
        return answer;
    }
}	       
	
