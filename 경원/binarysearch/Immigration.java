package programmers.exercise.binarysearch;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
//        int n = 6;
//        int[] times = {7, 10};
//        int[] times = {6, 10};
//        int[] times = {6, 6, 6, 6};
        int n = 15;
        int[] times = {1, 2, 3, 3, 4, 100};
        System.out.println(solution(n, times));
    }

    /**
     * 심사대 하나에 여러 명이 올 경우, 그 여러 명 사이에 쉬는 시간은 없어야 한다.
     *
     * 만약 모든 심사대 중 가장 나중에 끝나는 (최대값인) 시간에 대해,
     * 각 심사대 별로 얼마만큼의 인원을 받을 수 있는지 계산 가능하다.
     * ex. n = 6, times = {6, 10} 의 경우
     *  1. 6명이 모두 1번 심사대에서 심사를 받을 때 시간이 최대로 걸린다. (60 분)
     *     하나의 심사대에서 심사를 받을 때 최소 1분 이상 걸리므로, 최소 1분과 최대 60분 사이에서 이분탐색을 통해
     *     각 시간 별 몇 명까지 심사를 받을 수 있는지 계산하여 다음 시간을 정한다.
     *  2. 중간값인 (1 + 60) / 2 = 30 분에 대해서는, 30 / 6 + 30 / 10 = 8 명까지 심사를 받을 수 있으므로 (8 > 6)
     *     최소 1분, 최대 29분 사이에서 다음 시간을 찾는다. (1 + 29) / 2 = 15
     *  3. 15분에 대해서는, 15 / 6 + 15 / 10 = 3 명까지 심사를 받을 수 있으므로 (3 < 6)
     *     최소 16분, 최대 29분 사이에서 다음 시간을 찾는다. (16 + 29) / 2 = 22
     *  4. 22분에 대해서는, 22 / 6 + 22 / 10 = 5 명까지 심사를 받을 수 있으므로 (5 < 6)
     *     최소 23분, 최대 29분 사이에서 다음 시간을 찾는다. (23 + 29) / 2 = 26
     *  6. 26분에 대해서는, 26 / 6 + 26 / 10 = 6 명까지 심사를 받을 수 있으므로 여기에서 멈춘다.
     *
     *  이후 26분보다 차례로 내려가며 더 짧은 시간에 6명이 심사를 받을 수 있는지를 체크한다.
     *  25분의 경우, 25 / 6 + 25 / 10 = 6
     *  24분의 경우, 24 / 6 + 24 / 10 = 6
     *  23분의 경우, 23 / 6 + 24 / 10 = 5
     *  이므로 24분이 최소 시간이 된다.
     *
     * @param n
     * @param times
     * @return
     */
    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long min = 1;
        long max = (long) n * times[times.length - 1];
        long mid = 0;

        long possibleNums = 0;
        while(min <= max){
            possibleNums = 0;
            mid = (min + max) / 2l;
            for (int i = 0; i < times.length; i++) {
                possibleNums += (mid / times[i]);
            }
            if(possibleNums > n){
                max = mid - 1;
            }else if(possibleNums < n){
                min = mid + 1;
            }else{
                break;
            }
        }

        answer = mid;
        if(possibleNums >= n){
            while(possibleNums >= n){
                possibleNums = 0;
                mid--;
                for (int i = 0; i < times.length; i++) {
                    possibleNums += (mid / times[i]);
                }
                if(possibleNums < n){
                    answer = mid + 1;
                    break;
                }
            }
        }else{
            while(possibleNums < n){
                possibleNums = 0;
                mid++;
                for (int i = 0; i < times.length; i++) {
                    possibleNums += (mid / times[i]);
                }
                if(possibleNums >= n){
                    answer = mid;
                    break;
                }
            }
        }

        return answer;
    }
}
