package programmers.exercise.dynamicprogramming;

public class TileDecoration {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(solution(N));
    }

    public static long solution(int N){
        long[] longSides = new long[N];
        longSides[0] = 1;
        longSides[1] = 2;

        for (int i = 2; i < N; i++) {
            longSides[i] = longSides[i - 1] + longSides[i - 2];
        }

        return longSides[N - 1] * 2 + longSides[N - 2] * 2;
    }
}
