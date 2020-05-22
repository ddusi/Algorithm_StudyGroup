package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//국영수 분류 Silver IV
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        1 초	256 MB	11471	5343	3977	47.390%
//        문제
//        도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
//
//        국어 점수가 감소하는 순서로
//        국어 점수가 같으면 영어 점수가 증가하는 순서로
//        국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
//        모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
//        입력
//        첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.
//
//        출력
//        문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.
//
//        예제 입력 1
//        12
//        Junkyu 50 60 100
//        Sangkeun 80 60 50
//        Sunyoung 80 70 100
//        Soong 50 60 90
//        Haebin 50 60 100
//        Kangsoo 60 80 100
//        Donghyuk 80 60 100
//        Sei 70 70 70
//        Wonseob 70 70 90
//        Sanghyun 70 70 80
//        nsj 80 80 80
//        Taewhan 50 60 90
//        예제 출력 1
//        Donghyuk
//        Sangkeun
//        Sunyoung
//        nsj
//        Wonseob
//        Sanghyun
//        Sei
//        Kangsoo
//        Haebin
//        Junkyu
//        Soong
//        Taewhan
public class GUkYoungSu10825 {

    public static int lines = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int howManyMelody = Integer.parseInt(br.readLine());
        List<String[]> paramList = new ArrayList<>();
        for(int i = 0 ; i < howManyMelody ; i ++) {
            int[] melody = new int[2];
            String[] param = br.readLine().trim().split(" ");
            paramList.add(param);
        }

        System.out.println(new GUkYoungSu10825().solution(paramList));
    }

    public String solution(List<String[]> paramList){

        Collections.sort(paramList, (o1, o2) -> {

            if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
                return -1;
            }else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
                return 1;
            }else{
                if(Integer.parseInt(o1[2]) > Integer.parseInt(o2[2])){
                    return 1;
                }else if(Integer.parseInt(o1[2]) < Integer.parseInt(o2[2])){
                    return -1;
                }else{
                    if(Integer.parseInt(o1[3]) > Integer.parseInt(o2[3])){
                        return -1;
                    }else if(Integer.parseInt(o1[3]) < Integer.parseInt(o2[3])){
                        return 1;
                    }else{
                        return o1[0].compareTo(o2[0]);
                    }
                }
            }
        } );

        StringBuffer sb = new StringBuffer();
        for(String[] k : paramList){
            sb.append(k[0]).append("\n");
        }

        return sb.toString();
    }

}
