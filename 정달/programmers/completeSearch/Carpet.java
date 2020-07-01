package study.programmers.completeSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//카펫
//        문제 설명
//        Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
//
//        carpet.png
//
//        Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
//
//        Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로,
//        세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
//        노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
//        카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
//        입출력 예
//        brown	yellow	return
//        10	2	[4, 3]
//        8	1	[3, 3]
//        24	24	[8, 6]
//        출처
//
//        ※ 공지 - 2020년 2월 3일 테스트케이스가 추가되었습니다.
//        ※ 공지 - 2020년 5월 11일 웹접근성을 고려하여 빨간색을 노란색으로 수정하였습니다.
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        List<int[]> list = getYellowSquare(yellow);
        int length = list.size();

        for(int i = 0 ; i < length; i ++) {
            if( matchBrown(list.get(i), brown)){
                return new int[]{list.get(i)[0]+2,list.get(i)[1]+2};
            }
        }


        return answer;
    }



    private boolean matchBrown(int[] yellowSquare, int brown){
        return brown == ((yellowSquare[0] * 2 ) + (yellowSquare[1] *2) + 4);
    }

    private List<int[]> getYellowSquare(int yellow){

        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= yellow; i ++) {
            if(yellow%i == 0 ) {
                int[] square = new int[2];
                square[1] = i;
                square[0] = yellow/i;
                if(square[0]<square[1]){
                    break;
                }
                list.add(square);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;




        for(int a : new Carpet().solution(brown, yellow)){
            System.out.println(a);
        }

    }
}
