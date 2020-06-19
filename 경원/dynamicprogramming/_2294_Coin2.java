package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.HashSet;
import java.util.Scanner;

public class _2294_Coin2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        scn.nextLine();
        HashSet<Integer> coins = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(scn.nextLine()));
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= k; i++) {
            if(coins.contains(i)){
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i / 2; j++) {
                if(dp[j] != -1 && dp[i - j] != -1){
                    if(dp[i] == -1){
                        dp[i] = dp[j] + dp[i - j];
                    }else{
                        dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                    }
                }
            }
        }

        System.out.println(dp[k]);
    }
}
