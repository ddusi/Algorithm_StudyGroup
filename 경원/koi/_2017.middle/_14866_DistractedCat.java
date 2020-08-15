package algorithm.baekjoon.koi._2017.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * union-find로 풀었으나 시간초과로 fail!
 */
public class _14866_DistractedCat {
    private static int N, M;
    private static int[][] edges;
    private static int[] root, rank;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        root = new int[N + 1];
        rank = new int[N + 1];
        adjacencyList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            edges[i][0] = node1;
            edges[i][1] = node2;
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        long answer = 0;
        // 노드 i를 없다고 가정하고 사이클이 생기는지를 체크한다.
        for (int i = 1; i <= N; i++) {
            // 노드 1개를 제거했을 때, 남은 엣지 갯수가 N - 1 이상일 경우 무조건 사이클이 생긴다.
            if(M - adjacencyList.get(i).size() >= N - 1){
                continue;
            }

            boolean isPossible = true;
            // root, rank 초기화
            for (int j = 1; j <= N; j++) {
                root[j] = j;
                rank[j] = 0;
            }
            for (int j = 0; j < M; j++) {
                if(edges[j][0] != i && edges[j][1] != i){
                    boolean cycle = union(edges[j][0], edges[j][1]);
                    if(cycle){
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible){
                answer += i;
            }
        }
        System.out.println(answer);
    }

    private static int findRoot(int node){
        if(root[node] == node){
            return node;
        }
        return root[node] = findRoot(root[node]);
    }

    private static boolean union(int x, int y){
        x = findRoot(x);
        y = findRoot(y);

        if(x == y){
            return true;
        }

        if(rank[x] < rank[y]){
            root[x] = y;
        }else{
            root[y] = x;
            // 기존에 x, y의 높이가 같았다면, y를 root로 가지는 트리를 x 하위로 붙이므로 x의 높이가 1 상승된다.
            if(rank[x] == rank[y]){
                rank[x]++;
            }
        }

        return false;
    }
}
