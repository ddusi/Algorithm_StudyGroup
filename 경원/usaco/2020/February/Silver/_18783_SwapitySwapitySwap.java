package algorithm.baekjoon.usaco._2020.February.silver;

import java.io.*;
import java.util.*;

public class _18783_SwapitySwapitySwap {
    private static int N, M, K;
    private static int[][] LR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);
        LR = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] lr = br.readLine().split(" ");
            LR[i][0] = Integer.parseInt(lr[0]) - 1;
            LR[i][1] = Integer.parseInt(lr[1]) - 1;
        }

        // M번 연산했을 때, 각 인덱스가 어떤 인덱스로 매핑되는지에 대한 결과
        int[] mapping = new int[N];
        for (int i = 0; i < N; i++) {
            int nextIndex = i;
            for (int j = 0; j < M; j++) {
                int tmp = transformation(nextIndex, LR[j][0], LR[j][1]);
                if(tmp != -1){
                    nextIndex = tmp;
                }
            }
            mapping[i] = nextIndex;
        }

        // M 연산을 여러 번 돌렸을 때 나오는 수의 인덱스 모음의 리스트
        ArrayList<ArrayList<Integer>> setList = new ArrayList<>();
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            int start = mapping[i];
            ArrayList<Integer> set = new ArrayList<>();
            set.add(i);
            while(start != i){
                visit[start] = true;
                set.add(start);
                start = mapping[start];
            }
            setList.add(set);
        }

        // M 연산을 K번 돌렸을 때 각 인덱스가 어떤 인덱스로 매핑되는지에 대한 결과
        int[] kMapping = new int[N];
        for(ArrayList<Integer> set : setList){
            for (int i = 0; i < set.size(); i++) {
                kMapping[set.get(i)] = set.get((i + K) % set.size());
            }
        }

        // 최종 결과
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // 숫자가 1부터 시작하므로 i + 1을 넣어주어야 한다.
            result[kMapping[i]] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int transformation(int index, int L, int R){
        if(index < L || index > R){
            return -1;
        }
        return R - (index - L);
    }
}
