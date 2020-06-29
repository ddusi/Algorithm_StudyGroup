package programmers.exercise.binarysearch;

import java.util.Arrays;

public class SteppingStone2 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
//        int n = 2;
//        int[] rocks = {1, 2, 3};
//        int n = 3;
//        int[] rocks = {4, 6, 8, 12, 25, 19};
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }

    public static int solution(int distance, int[] rocks, int n) {
        long answer = 0;
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        int mid = 0;

        // mid: 돌을 지운 뒤 남는 간격의 최소값
        // mid 보다 작은 간격이 있을 경우 해당 간격을 규정짓는 돌을 지운다.
        // 없앤 돌의 숫자가 n보다 작거나 같을 경우, min을 mid + 1로 갱신하여 간격의 최소값을 올려 지울 수 있는 돌의 갯수를 체크
        while(min <= max){
            mid = (min + max) / 2;
            int location = 0;
            int remove = 0;
            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - location < mid){
                    remove++;
                }else{
                    location = rocks[i];
                }
            }
            if(distance - location < mid){
                remove++;
            }

            if(remove <= n){
                answer = mid > answer? mid : answer;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return (int) answer;
    }
}
