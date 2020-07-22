package algorithm.baekjoon.koi._2018.high;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _15975_DrawArrow {
    private static int N;
    private static Point[] points;
    private static Map<Integer, Point> colorToX;
    private static int[] left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            Point point = new Point(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), i);
            points[i] = point;
        }

        Arrays.sort(points);

        left = new int[N];
        right = new int[N];

        // 초기화
        for (int i = 0; i < N; i++) {
            left[i] = Integer.MAX_VALUE;
            right[i] = Integer.MAX_VALUE;
        }

        // color to Point mapping
        colorToX = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if(colorToX.containsKey(points[i].color)){
                Point nearestPoint = colorToX.get(points[i].color);
                right[nearestPoint.i] = Math.abs(points[i].x - nearestPoint.x);
            }
            colorToX.put(points[i].color, points[i]);
        }

        colorToX = new HashMap<>();
        for (int i = N - 1; i >= 0; i--) {
            if(colorToX.containsKey(points[i].color)){
                Point nearestPoint = colorToX.get(points[i].color);
                left[nearestPoint.i] = Math.abs(points[i].x - nearestPoint.x);
            }
            colorToX.put(points[i].color, points[i]);
        }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            if(left[i] != Integer.MAX_VALUE || right[i] != Integer.MAX_VALUE){
                answer += Math.min(left[i], right[i]);
            }
        }
        System.out.println(answer);
    }

    private static class Point implements Comparable<Point>{
        int x;
        int color;
        int i;
        public Point(int x, int color, int i){
            this.x = x;
            this.color = color;
            this.i = i;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x < o.x){
                return -1;
            }else if(this.x == o.x){
                return 0;
            }else{
                return 1;
            }
        }

    }
}
