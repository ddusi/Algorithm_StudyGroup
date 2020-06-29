package algorithm.baekjoon.usaco._2019.December.silver;

import java.util.Scanner;

public class _18265_MooBuzz {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        long min = N;
        long max = 2 * N;
        long mid = 0;
        while(min <= max){
            mid = (min + max) / 2;
            long number = findNumber(mid);
            if(number <= N){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        long answer = findNumber(mid);
        if(answer > N) {
            while (answer > N) {
                mid--;
                answer = findNumber(mid);
            }
        }
        while(mid % 3 == 0 || mid % 5 == 0){
            mid--;
        }
        System.out.println(mid);
    }

    private static long findNumber(long N){
        long answer = N;
        answer -= (N / 3);
        answer -= (N / 5);
        answer += (N / 15);

        return answer;
    }
}
