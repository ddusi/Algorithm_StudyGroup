package algorithm.baekjoon.koi._2017.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _14866_DistractedCat2 {
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> adjList;
    private static ArrayList<ArrayList<Integer>> childs; // dfs spanning tree
    private static int[] depth; // dfs spanning tree 내에서의 해당 노드의 깊이 (노드 중복 체크 및 Back edge 여부 판별에 사용)
    private static int[] innerBE; // innerBE[i] : i를 루트로 하는 서브 스패닝 트리의 노드만을 포함하는 Back Edge 수
    private static int[] parentBE; // parentBE[i] : i를 루트로 하는 서브 스패닝 트리 안의 노드가 출발지이고 i의 부모 노드가 목적지인 Back Edge 수
    private static int[] partialBE; // partialBE[i] : i를 루트로 하는 서브 스패닝 트리 안의 노드가 하나라도 포함된 Back Edge 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        // 인접리스트 초기화
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        // depth 초기화, depth[1] ~ depth[N] 까지 사용
        depth = new int[N + 1];
        depth[1] = 1;

        // childs 초기화
        childs = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            childs.add(new ArrayList<>());
        }

        // innerBE, parentBE, partialBE 초기화
        innerBE = new int[N + 1];
        parentBE = new int[N + 1];
        partialBE = new int[N + 1];

        // dfs spanning tree를 만들면서 innerBE, parentBE, partialBE를 채운다.
        dfs(1, 0);

        long answer = 0;

        // i 노드를 없앴을 때 cycle 형성을 막을 수 있는지 체크
        for (int i = 1; i <= N; i++) {
            // N개의 노드로 트리를 구성할 경우, N - 1 개의 엣지가 필요하므로 M - (N - 1) 만큼의 Back Edge 가 존재
            // 해당 Back Edge가 i를 제거하면 모두 사라져야 한다.
            if(M - (N - 1) - partialBE[i] != 0){
                continue;
            }

            // check 1.
            // i 노드의 자식을 루트로 하는 서브 스패닝 트리에서 Back Edge가 존재한다면
            // i 노드를 없앤다고 해도 cycle을 형성한다.
            // check 2.
            // i 노드의 자식을 루트로 하는 서브 스패닝 트리에서
            // i 노드의 선조를 가리키는 Back Edge가 두 개 이상 존재한다면
            // i 노드를 없앤다고 해도 하나의 Back Edge가 다시 tree edge가 되고 다른 하나가 Back Edge가 되기 때문에 cycle을 형성한다.
            boolean cycle = false;
            for(int child : childs.get(i)){
                if(innerBE[child] != 0 || partialBE[child] - parentBE[child] > 1){
                    cycle = true;
                    break;
                }
            }
            if(!cycle){
                answer += i;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int node, int parent){
        for(int child : adjList.get(node)){
            if(child == parent){
                continue;
            }
            if(depth[child] == 0){ // tree edge (dfs spanning tree에 사용될 엣지)
                depth[child] = depth[node] + 1;
                int tmp = innerBE[node]; // 이후 parentBE[child] 측정을 위함
                childs.get(node).add(child);
                dfs(child, node);
                parentBE[child] = innerBE[node] - tmp; // child를 루트로 하는 서브 스패닝 트리의 노드에서 node(=child의 parent) 를 가리키는 Back Edge 수
                innerBE[node] += innerBE[child];
                partialBE[node] += partialBE[child];
            }else if(depth[child] < depth[node]){ // back edge
                // 조건을 넣은 이유는 자손 노드 -> 선조 노드 방향 체크를 위함
                // depth가 낮은 노드(선조 노드)에서 depth가 높은 노드(자손 노드)쪽으로 엣지 수 추가를 막기 위한 용도
                innerBE[child]++;
                partialBE[node]++;
            }
        }
    }
}
