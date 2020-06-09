package programmers.exercise.graph;

import java.util.*;

public class RemoveCycle {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}};
        System.out.println(solution(n, edges));
    }

    public static int solution(int n, int[][] edges) {
        int answer = 0;

        int[][] edgesPerNode = new int[n][2];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> connection = new ArrayList<>();
            adjacencyList.add(connection);
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 1; i < adjacencyList.size(); i++) {
            edgesPerNode[i - 1][0] = i;
            edgesPerNode[i - 1][1] = adjacencyList.get(i).size();
        }

        Arrays.sort(edgesPerNode, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }else if(o1[1] > o2[1]){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        int breakPointNums = 0;
        for (int i = 0; i < edgesPerNode.length; i++) {
            if(edgesPerNode[i][1] == 0){
                breakPointNums++;
            }else{
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if(edges.length - edgesPerNode[i][1] <= n - 2 - breakPointNums){
//                if(!makeCycle(edgesPerNode[i][0], n, edges)){
//                    answer += edgesPerNode[i][0];
//                }
                // 단절점이 생기는지 체크
                boolean breakPointExist = false;
                for (int j = 0; j < adjacencyList.get(edgesPerNode[i][0]).size(); j++) {
                    if(adjacencyList.get(adjacencyList.get(edgesPerNode[i][0]).get(j)).size() == 1){
                        breakPointExist = true;
                        break;
                    }
                }
                if(!breakPointExist){
                    answer += edgesPerNode[i][0];
                }
            }else{
                break;
            }
        }

//        for (int i = 1; i <= n; i++) {
//            if(edges.length - adjacencyList.get(i).size() > n - 2){
//                continue;
//            }
//            if(!makeCycle(i, n, edges)){
//                answer += i;
//            }
//        }

        return answer;
    }

    /**
     * remove 노드를 제거했을 때 사이클이 형성되는지 확인
     * @param remove
     * @param n
     * @param edges
     * @return
     */
    private static boolean makeCycle(int remove, int n, int[][] edges) {
        int[] root = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0] != remove && edges[i][1] != remove){
                if(!union(edges[i][0], edges[i][1], root, rank)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * x와 y의 root를 찾아 같은 부모를 가지는지 확인 후
     * 같은 부모를 가진다면 false를 리턴, (union할 수 없음)
     * 아니라면 union 후 true를 리턴한다. (union 가능하여 union 수행)
     * @param x
     * @param y
     * @param root
     * @param rank
     * @return
     */
    private static boolean union(int x, int y, int[] root, int[] rank) {
        x = find(x, root);
        y = find(y, root);
        if(x == y){
            return false;
        }
//        if(rank[x] < rank[y]){
//            root[x] = y;
//        }else{
//            root[y] = x;
//            if(rank[x] == rank[y]){
//                rank[x]++;
//            }
//        }
        root[y] = x;
        return true;
    }

    private static int find(int x, int[] root) {
        if(root[x] == x){
            return x;
        }else{
//            return root[x] = find(root[x], root);
            return find(root[x], root);
        }
    }
}
