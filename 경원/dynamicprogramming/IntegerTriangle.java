package programmers.exercise.dynamicprogramming;

public class IntegerTriangle {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] sums = new int[500][500];
        sums[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0){
                    sums[i][j] = sums[i - 1][j] + triangle[i][j];
                }else if(j == triangle[i].length - 1){
                    sums[i][j] = sums[i - 1][j - 1] + triangle[i][j];
                }else{
                    sums[i][j] = Math.max(sums[i - 1][j - 1], sums[i - 1][j]) + triangle[i][j];
                }
            }
        }

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, sums[triangle.length - 1][i]);
        }

        return answer;
    }
}
