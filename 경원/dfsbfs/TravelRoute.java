package programmers.exercise.dfsbfs;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "ATL"}, {"ICN", "ATL"}, {"ATL", "ICN"}, {"ATL", "ICN"}};
        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        String[] answer = solution(tickets);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static String[] solution(String[][] tickets) {
        int n = tickets.length;
        // 티켓의 도착지를 알파벳 순서로 정렬한다.
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return compareString(o1[1], o2[1]);
            }
        });

        // 경로를 기록하기 위한 용도로 사용한다.
        // stack 구조를 사용하는 이유는 dfs로 경로를 찾아가면서 잘못된 경로일 경우 올바른 경로를 찾을 때까지 뒤에서부터 경로를 빼 주어야 하기 때문
        Stack<String> stack = new Stack<>();
        String airportName = "ICN";
        stack.push(airportName);

        // 경로의 총 수가 티켓 전체 수가 될때까지 dfs를 돌려 정답을 찾는다.
        dfs(airportName, tickets, new boolean[n], 0, n, stack);

        String[] answer = new String[stack.size()];
        int index = stack.size();
        // 경로가 스택 구조에 저장되어 있기 때문에 answer의 뒷 인덱스부터 채워나간다.
        while(!stack.isEmpty()){
            answer[--index] = stack.pop();
        }

        return answer;
    }

    /**
     * 현재 airportName 이름의 출발지 기준으로 알파벳 순서대로 도착지에 대해 dfs를 돌린다.
     * 모든 티켓을 사용해야 하므로 현재 경로의 길이 (length)가 티켓 갯수 (total)보다 작을 경우 잘못된 경로로 생각하고 false를 리턴한다.
     * @param airportName
     * @param tickets
     * @param check
     * @param length
     * @param total
     * @param stack
     * @return
     */
    private static boolean dfs(String airportName, String[][] tickets, boolean[] check, int length, int total, Stack<String> stack){
        if(length == total){
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if(!check[i] && airportName.equals(tickets[i][0])){
                check[i] = true;
                stack.push(tickets[i][1]);
                if(dfs(tickets[i][1], tickets, check, length + 1, total, stack)){
                    return true;
                }
                check[i] = false;
                stack.pop();
            }
        }
        return false;
    }

    private static int compareString(String str1, String str2){
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            if(chArr1[i] < chArr2[i]){
                return -1;
            }else if(chArr1[i] > chArr2[i]){
                return 1;
            }
        }
        return 0;
    }
}
