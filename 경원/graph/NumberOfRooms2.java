package programmers.exercise.graph;

import java.util.*;

public class NumberOfRooms2 {
    public static void main(String[] args) {
//        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
//        int[] arrows = {6, 4, 6, 0, 1, 2, 4, 2, 4, 4, 6, 6, 0, 3};
//        int[] arrows = {6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0};
//        int[] arrows = {5, 2, 7, 1, 6, 3};
        int[] arrows = {6, 5, 2, 7, 1, 4, 2, 4, 6};
//        int[] arrows = {2, 7, 2, 5, 0};
        System.out.println(solution(arrows));

//        Set<Segment> set = new HashSet<>();
//        Segment s1 = new Segment(new Point(0, 1), new Point(1, 0));
//        Segment s2 = new Segment(new Point(1, 0), new Point(0, 1));
//        set.add(s1);
//        set.add(s2);
//        System.out.println(set.size());
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());

    }

    // 방향에 따른 x, y 좌표 변화량
    private static final int[] xDiff = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] yDiff = {1, 1, 0, -1, -1, -1, 0, 1};

    public static int solution(int[] arrows) {
        int verticesNum = 0; // vertices 갯수
        int edgesNum = 0; // edges 갯수

        Set<Point> points = new HashSet<>();
        Set<Segment> edges = new HashSet<>();
        Point prev = new Point(0, 0);
        points.add(prev);
        for (int i = 0; i < arrows.length; i++) {
            // x자 형태로 간선이 겹칠 경우를 위해 2배 늘린다. (이럴 경우 자연스럽게 겹치는 점도 vertex에 포함됨)
            for (int j = 0; j < 2; j++) {
                Point present = new Point(prev.x + xDiff[arrows[i]], prev.y + yDiff[arrows[i]]);
                points.add(present);
                edges.add(new Segment(prev, present));
                prev = present;
            }
        }

        verticesNum += points.size();

        edgesNum += edges.size();

        // 오일러 정리 (평면에서는 V - E + F = 1)
        return 1 - verticesNum + edgesNum;
    }

    // 선분 클래스
    private static class Segment{
        Point p1;
        Point p2;
        public Segment(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Segment segment = (Segment) o;
            return (this.p1.equals(segment.p1) && this.p2.equals(segment.p2)) || (this.p1.equals(segment.p2) && this.p1.equals(segment.p2));
        }

        @Override
        public int hashCode(){
            return Objects.hash(p1, p2) + Objects.hash(p2, p1);
        }
    }

    // 점 클래스
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Point coordinate = (Point) o;

            return this.x == coordinate.x && this.y == coordinate.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
}
