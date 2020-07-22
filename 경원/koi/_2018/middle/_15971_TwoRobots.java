package algorithm.baekjoon.koi._2018.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _15971_TwoRobots {
    private static int N, start, end;
    private static ArrayList<ArrayList<Pair>> adjacencyList = null;
    private static boolean[] visit = null;
    private static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] basicInfo = br.readLine().split(" ");
        N = Integer.parseInt(basicInfo[0]);
        start = Integer.parseInt(basicInfo[1]);
        end = Integer.parseInt(basicInfo[2]);
        adjacencyList = new ArrayList<>();
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            ArrayList<Pair> con = new ArrayList<>();
            adjacencyList.add(con);
        }

        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            int distance = Integer.parseInt(strArr[2]);
            adjacencyList.get(node1).add(new Pair(node2, distance));
            adjacencyList.get(node2).add(new Pair(node1, distance));
        }

        ArrayList<Integer> distances = new ArrayList<>();
        dfs(start, end, distances);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < distances.size(); i++) {
            sum += distances.get(i);
            max = Math.max(max, distances.get(i));
        }

        System.out.println(sum - max);
    }

    private static void dfs(int present, int target, ArrayList<Integer> distances) {
        if(present == target){
            find = true;
            return;
        }
        visit[present] = true;
        for (int i = 0; i < adjacencyList.get(present).size(); i++) {
            if(!visit[adjacencyList.get(present).get(i).node]){
                distances.add(adjacencyList.get(present).get(i).distance);
                visit[adjacencyList.get(present).get(i).node] = true;
                dfs(adjacencyList.get(present).get(i).node, target, distances);
                if(find){
                    break;
                }
                visit[adjacencyList.get(present).get(i).node] = false;
                distances.remove(distances.size() - 1);
            }
        }
    }

    private static class Pair{
        int node;
        int distance;
        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}
