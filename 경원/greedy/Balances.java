package programmers.exercise.greedy;

import java.util.Arrays;

public class Balances {
    public static void main(String[] args) {
//        int[] weight = {3, 1, 6, 2, 7, 30, 1}; // 21
//        int[] weight = {3, 4, 5}; // 1
//        int[] weight = {1, 1, 3}; // 6
        int[] weight = {1, 1, 2, 5, 11, 21};
        System.out.println(solution(weight));
    }

    public static int solution(int[] weight) {
        int answer = 0;

        Arrays.sort(weight);
        long[] partialSum = new long[weight.length];
        partialSum[0] = weight[0];
        for (int i = 1; i < weight.length; i++) {
            partialSum[i] = partialSum[i - 1] + weight[i];
        }

        int num = 1;
        while(num <= partialSum[weight.length - 1]){
            boolean isPossible = false;
            if(Arrays.binarySearch(weight, num) < 0){
                int index = 0;
                for (int i = 0; i < partialSum.length; i++) {
                    if(num <= partialSum[i]){
                        index = Math.max(index, i);
                        break;
                    }
                }
                int bitmask = (1 << (index + 1)) - 1;
                for (int i = bitmask; i > 0; i--) {
                    int sum = findSumWithSubset(weight, 0, index, i);
                    if(num == sum){
                        isPossible = true;
                        break;
                    }
                }
            }else{
                isPossible = true;
            }
            if(!isPossible){
                answer = num;
                break;
            }
            num++;
        }

        if(answer == 0){
            answer = (int) partialSum[weight.length - 1] + 1;
        }

        return answer;
    }

    private static int findSumWithSubset(int[] weight, int start, int end, int bitmask) {
        int sum = 0;
        int compare = 1;
        int index = 0;
        while(compare <= bitmask){
            if((compare & bitmask) == compare){
                sum += weight[start + index];
            }
            index++;
            compare = (compare << 1);
        }
        return sum;
    }
}
