package study.baekjoon;

import java.util.Scanner;

public class DecompositSum {

//    https://www.acmicpc.net/problem/2231
//    분해합
//    시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//2 초	192 MB	20698	10483	8684	49.968%
//    문제
//    어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
////    예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
////
////    자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
////
////    입력
////    첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
////
////    출력
////    첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String givenStr = sc.next();

        givenStr = givenStr.trim();

        if("".equals(givenStr)){
            System.out.println("insert valid arg.");
            System.exit(0);
        }

        // TODO 인자 int 인지 체크
        int size = givenStr.length();
        int maxAddNum = 9 * size;
        int givenNum = Integer.parseInt(givenStr);

        int minNum = givenNum - maxAddNum;
        if(minNum<0){
            maxAddNum = 0;
            minNum = givenNum;
        }
        int creator = 0;
        while(minNum<=givenNum){
            int addNum = 0;
            String minNumStr = String.valueOf(minNum);
            for(int i = 0; i < minNumStr.length() ; i ++ ) {
                addNum += Integer.parseInt(String.valueOf(minNumStr.charAt(i)));
            }

            if( (addNum + minNum) == givenNum ){
                creator = minNum;
                break;
            } else {
                minNum ++;
            }

        }

        System.out.println(creator);
    }



}
