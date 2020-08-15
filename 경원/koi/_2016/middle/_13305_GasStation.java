package algorithm.baekjoon.koi._2016.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _13305_GasStation {
    private static int N;
    private static long[] distanceSum; // distanceSum[i] : 왼쪽 주유소부터 i 번째 주유소까지 거리합
    private static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distanceSum = new long[N];
        cities = new int[N];
        String[] strArr = br.readLine().split(" ");
        for (int i = 1; i < N; i++) { // 0번째 (맨 왼쪽) 주유소부터 자기 자신까지의 거리합은 0
            distanceSum[i] = distanceSum[i - 1] + Integer.parseInt(strArr[i - 1]);
        }
        strArr = br.readLine().split(" ");
        int minPrice = 0;
        for (int i = 0; i < N - 1; i++) { // 마지막 주유소의 리터 당 가격은 의미 없음
            cities[i] = Integer.parseInt(strArr[i]);
            if(i == 0 || minPrice > cities[i]){
                minPrice = cities[i];
            }
        }

        ArrayList<Integer> indexs = new ArrayList<>(); // 이동하면서 선택할 주유소의 인덱스
        indexs.add(0);

        int prev = cities[0];
        for (int i = 1; i < N - 1; i++) { // 마지막 주유소의 리터 당 가격은 의미 없음
            if(cities[i] < prev){
                indexs.add(i);
                prev = cities[i];
                if(cities[i] == minPrice){
                    break;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < indexs.size(); i++) {
            if(i == indexs.size() - 1){
                answer += cities[indexs.get(i)] * (distanceSum[distanceSum.length - 1] - distanceSum[indexs.get(i)]);
            }else{
                answer += cities[indexs.get(i)] * (distanceSum[indexs.get(i + 1)] - distanceSum[indexs.get(i)]);
            }
        }

        System.out.println(answer);
    }
}
