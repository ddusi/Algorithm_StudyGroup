package algorithm.baekjoon.usaco._2019.December.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _18267_MilkVisits2 {
    private static int N = 0;
    private static int M = 0;
    private static char[] milk = null;
    private static int[] components = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        milk = new char[N + 1];
        int index = 1;
        for (char ch : br.readLine().toCharArray()){
            milk[index++] = ch;
        }

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        components = new int[N + 1];
        int component = 1;
        for (int i = 1; i <= N; i++) {
            dfs(component, i, adjacencyList);
            component++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            if(components[start] != components[end] || String.valueOf(milk[start]).equals(strArr[2])){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int component, int farm, ArrayList<ArrayList<Integer>> adjacencyList) {
        if(components[farm] != 0){
            return;
        }
        components[farm] = component;
        for(int adjancentFarm : adjacencyList.get(farm)){
            if(milk[adjancentFarm] == milk[farm]){
                dfs(component, adjancentFarm, adjacencyList);
            }
        }
    }
}
