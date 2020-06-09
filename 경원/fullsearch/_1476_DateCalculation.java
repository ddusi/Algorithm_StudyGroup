package algorithm.baekjoon.stepwise.bruteforce;

import java.util.Scanner;

public class _1476_DateCalculation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int E = scn.nextInt();
        int S = scn.nextInt();
        int M = scn.nextInt();
        int start = Math.max(E, Math.max(S, M));

        while(true){
            boolean EPossible = ((start - E) % 15 == 0)? true: false;
            boolean SPossible = ((start - S) % 28 == 0)? true: false;
            boolean MPossible = ((start - M) % 19 == 0)? true: false;
            if(EPossible && SPossible && MPossible){
                break;
            }
            start++;
        }

        System.out.println(start);
    }
}
