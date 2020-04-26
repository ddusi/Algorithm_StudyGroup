package programmers.exercise.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class IronBar2 {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        int ans = solution(arrangement);
        System.out.println(ans);
    }

    public static int solution(String arrangement) {
        int answer = 0;
        char[] chArr = arrangement.toCharArray();
        Stack<Character> change = new Stack<>();
        for (char ch : chArr) {
            if (change.isEmpty() || change.peek().charValue() != '(') {
                change.push(ch);
            } else {
                if (change.peek().charValue() == '(' && ch == ')') {
                    change.pop();
                    change.push('L');
                } else {
                    change.push(ch);
                }
            }
        }

        Stack<Integer> right = new Stack<>();
        while (!change.isEmpty()) {
            if (change.peek().charValue() == 'L') {
                answer += right.size();
            } else if (change.peek().charValue() == ')') {
                right.push(1);
            } else{
              answer += right.pop();
            }
            change.pop();
        }
        return answer;
    }
}
