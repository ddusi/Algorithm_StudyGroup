package programmers.exercise.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberBaseball {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            if(isAppropriate(i)){
                if(check(baseball, i)){
                    answer++;
                }
            }
        }

        return answer;
    }

    // 숫자야구의 결과물로 적당한지 체크 (ex. 111, 190같이 숫자가 중복되거나 0이 포함되어 있으며 안됨)
    private static boolean isAppropriate(int num){
        char[] chArr = String.valueOf(num).toCharArray();
        Arrays.sort(chArr);
        boolean answer = true;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '0' || (i != 0 && chArr[i] == chArr[i - 1])){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
    private static boolean check(int[][] baseball, int candidate){

        for (int i = 0; i < baseball.length; i++) {
            int[] result = decision(baseball[i][0], candidate);
            if(result[0] != baseball[i][1] || result[1] != baseball[i][2]){
                return false;
            }
        }
        
        return true;
    }

    private static int[] decision(int compare, int candidate){
        int[] result = new int[2];

        char[] chArr1 = String.valueOf(compare).toCharArray();
        char[] chArr2 = String.valueOf(candidate).toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chArr1.length; i++) {
            if(chArr1[i] == chArr2[i]){
                result[0]++;
            }
            set.add(chArr1[i]);
        }

        int same = 0;
        for (int i = 0; i < chArr2.length; i++) {
            if(set.contains(chArr2[i])){
                same++;
            }
        }

        result[1] = same - result[0];

        return result;
    }
}
