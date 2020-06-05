package study.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BiggistNum {
//    문제 설명
//    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//   0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
//   순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//    제한 사항
//    numbers의 길이는 1 이상 100,000 이하입니다.
//    numbers의 원소는 0 이상 1,000 이하입니다.
//    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//            입출력 예
//    numbers	return
//            [6, 10, 2]	6210
//            [3, 30, 34, 5, 9]	9534330

    public String solution(int[] numbers) {
        String answer = "";

        int length = numbers.length;

//        String[] input = Arrays.stream(numbers).toArray(String[]::new);
        String[] input = new String[length];
        for(int i =0; i < length; i ++){
            input[i] = String.valueOf(numbers[i]);
        }

        // 이게 복잡한데 이게더 빠르다!!!
        Arrays.sort(input, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {

                int leng1 = o1.length();
                int leng2 = o2.length();

                int j = 0;
                int k = 0;
                char[] ch11 = o1.toCharArray();
                char[] ch22 = o2.toCharArray();
                for(int i = 0; i < leng1*leng2 ; i ++){
                    if(j==leng1){
                        j=0;
                    }
                    if(k==leng2){
                        k=0;
                    }
                    if(ch11[j] == ch22[k]){

                    }else if(ch11[j] > ch22[k]){
                        return -1;
                    }else{
                        return 1;
                    }
                    j++;
                    k++;
                }
                return 0;
            }

        });

        // 요생각을 못했네.,
        Arrays.sort(input, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {

                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2) ;

            }

        });


        StringBuffer k = new StringBuffer();

        for(String i : input){
            k.append(i);
        }

        return '0'==k.charAt(0)?"0":k.toString();
    }

    public static void main(String[] args) {
//        int[] numbers         = {6,10,2};
        int[] numbers         = {3,30,34,5,9};
//        int[] numbers         = {0,0,0,0,0};

        System.out.println( new BiggistNum().solution(numbers));
    }
}
