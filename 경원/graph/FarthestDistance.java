package programmers.exercise.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class FarthestDistance {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> adjacency = new ArrayList<>();
            adjacencyList.add(adjacency);
        }

        // 그래프 채우기
        for (int i = 0; i < edge.length; i++) {
            adjacencyList.get(edge[i][0]).add(edge[i][1]);
            adjacencyList.get(edge[i][1]).add(edge[i][0]);
        }

        // BFS를 위한 queue
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int level = 1;
        // 레벨 갱신을 위한 노드 갯수 체크
        int[] numsPerFreq = new int[n + 1];
        // numsPerFreq는 각 원소가 0으로 초기화되므로, 레벨 당 노드 갯수를 남기기 위한 용도
        int[] copyOfNumsPerFreq = new int[n + 1];
        numsPerFreq[1] = 1;
        boolean[] check = new boolean[n + 1];
        check[1] = true;

        // BFS
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            // 현재 레벨의 노드가 하나 빼냈으므로
            numsPerFreq[level]--;
            for (int i = 0; i < adjacencyList.get(tmp).size(); i++) {
                if(!check[adjacencyList.get(tmp).get(i)]){
                    check[adjacencyList.get(tmp).get(i)] = true;
                    queue.offer(adjacencyList.get(tmp).get(i));
                    numsPerFreq[level + 1]++;
                    copyOfNumsPerFreq[level + 1]++;
                }
            }
            // 현재 레벨의 노드를 다 체크했을 경우 레벨 갱신
            if(numsPerFreq[level] == 0){
                level++;
            }
        }

        return copyOfNumsPerFreq[level - 1];
    }
}
