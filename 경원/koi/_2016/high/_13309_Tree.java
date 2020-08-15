package algorithm.baekjoon.koi._2016.high;

import java.io.*;
import java.util.ArrayList;

public class _13309_Tree {
    private static int N, Q, maxDepth;
    private static ArrayList<ArrayList<Integer>> adjList;
    private static int[] depths;
    private static int[][] ancestors; // ancestors[i][j] : i 노드의 2^j 번째 선조
    private static int tmp; // dfs 경로 순대로 노드를 넣기 위한 임시 인덱스
    private static int[] start, end; // start[i], end[i]: i 노드를 루트로 하는 서브트리를 dfs 순회했을 때 시작, 끝 range 인덱스
    private static Tree[] segment; // dfsNode에 대한 segment tree (색에 대한 합을 표현)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NQ = br.readLine().split(" ");
        N = Integer.parseInt(NQ[0]);
        Q = Integer.parseInt(NQ[1]);
        depths = new int[N + 1];
        maxDepth = (int) (Math.log(N + 1) / Math.log(2)) + 1;
        ancestors = new int[N + 1][maxDepth + 1];
        start = new int[N + 1];
        end = new int[N + 1];
        // segment tree의 크기는 N보다 크면서 가장 가까운 제곱수의 2배
        // [N, 2N] 에는 perfect square가 적어도 1개 이상 존재하므로 넉넉히 4N으로 크기를 잡는다.
        segment = new Tree[4 * N];
        for (int i = 0; i < segment.length; i++) {
            segment[i] = new Tree();
        }

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        // 인접리스트 만들기
        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(br.readLine());
            adjList.get(i).add(parent);
            adjList.get(parent).add(i);
        }

        tmp = 1;
        // dfs 순대로 노드 재배치
        dfsForInit(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String[] strArr = br.readLine().split(" ");
            int b = Integer.parseInt(strArr[0]);
            int c = Integer.parseInt(strArr[1]);
            int d = Integer.parseInt(strArr[2]);
            int lca = lca(b, c);
            long fromColor = sum(1, 1, N, start[b], start[b]);
            long toColor = sum(1, 1, N, start[c], start[c]);
            long lcaColor = sum(1, 1, N, start[lca], start[lca]);
            if(fromColor == toColor && fromColor == lcaColor){
                sb.append("YES");
                if(d == 1){
                    segmentUpdate(1, 1, N, start[b], end[b], 1);
                }
            }else{
                sb.append("NO");
                if(d == 1){
                    segmentUpdate(1, 1, N, start[c], end[c], 1);
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int lca(int start, int end) {
        // start, end의 depth를 맞춤
        if(depths[start] > depths[end]){
            for (int i = maxDepth; i >= 0; i--) {
                if(depths[end] <= depths[ancestors[start][i]]){
                    start = ancestors[start][i];
                }
            }
        }else if(depths[start] < depths[end]){
            for (int i = maxDepth; i >= 0; i--) {
                if(depths[start] <= depths[ancestors[end][i]]){
                    end = ancestors[end][i];
                }
            }
        }
        // depth가 같으므로 같은 level만큼 올리면서 최소 공통 조상을 찾는다.
        int lca = start;
        if(start != end){
            for (int i = maxDepth; i >= 0; i--) {
                if(ancestors[start][i] != ancestors[end][i]){
                    start = ancestors[start][i];
                    end = ancestors[end][i];
                }
                lca = ancestors[start][i];
            }
        }
        return lca;
    }

    private static void dfsForInit(int node, int parent){
        // lca를 위한 셋팅
        depths[node] = depths[parent] + 1;
        ancestors[node][0] = parent;

        // color 범위 증가를 효율적으로 구현하기 위한 segment tree 셋팅을 위한 dfs 경로 순서대로 노드 재배치
        start[node] = tmp; // 현재 순서의 노드를 루트로 하는 서브트리에서 dfs를 돌렸을 때 dfsNode 상에서 시작되는 위치
        tmp++;

        for (int i = 1; i <= maxDepth; i++) {
            ancestors[node][i] = ancestors[ancestors[node][i - 1]][i - 1];
        }

        for (int child : adjList.get(node)) {
            if(child != parent){
                dfsForInit(child, node);
            }
        }
        end[node] = tmp - 1; // 현재 순서의 노드를 루트로 하는 서브트리에서 dfs를 돌렸을 때 dfsNode 상에서 끝나는 위치
    }

    // [i, j] 구간의 색을 value만큼 동일하게 업데이트 (결과 반영은 segment에 됨)
    private static void segmentUpdate(int node, int start, int end, int i, int j, int value){
        if(segment[node].lazy != 0){ // lazy가 0이 아닐 경우 업데이트
            segment[node].value += (end - start + 1) * segment[node].lazy;
            // lazy 하위 전파
            if(start != end){
                segment[node * 2].lazy += segment[node].lazy;
                segment[node * 2 + 1].lazy += segment[node].lazy;
            }
            segment[node].lazy = 0;
        }

        if(j < start || i > end){
            return;
        }

        if(i <= start && end <= j){ // 원하는 구간을 찾았을 경우 해당 구간 업데이트
            segment[node].value += (end - start + 1) * value;
            if(start != end){
                segment[node * 2].lazy += value;
                segment[node * 2 + 1].lazy += value;
            }
            return;
        }

        int mid = (start + end) / 2;
        segmentUpdate(node * 2, start, mid, i, j, value);
        segmentUpdate(node * 2 + 1, mid + 1, end, i, j, value);

        // 결과 상위 전파
        segment[node].value = segment[node * 2].value + segment[node * 2 + 1].value;
    }

    // i번째부터 j번째까지 색의 합을 구함 (이 문제에서 실제로 사용되는 것은 i = j 일때)
    private static long sum(int node, int start, int end, int i, int j){
        if(segment[node].lazy != 0){
            segment[node].value += (end - start + 1) * segment[node].lazy;
            if(start != end){
                segment[node * 2].lazy += segment[node].lazy;
                segment[node * 2 + 1].lazy += segment[node].lazy;
            }
            segment[node].lazy = 0;
        }

        if(i > end || j < start){
            return 0;
        }

        if(i <= start && end <= j){
            return segment[node].value;
        }

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, i, j) + sum(node * 2 + 1, mid + 1, end, i, j);
    }

    private static class Tree{
        long value;
        long lazy;
    }
}
