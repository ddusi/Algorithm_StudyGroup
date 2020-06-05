package programmers.exercise.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // 2
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; // 1
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        // 각 컴퓨터가 네트워크 그룹에 속해있는지를 확인하는 용도
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 어떠한 네트워크에 속해있지 않을 경우에만 해당 컴퓨터를 기준으로 bfs를 돌린다.
            if(!check[i]){
                check[i] = true;

                // BFS에 사용할 queue
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    int tmp = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if(j != i && !check[j] && computers[tmp][j] == 1){
                            queue.offer(j);
                            check[j] = true;
                        }
                    }
                }

                // 네트워크 하나가 추가되었으므로 answer를 증가시킨다.
                answer++;
            }
        }

        return answer;
    }
}
