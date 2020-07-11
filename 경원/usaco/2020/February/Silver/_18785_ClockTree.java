package algorithm.baekjoon.usaco._2020.February.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _18785_ClockTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] clock = new int[N + 1];

        // room 별 시간 채우기
        String[] clocks = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            clock[i] = Integer.parseInt(clocks[i - 1]);
        }

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        // 인접리스트 초기화
        for (int i = 0; i <= N; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            adjacencyList.add(tmp);
        }

        // 인접리스트 채우기
        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        // 1번째 room을 기준으로 모든 room까지의 거리를 기록
        int[] distances = new int[N + 1];
        dfs(1, 0, 0, distances, adjacencyList);

        int evenSum = 0;
        int evenCount = 0;
        int oddSum = 0;
        int oddCount = 0;
        for (int i = 1; i <= N; i++) {
            if(distances[i] % 2 == 0){
                evenSum += clock[i];
                evenCount++;
            }else{
                oddSum += clock[i];
                oddCount++;
            }
        }

        if(evenSum % 12 == oddSum % 12){
            System.out.println(N);
        }else if(evenSum % 12 == (oddSum + 1) % 12) {
            System.out.println(evenCount);
        }else if((evenSum + 1) % 12 == oddSum % 12){
            System.out.println(oddCount);
        }else{
            System.out.println(0);
        }
    }

    private static void dfs(int start, int distance, int parent, int[] distances, ArrayList<ArrayList<Integer>> adjacencyList) {
        distances[start] = distance;
        for(int room : adjacencyList.get(start)){
            if(room != parent){ // 왔던 길 다시 못 가게 하는 용도
                dfs(room, distance + 1, start, distances, adjacencyList);
            }
        }
    }
}
