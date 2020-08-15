package algorithm.baekjoon.koi._2017.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _14864_LineUp {
    private static int N, M;
    // i 번째 학생보다 뒤에 있는 학생들 중 i 번째 학생의 숫자와 비교했을 때 몇 명보다 큰 지
    private static int[] biggerAfterMe;
    // i 번째 학생보다 앞에 있는 학생들 중 i 번째 학생의 숫자와 비교했을 때 몇 명보다 큰 지
    private static int[] biggerBeforeMe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        biggerAfterMe = new int[N + 1];
        biggerBeforeMe = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            biggerBeforeMe[i] = i - 1;
        }

        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int big = Integer.parseInt(strArr[0]);
            int small = Integer.parseInt(strArr[1]);
            biggerAfterMe[big]++;
            biggerBeforeMe[small]--;
        }

        boolean isPossible = true;
        // 몇 명보다 숫자가 큰 지 to 학생 번호 Map
        Map<Integer, Integer> biggerNumsToPlayer = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if(biggerBeforeMe[i] != 0){
                biggerAfterMe[i] += biggerBeforeMe[i];
            }
            if(biggerNumsToPlayer.containsKey(biggerAfterMe[i])){
                isPossible = false;
                break;
            }
            biggerNumsToPlayer.put(biggerAfterMe[i], i);
        }

        if(!isPossible){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(biggerAfterMe[i] + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
