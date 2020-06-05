package programmers.exercise.fullsearch;

public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = solution(brown, yellow);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int rowColSum = (brown + 4) / 2;

        for (int i = rowColSum - 1; i >= 1; i--) {
            if(i * (rowColSum - i) - brown == yellow){
                answer[0] = i;
                answer[1] = rowColSum - i;
                break;
            }
        }

        return answer;
    }
}
