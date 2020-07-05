package algorithm.baekjoon.usaco._2019.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _18268_CowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] KN = br.readLine().split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);

        int[][] practices = new int[K][N];
        for (int i = 0; i < K; i++) {
            String[] practice = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                practices[i][j] = Integer.parseInt(practice[j]);
            }
        }

        Map<Integer, Set<Integer>> consistency = new HashMap<>();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                if(!consistency.containsKey(practices[i][j])){
                    Set<Integer> lessCows = new HashSet<>();
                    consistency.put(practices[i][j], lessCows);
                }
                for (int k = j + 1; k < N; k++) {
                    consistency.get(practices[i][j]).add(practices[i][k]);
                }
            }
        }


        int total = 0;
        for (int betterCow = 1; betterCow <= N; betterCow++) {
            for(int lessCow : consistency.get(betterCow)){
                if(!consistency.get(lessCow).contains(betterCow)){
                    total++;
                }
            }
        }

        System.out.println(total);

        br.close();
    }
}
