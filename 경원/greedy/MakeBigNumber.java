package programmers.exercise.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class MakeBigNumber {
    public static void main(String[] args) {
//        String number = "1924";
//        String number = "1231234";
//        String number = "4177252841";
//        String number = "987654321";
        String number = "12321232123";
//        String number = "77666666666666";
//        String number = "87654321";
        int k = 4;
        System.out.println(solution(number, k));
    }

    /**
     * number의 각 개별 숫자들을 stack을 이용해 내림차순으로 만든다.
     * 1. stack이 비어있다면 숫자를 넣는다.
     * 2. stack이 비어 있지 않다면 현재 넣으려는 숫자가 stack의 peek()보다 작거나 같을 때까지 stack에서 수를 빼낸다.
     *    (이 때 제거되는 숫자 갯수만큼 k에서 빼 준다. k가 양수일 때만 해당 로직을 기동한다.)
     * 3. 2.의 과정이 끝나면 숫자를 넣는다.
     *    ex. number = 12321232123, k = 4
     *      push(1)                 (stack: 1)
     *      -> pop() (k: 4 -> 3)    (stack: empty)
     *      -> push(2)              (stack: 2)
     *      -> pop() (k: 3 -> 2)    (stack: empty)
     *      -> push(3)              (stack: 3)
     *      -> push(2)              (stack: 3 2)
     *      -> push(1)              (stack: 3 2 1)
     *      -> pop() (k: 2 -> 1)    (stack: 3 2)
     *      -> push(2)              (stack: 3 2 2)
     *      -> pop() (k: 1 -> 0)    (stack: 3 2)
     *      -> push(3)              (stack: 3 2 3)
     *      (이 때부터는 k가 0이므로 더 이상 숫자 삭제가 불가능하다.)
     *      -> push(2) -> push(1) -> push(2) -> push(3)
     *
     * 만약 원래 숫자가 내림차순으로 정렬되어 있다면, 남아 있는 k가 0보다 클 것이고,
     * 이 경우 남은 k번 만큼 stack.pop()을 수행한다. (내림차순 정렬되어 있으므로 뒤에 있는 숫자가 작고, 이 수들을 빼면 된다.)
     * @param number
     * @param k
     * @return
     */
    public static String solution(String number, int k) {
        char[] chArr = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chArr.length; i++) {
            if(stack.isEmpty()){
                stack.push(chArr[i]);
            }else{
                while(k > 0 && !stack.isEmpty() && stack.peek() < chArr[i]){
                    stack.pop();
                    k--;
                }
                stack.push(chArr[i]);
            }
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        char[] answer = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return String.valueOf(answer);
    }
}