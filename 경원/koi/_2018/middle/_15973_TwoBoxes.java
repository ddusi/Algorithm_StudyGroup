package algorithm.baekjoon.koi._2018.middle;

import java.util.Scanner;

public class _15973_TwoBoxes {
    private static long[] p = null;
    private static long[] q = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        p = new long[4];
        q = new long[4];
        for (int i = 0; i < 4; i++) {
            p[i] = scn.nextLong();
        }
        scn.nextLine();
        for (int i = 0; i < 4; i++) {
            q[i] = scn.nextLong();
        }

        // p를 q보다 무조건 왼쪽에 있게 만든다.
        if(p[0] > q[0]){
            long[] tmp = p;
            p = q;
            q = tmp;
        }

        // 0, 1, 2, 3
        if(p[2] < q[0]){ // p의 오른쪽 변이 q의 왼쪽 변에 닿지 않는 경우
            System.out.println("NULL");
        }else if(p[2] == q[0]){ // p의 오른쪽 변의 x좌표가 q의 왼쪽 변의 x좌표와 같은 경우
            // 포인트만 닿는 경우
            if(p[3] == q[1] || p[1] == q[3]){
                System.out.println("POINT");
            }else if(p[1] > q[3] || p[3] < q[1]){ // 아예 닿지 않는 경우
                System.out.println("NULL");
            }else{ // 변이 닿는 경우
                System.out.println("LINE");
            }
        }else{ // p의 오른쪽 변이 q의 왼쪽 변보다 오른쪽에 있는 경우
            // p를 q보다 무조건 아래쪽에 있게 만든다.
            if(p[1] > q[1]){
                long[] tmp = p;
                p = q;
                q = tmp;
            }

            // 두 도형이 x축 기준으로는 겹치는 범위에 있으므로, 위아래만 비교하면 된다.
            if(p[3] < q[1]){
                System.out.println("NULL");
            }else if(p[3] == q[1]){
                System.out.println("LINE");
            }else{
                System.out.println("FACE");
            }
        }
    }
}
