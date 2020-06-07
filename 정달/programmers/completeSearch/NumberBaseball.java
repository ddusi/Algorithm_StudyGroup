package study.programmers.completeSearch;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

//숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
//
//        각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
//
//        * 숫자는 맞지만, 위치가 틀렸을 때는 볼
//        * 숫자와 위치가 모두 맞을 때는 스트라이크
//        * 숫자와 위치가 모두 틀렸을 때는 아웃
//        예를 들어, 아래의 경우가 있으면
//
//        A : 123
//        B : 1스트라이크 1볼.
//        A : 356
//        B : 1스트라이크 0볼.
//        A : 327
//        B : 2스트라이크 0볼.
//        A : 489
//        B : 0스트라이크 1볼.
//        이때 가능한 답은 324와 328 두 가지입니다.
//
//        질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
//명
//        문제에 나온 예
////        제한사항
////        질문의 수는 1 이상 100 이하의 자연수입니다.
////        baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
////        입출력 예
////        baseball	return
////        [[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
////        입출력 예 설와 같습니다.
//
//        출처
public class NumberBaseball {
    public int solution(int[][] baseball) {
        int answer = 0;
        int hintLen = baseball.length;
        for(int i = 111 ; i < 1000; i ++) {
            char[] ac = String.valueOf(i).toCharArray();
            if(ac[0]==ac[1] || ac[0]==ac[2] || ac[1] ==ac[2] || ac[0] == '0' || ac[1] == '0' || ac[2] == '0' ){
                continue;
            }
            boolean candidate = true;
            for(int j = 0 ; j < hintLen ; j ++) {
                int [] result = getStrikeBall(ac, baseball[j][0]);
                if(!checkMatch(baseball[j], result)) {
                    candidate = false;
                    break;
                }
            }
            if(candidate){
                answer++;
            }
        }
        return answer;
    }
    private int[] getStrikeBall(char[] ac, int b) {
        int[] result = new int[2];
        char[] bc = String.valueOf(b).toCharArray();

        for(int i = 0 ; i < 3; i ++)  {
            if(ac[i] == bc[i]){
                result[0]++;
            }
            for(int j = 0 ; j < 3 ; j++){
                if(i!=j){
                    if(ac[i] == bc[j]) result[1] ++;
                }
            }
        }

        return result;
    }

    private boolean checkMatch(int[] a, int[] b){
        if(a[1]!=b[0]) return false;
        if(a[2]!=b[1]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] answers = {{123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1}};





        System.out.println( new NumberBaseball().solution(answers));

    }
}
