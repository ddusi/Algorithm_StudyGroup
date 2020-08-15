package algorithm.baekjoon.koi._2017.middle;

import java.util.Scanner;

public class _14697_RoomAllocation {
    private static int A, B, C, N;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        A = scn.nextInt();
        B = scn.nextInt();
        C = scn.nextInt();
        N = scn.nextInt();
        boolean isPossible = false;
        int shareC = N / C;
        int restC = N % C;
        if(restC == 0){
            isPossible = true;
        }
        if(!isPossible){
            int tmpN1 = N;
            for (int i = shareC; i >= 0; i--) {
                tmpN1 = N - C * i;
                int shareB = tmpN1 / B;
                int restB = tmpN1 % B;
                if(restB == 0){
                    isPossible = true;
                    break;
                }
                int tmpN2 = tmpN1;
                for (int j = shareB; j >= 0; j--) {
                    tmpN2 = tmpN1 - B * j;
                    int restA = tmpN2 % A;
                    if(restA == 0){
                        isPossible = true;
                        break;
                    }
                }
                if(isPossible){
                    break;
                }
            }
        }
        if(isPossible){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
