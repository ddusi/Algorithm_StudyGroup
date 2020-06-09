package programmers.exercise.dynamicprogramming;

public class PathToSchool {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
//        int[][] puddles = {{2, 2}};
        int[][] puddles = {{4, 2}, {3, 3}};
        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles){
        int[][] paths = new int[501][501];

        for (int i = 0; i < puddles.length; i++) {
            paths[puddles[i][1]][puddles[i][0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            if(paths[i][1] == -1){
                break;
            }else{
                paths[i][1] = 1;
            }
        }

        for (int i = 1; i <= m; i++) {
            if(paths[1][i] == -1){
                break;
            }else{
                paths[1][i] = 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if(paths[i][j] == -1){
                    continue;
                }
                int left = paths[i - 1][j];
                int up = paths[i][j - 1];
                if(left == -1 && up != -1){
                    paths[i][j] = up;
                }else if(left != -1 && up == -1){
                    paths[i][j] = left;
                }else if(left != -1 && up != -1){
                    paths[i][j] = (left + up) % 1000000007;
                }
            }
        }

        return paths[n][m] % 1000000007;
    }
}
