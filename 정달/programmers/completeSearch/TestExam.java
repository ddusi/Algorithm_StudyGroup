package study.programmers.completeSearch;

import java.util.*;

//프로그래머스 완전탐색 4문제
//        모의고사
//        소수 찾기
//        숫자 야구
//        카펫
//        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2,  4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//        제한 조건
//        시험은 최대 10,000 문제로 구성되어있습니다.
//        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
//        입출력 예
//        answers	return
//        [1,2,3,4,5]	[1]
//        [1,3,2,4,2]	[1,2,3]
//        입출력 예 설명
//        입출력 예 #1
//
//        수포자 1은 모든 문제를 맞혔습니다.
//        수포자 2는 모든 문제를 틀렸습니다.
//        수포자 3은 모든 문제를 틀렸습니다.
//        따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
//
//        입출력 예 #2
//
//        모든 사람이 2문제씩을 맞췄습니다.
public class TestExam {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int length = answers.length;
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int aLength = a.length;
        int bLength = b.length;
        int cLength = c.length;



        for(int i = 0; i < length; i ++) {

            if(answers[i]==a[i%aLength]){
                answer[0]++;
            }
            if(answers[i]==b[i%bLength]){
                answer[1]++;
            }
            if(answers[i]==c[i%cLength]){
                answer[2]++;
            }
        }


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        if(answer[stack.peek()]<answer[1]){
            stack.pop();
            stack.push(1);
        }else if(answer[stack.peek()]==answer[1]){
            stack.push(1);
        }
        if(answer[stack.peek()]<answer[2]){
            stack.clear();
            stack.push(2);
        }else if(answer[stack.peek()]==answer[2]){
            stack.push(2);
        }
        int size = stack.size();
        int[] fanswer = new int[size];
        for(int k = 0 ; k < size; k ++){
            fanswer[k] = stack.pollFirst()+1;
        }

        return fanswer;
    }

    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};

        for(int k : new TestExam().solution(answers)){
            System.out.println(k);
        }

    }
}
