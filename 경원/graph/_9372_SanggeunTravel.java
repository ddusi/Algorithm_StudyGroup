package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.io.*;

public class _9372_SanggeunTravel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testNums = Integer.parseInt(br.readLine());
        int N = 0;
        int M = 0;
        int[][] flights = null;
        for (int i = 0; i < testNums; i++) {
            String[] strArr = br.readLine().split(" ");
            N = Integer.parseInt(strArr[0]);
            M = Integer.parseInt(strArr[1]);
            flights = new int[M][2];
            for (int j = 0; j < M; j++) {
                strArr = br.readLine().split(" ");
                flights[j][0] = Integer.parseInt(strArr[0]);
                flights[j][1] = Integer.parseInt(strArr[1]);
            }
            sb.append(solution(N, M, flights)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int N, int M, int[][] flights) {
        int answer = 0;
        int[] root = new int[N + 1];
        int[] rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            if(union(flights[i][0], flights[i][1], root, rank)){
               answer++;
            }
        }

        return answer;
    }

    private static boolean union(int x, int y, int[] root, int[] rank){
        x = find(x, root);
        y = find(y, root);
        if(x == y){
            return false;
        }
        if(rank[x] < rank[y]){
            root[x] = y;
        }else{
            root[y] = x;
            if(rank[x] == rank[y]){
                rank[x]++;
            }
        }
        return true;
    }

    private static int find(int x, int[] root){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x], root);
    }
}
