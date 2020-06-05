package programmers.exercise.binarysearch;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
//        int[] budgets = {120, 110, 140, 150};
//        int M = 485;
//        int[] budgets = {145};
//        int M = 130;
        int[] budgets = {145, 145, 32, 145};
        int M = 132;
        System.out.println(solution(budgets, M));
    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;

        // 오름차순 정렬
        Arrays.sort(budgets);

        // 전체 숫자의 합을 넣을 변수
        // long 선언 이유: budgets의 크기가 최대 100,000, 각 원소의 크기가 100,000이므로 가능한 합이 최대 10,000,000,000으로 int 범위를 넘어선다.
        long sum = 0;
        int max = budgets[budgets.length - 1];
        // 부분합 저장할 변수 (cumulativeSum[i]: budgets[0] ~ budgets[i] 까지의 합)
        // 추후 로직에서 사용
        long[] cumulativeSum = new long[budgets.length];
        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
            cumulativeSum[i] = sum;
        }

        // 모든 요청이 배정될 수 있을 경우
        if(sum <= M){
            return max;
        }

        int avg = M / budgets.length;
        // 상한액을 avg부터 시작하여 하나씩 올려나간다. 상한액 별 총합이 M보다 작으면서 최대가 될 때를 찾는다.
        for (int i = avg; i <= M; i++) {
            // 상한액 보다 작거나 같은 값을 가지는 budgets 원소 인덱스 중 최대값을 찾는다.
            int index = binarySearch(budgets, i, 0, budgets.length - 1);
            int tmpSum = 0;
            // 인덱스가 index 이하인 budgets 원소들의 경우 요청한 금액을 그대로 배정 가능
            if(index >= 0){
                tmpSum += cumulativeSum[index];
            }
            // 인덱스가 index 보다 큰 budgets 원소들의 경우 요청한 금액을 상한선인 i까지 밖에 배정하지 못함
            tmpSum += (i * (budgets.length - 1 - index));
            // tmpSum이 M보다 클 경우 이전 상한액이 정답이다.
            if(tmpSum > M){
                answer = i - 1;
                break;
            }
        }

        // 상한액 지정이 되지 않았을 경우 위의 for문을 모두 통과했다는 의미이므로 상한액을 M으로 지정한다.
        if(answer == 0){
            return M;
        }

        return answer;
    }

    /**
     * 정렬되어 있는 arr에서 target 보다 작거나 같은 값을 가지는 element의 인덱스 중 최대값을 리턴한다.
     * [1, 2, 4, 5], target:3 일 경우 index 1 리턴
     * [1, 2, 4, 5], target:2 일 경우 index 1 리턴
     * [3, 5, 6, 7], target:2 일 경우 index -1 리턴
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int binarySearch(int[] arr, int target, int start, int end){
        if(start >= end){
            if(arr[start] <= target){
                return start;
            }else{
                return start - 1;
            }
        }
        int mid = (start + end) / 2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(arr, target, start, mid - 1);
        }else{
            return binarySearch(arr, target, mid + 1, end);
        }
    }
}
