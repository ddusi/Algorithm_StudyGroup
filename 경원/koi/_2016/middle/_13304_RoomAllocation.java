package algorithm.baekjoon.koi._2016.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13304_RoomAllocation {
    private static int N, K;
    private static int[] students = new int[5]; // 0: 1~2 전체, 1: 3~4 여자, 2: 3~4 남자, 3: 5~6 여자, 4: 5~6 남자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            int s = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            if(y <= 2){
                students[0]++;
            }else if(y <= 4){
                if(s == 0){
                    students[1]++;
                }else{
                    students[2]++;
                }
            }else{
                if(s == 0){
                    students[3]++;
                }else{
                    students[4]++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += (students[i] / K);
            if(students[i] % K != 0){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
