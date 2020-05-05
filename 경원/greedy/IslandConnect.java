package programmers.exercise.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnect {
    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;
        System.out.println(solution(n, costs));
    }

    /**
     * Kruskal MST 알고리즘 사용하여 최소 신장 트리 (MST) 형성
     * 1. 그래프의 간선들을 가중치의 오름차순대로 정렬한다.
     * 2. 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택한다.
     * 3. 해당 간선을 현재의 MST의 집합에 추가한다.
     * @param n
     * @param costs
     * @return
     */
    public static int solution(int n, int[][] costs) {
        int answer = 0;

        // 섬 간 연결 비용 기준으로 costs를 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        // union-find 노드 별 부모 저장 용도
        int[] roots = new int[n];
        // root를 자기자신으로 초기화
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        // cost가 낮은 간선을 선택한다.
        // 단, 사이클을 형성하는 간선은 제외시킨다.
        for (int i = 0; i < costs.length; i++) {
            // 간선의 각 노드 별 루트 체크
            int root1 = findRoot(roots, costs[i][0]);
            int root2 = findRoot(roots, costs[i][1]);
            if(root1 != root2){
                roots[root1] = root2;
                answer += costs[i][2];
            }
        }

        return answer;
    }

    private static int findRoot(int[] roots, int n){
        if(roots[n] == n){
            return n;
        }else{
            // find 로직에 대한 최적화 (path compression)
            return roots[n] = findRoot(roots, roots[n]);
        }
    }
}
