package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _1699_SquareNumberSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        int sqrtN = (int) Math.sqrt(n);
        if(sqrtN * sqrtN == n){
            return 1;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 987654321;
        }
        for (int i = 1; i <= n; i++) {
            int sqrtI = (int) Math.sqrt(i);
            if(sqrtI * sqrtI == i){
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
//
//        try {
//            FileWriter fw = new FileWriter("test.txt");
//            StringBuilder sb = new StringBuilder();
//            for (int i = 1; i <= n; i++) {
//                sb.append(String.valueOf(dp[i])).append("\n");
//            }
//            fw.write(sb.toString());
//            fw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return dp[n];
    }
}
