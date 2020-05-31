package programmers.exercise.fullsearch;

import java.util.ArrayList;

public class MockTest {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        int[] answer = solution(answers);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] one = {1, 2, 3, 4, 5};
    private static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int[] solution(int[] answers) {
        int[] score = new int[3];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(one[index1] == answers[i]){
                score[0]++;
            }
            if(two[index2] == answers[i]){
                score[1]++;
            }
            if(three[index3] == answers[i]){
                score[2]++;
            }
            index1++;
            index2++;
            index3++;
            if(index1 >= one.length){
                index1 -= one.length;
            }
            if(index2 >= two.length){
                index2 -= two.length;
            }
            if(index3 >= three.length){
                index3 -= three.length;
            }
        }

        int max = 0;
        for (int i = 0; i < score.length; i++) {
            max = Math.max(max, score[i]);
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(score[i] == max){
                answerList.add(i + 1);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
