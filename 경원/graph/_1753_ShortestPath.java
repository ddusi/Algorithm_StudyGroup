package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1753_ShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int start = Integer.parseInt(br.readLine());

        // 인접리스트: adjacencyList.get(u)은 VertexDistance(노드 u에서 연결된 다른 노드와 그 가중치)의 ArrayList이다.
        ArrayList<ArrayList<VertexDistance>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            ArrayList<VertexDistance> adjacency = new ArrayList<>();
            adjacencyList.add(adjacency);
        }

        // 경로 별 여러 개의 간선이 존재할 수 있으므로, 그 중 최솟값만을 남기기 위한 map
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < E; i++) {
            String[] strArr = br.readLine().split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);
            int w = Integer.parseInt(strArr[2]);
            if(map.containsKey(u)){
                if(map.get(u).containsKey(v)){
                    if(map.get(u).get(v) > w){
                        map.get(u).put(v, w);
                    }
                }else{
                    map.get(u).put(v, w);
                }
            }else{
                Map<Integer, Integer> tmp = new HashMap<>();
                tmp.put(v, w);
                map.put(u, tmp);
            }
        }

        // map을 기반으로 경로를 인접리스트에 넣는다.
        for(int vertex1 : map.keySet()){
            for(int vertex2 : map.get(vertex1).keySet()){
                adjacencyList.get(vertex1).add(new VertexDistance(vertex2, map.get(vertex1).get(vertex2)));
            }
        }

        // dist의 최솟값을 찾기 위한 우선순위 큐
        PriorityQueue<VertexDistance> queue = new PriorityQueue<>();
        // 우선순위큐 초기화 (시작노드는 dist 0, 나머지는 최대)
        for (int i = 1; i <= V; i++) {
            VertexDistance vd = null;
            if(i == start){
                vd = new VertexDistance(i, 0);
            }else{
                vd = new VertexDistance(i, 987654321);
            }
            queue.offer(vd);
        }

        // start 노드에서의 최소 가중치를 저장하기 위한 용도
        int[] dist = new int[V + 1];
        // dist 배열 초기화
        for (int i = 1; i <= V; i++) {
            if(i == start){
                dist[i] = 0;
            }else{
                dist[i] = 987654321;
            }
        }

        // start로부터의 가중치 합이 최소인 노드를 찾아 해당 노드에 연결된 간선을 체크
        while(!queue.isEmpty()){
            VertexDistance check = queue.poll();
            if(check.distance == 987654321){
                break;
            }
            for(VertexDistance vd : adjacencyList.get(check.vertex)){
                int renewal = Math.min(dist[check.vertex] + vd.distance, dist[vd.vertex]);
                if(renewal < dist[vd.vertex]){
                    dist[vd.vertex] = renewal;
                    VertexDistance newVd = new VertexDistance(vd.vertex, renewal);
                    queue.offer(newVd);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(dist[i] == 987654321){
                sb.append("INF");
            }else{
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class VertexDistance implements Comparable<VertexDistance> {
        int vertex;
        int distance;
        public VertexDistance(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance o) {
            if(this.distance < o.distance){
                return -1;
            }else if(this.distance == o.distance){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
