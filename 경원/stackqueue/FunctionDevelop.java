package programmers.exercise.stackqueue;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelop {
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] answer = solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] completeDay = new int[speeds.length];
        for(int i = 0; i < speeds.length; i++){
            int diff = 100 - progresses[i];
            completeDay[i] = diff / speeds[i];
            if(diff % speeds[i] != 0){
                completeDay[i] += 1;
            }
        }

        List<Integer> answerList = new ArrayList<>();
        int priority = completeDay[0];
        int startIndex = 0;
        for(int i = 1; i < speeds.length; i++){
            if(completeDay[i] > priority){
                answerList.add(i - startIndex);
                startIndex = i;
                priority = completeDay[i];
            }
        }
        answerList.add(speeds.length - startIndex);

        int[] answer = new int[answerList.size()];
        int index = 0;
        for(int num : answerList){
            answer[index++] = num;
        }
        return answer;
    }
}
