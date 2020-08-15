package algorithm.baekjoon.koi._2016.middle;

import java.io.*;

/**
 * union-find 의 root 찾는 방법으로는 안됨 (시간초과)
 */
public class _13306_Tree {
    private static int N, Q;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NQ = br.readLine().split(" ");
        N = Integer.parseInt(NQ[0]);
        Q = Integer.parseInt(NQ[1]);
        tree = new int[N + 1];
        tree[1] = 1;
        for (int i = 1; i < N; i++) { // i + 1 번째 노드의 부모
            tree[i + 1] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1 + Q; i++) {
            String[] strArr = br.readLine().split(" ");
            int decision = Integer.parseInt(strArr[0]);
            if(decision == 0){
                int node = Integer.parseInt(strArr[1]);
                tree[node] = node;
            }else{
                int start = Integer.parseInt(strArr[1]);
                int end = Integer.parseInt(strArr[2]);
                int startRoot = findRoot(start, end);
                int endRoot = findRoot(end, start);
                if(startRoot == endRoot || startRoot == end || endRoot == start || start == end){
                    sb.append("YES").append("\n");
                } else{
                    sb.append("NO").append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findRoot(int x, int y){
        if(tree[x] == y || x == y){
            return y;
        }
        if(tree[x] == x){
            return x;
        }
        return findRoot(tree[x], y);
    }
}
