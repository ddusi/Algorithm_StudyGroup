package algorithm.baekjoon.koi._2018.high;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _15976_XCorr {
    private static int N, M;
    private static int[] xIndex, yIndex, x, y;
    private static long[] psx;
    private static int n = 0;
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;

        N = Integer.parseInt(br.readLine());
        x = new int[N];
        xIndex = new int[N];
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            int index = Integer.parseInt(strArr[0]);
            int num = Integer.parseInt(strArr[1]);
            xIndex[i] = index;
            x[i] = num;
        }
        n = Math.max(n, xIndex[N - 1]);

        M = Integer.parseInt(br.readLine());
        y = new int[M];
        yIndex = new int[M];
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int index = Integer.parseInt(strArr[0]);
            int num = Integer.parseInt(strArr[1]);
            yIndex[i] = index;
            y[i] = num;
        }
        n = Math.max(n, yIndex[M - 1]);

        // n이 현재 index후보군 중 최대이므로, 길이는 index보다 1 크다.
        n++;

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        // partial sum x를 채운다.
        psx = new long[N];
        psx[0] = x[0];
        for (int i = 1; i < N; i++) {
            psx[i] = ((long) x[i]) + psx[i - 1];
        }

        // b가 n 이상일 경우, 연산이 없는 경우가 생기므로 이런 케이스를 제외한다.
        if(b >= n){
            b = n - 1;
        }

        // a가 -n 이하일 경우, 연산이 없는 경우가 생기므로 이런 케이스를 제외한다.
        if(a <= -n){
            a = -n + 1;
        }

        if(a > b){
            System.out.println(0);
            return;
        }

        // y의 각 원소 별로 순회하며 a <= t <= b 만큼의 t에서 x의 partial sum 중 해당하는 것과 곱해서 더해준다.
        for (int i = M - 1; i >= 0; i--) {
            long yNum = y[i];
            int xEnd = yIndex[i] - a;
            int xStart = yIndex[i] - b - 1;
            if (xStart >= xEnd) {
                continue;
            }
            int partialSumForEnd = Arrays.binarySearch(xIndex, xEnd);
            if (partialSumForEnd < 0) {
                partialSumForEnd = Math.abs(partialSumForEnd) - 2;
            }
            int partialSumForStart = Arrays.binarySearch(xIndex, xStart);
            if (partialSumForStart < 0) {
                partialSumForStart = Math.abs(partialSumForStart) - 2;
            }

            answer += (yNum * (((partialSumForEnd == -1)? 0 : psx[partialSumForEnd]) - ((partialSumForStart == -1)? 0 : psx[partialSumForStart])));
        }

        System.out.println(answer);
    }
}
