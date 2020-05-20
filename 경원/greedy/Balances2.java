package programmers.exercise.greedy;

import java.util.Arrays;

public class Balances2 {
    public static void main(String[] args) {
//        int[] weight = {3, 1, 6, 2, 7, 30, 1}; // 21
//        int[] weight = {3, 4, 5}; // 1
//        int[] weight = {1, 1, 3}; // 6
        int[] weight = {1, 1, 2, 5, 11, 21}; // 10
        System.out.println(solution(weight));
    }

    /**
     * (weight의 i 번째 부분합)과 (weight의 i + 1 번째 값)을 비교하여 그 사이에 차이가 1보다 클 경우,
     * (weight의 i 번째 부분합) + 1 ~ (weight의 i + 1 번째 값) - 1 까지는 절대로 만들 수 없는 수가 된다.
     * 즉, 이 때 만들 수 없는 수의 최소는 (weight의 i 번째 부분합) + 1 이 된다.
     *
     * ex. weight가 {1, 1, 2, 5, 11, 21} 일 경우
     *       부분합은  {1, 2, 4,  9, 20, 41} 이 된다.
     * cf. 표기방법: [n, m] = n이상 m 이하의 모든 수, (n, m] = n 초과 m 이하의 모든 수
     * 이 때 부분합의 첫 번째 원소(= 1)와 이후 추가될 weight의 두 번째 원소(= 1)은 차이가 없다. -> [1, 1]까지는 만들 수 있는 수가 된다.
     * 부분합의 두 번째 원소(= 2)와 이후 추가될 weight의 세 번째 원소(= 2) 또한 차이가 없다. -> (1, 2]까지는 만들 수 있는 수가 된다.
     * 부분합의 세 번째 원소(= 4)와 이후 추가될 weight의 네 번째 원소(= 5)는 1 차이가 난다. -> (2, 5]까지는 만들 수 있는 수가 된다.
     * 부분합의 네 번째 원소(= 9)와 이후 추가될 weight의 다섯 번째 원소(= 11)는 2 차이가 난다. -> (5, 9]까지는 만들 수 있으나, 10은 절대로 만들 수 없다.
     * @param weight
     * @return
     */
    public static int solution(int[] weight) {
        int answer = 0;

        Arrays.sort(weight);

        // 정렬된 배열의 첫 번째 값이 1이 아닐 경우, 양의 정수 1은 절대로 만들 수 없다.
        if (weight[0] != 1) {
            return 1;
        }

        long[] partialSum = new long[weight.length];
        partialSum[0] = weight[0];
        for (int i = 1; i < weight.length; i++) {
            partialSum[i] = partialSum[i - 1] + weight[i];
        }

        for (int i = 0; i < weight.length - 1; i++) {
            if(partialSum[i] + 1 < weight[i + 1]){
                answer = (int) partialSum[i] + 1;
                break;
            }
        }

        // answer가 0일 경우 weight의 모든 값의 합까지 모두 만들 수 있다는 의미이며,
        // 이 경우 합보다 1이 큰 수가 만들 수 없는 양의 정수 중 최솟값이 된다.
        if(answer == 0){
            answer = (int) partialSum[weight.length - 1] + 1;
        }

        return answer;
    }
}
