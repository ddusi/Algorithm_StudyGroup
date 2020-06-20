package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.HashSet;
import java.util.Scanner;

public class _16500_StringJudgement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String target = scn.nextLine();
        int N = Integer.parseInt(scn.nextLine());
        HashSet<String> lists = new HashSet<>();
        for (int i = 0; i < N; i++) {
            lists.add(scn.nextLine());
        }

        int[][] dp = new int[target.length() + 1][target.length() + 1];
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j <= target.length() - i; j++) {
                if(lists.contains(target.substring(j, j + i))){
                    dp[j][j + i] = 1;
                    continue;
                }
                for (int k = 1; k <= i - 1; k++) {
                    if(dp[j][j + k] == 1 && dp[j + k][j + i] == 1){
                        dp[j][j + i] = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[0][target.length()]);
    }
}
