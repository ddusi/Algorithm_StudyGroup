package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.*;

public class _9465_Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int n = 0;
        int[][] stickers = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            for (int index = 0; index < 2; index++) {
                String[] strArr = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    stickers[index][j] = Integer.parseInt(strArr[j]);
                }
            }
            sb.append(solution(n, stickers)).append("\n");
            n = 0;
            stickers = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int n, int[][] stickers) {
        // stickers 중 위쪽을 고르는 방법
        int[] dp1 = new int[n];
        // stickers 중 아래쪽을 고르는 방법
        int[] dp2 = new int[n];
        dp1[0] = stickers[0][0];
        dp2[0] = stickers[1][0];
        dp1[1] = dp2[0] + stickers[0][1];
        dp2[1] = dp1[0] + stickers[1][1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp2[i - 1], Math.max(dp1[i - 2], dp2[i - 2])) + stickers[0][i];
            dp2[i] = Math.max(dp1[i - 1], Math.max(dp1[i - 2], dp2[i - 2])) + stickers[1][i];
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
