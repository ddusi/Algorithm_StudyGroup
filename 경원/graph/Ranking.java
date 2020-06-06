package programmers.exercise.graph;

import java.util.ArrayList;

public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(n, result));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;

        // 이긴 사람이 누구를 이겼는지를 나타내는 인접 그래프
        ArrayList<ArrayList<Integer>> winners = new ArrayList<>();
        // 진 사람이 누구에게 졌는지를 나타내는 인접 그래프
        ArrayList<ArrayList<Integer>> losers = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> winner = new ArrayList<>();
            ArrayList<Integer> loser = new ArrayList<>();
            winners.add(winner);
            losers.add(loser);
        }

        // 각 그래프를 경기 결과에 따라 채운다
        for (int i = 0; i < results.length; i++) {
            winners.get(results[i][0]).add(results[i][1]);
            losers.get(results[i][1]).add(results[i][0]);
        }

        // 각 선수 별 그래프 상위의 선수 수
        int[] highNums = new int[n + 1];
        // 각 선수 별 그래프 하위의 선수 수
        int[] lowNums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            boolean[] check = new boolean[n + 1];
            int[] nums = new int[2];
            // nums[0]을 업데이트 (그래프 상에서 내 노드보다 상위에 있는 노드 수)
            findHigh(n, losers, i, check, nums);
            // nums[1]을 업데이트 (그래프 상에서 내 노드보다 하위에 있는 노드 수)
            findLow(n, winners, i, check, nums);
            highNums[i] = nums[0];
            lowNums[i] = nums[1];
        }

        // highNums[i] + lowNums[i] = n - 1 이라면 i번째 선수의 등수를 확인 가능
        for (int i = 1; i <= n; i++) {
            if(highNums[i] + lowNums[i] == n - 1){
                answer++;
            }
        }

        return answer;
    }

    // nums[1]을 업데이트 (그래프 상에서 내 노드보다 하위에 있는 노드 수)
    private static void findLow(int n, ArrayList<ArrayList<Integer>> winners, int people, boolean[] check, int[] nums) {
        for (int i = 0; i < winners.get(people).size(); i++) {
            if(!check[winners.get(people).get(i)]){
                check[winners.get(people).get(i)] = true;
                nums[1]++;
                findLow(n, winners, winners.get(people).get(i), check, nums);
            }
        }
    }

    // nums[0]을 업데이트 (그래프 상에서 내 노드보다 상위에 있는 노드 수)
    private static void findHigh(int n, ArrayList<ArrayList<Integer>> losers, int people, boolean[] check, int[] nums) {
        for (int i = 0; i < losers.get(people).size(); i++) {
            if(!check[losers.get(people).get(i)]){
                check[losers.get(people).get(i)] = true;
                nums[0]++;
                findHigh(n, losers, losers.get(people).get(i), check, nums);
            }
        }
    }
}
