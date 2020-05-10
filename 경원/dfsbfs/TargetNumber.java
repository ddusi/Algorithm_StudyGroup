package programmers.exercise.dfsbfs;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    private static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    /**
     * numbers 배열의 모든 숫자를 다 사용하면서 (index == numbers.length),
     * 다 사용했을 때 sum이 target가 동일한지 체크
     *
     * 만약 배열에서 사용할 숫자가 남았다면 다음 숫자를 더하고 빼는 작업을 계속 반복
     * @param index
     * @param sum
     * @param numbers
     * @param target
     */
    private static void dfs(int index, int sum, int[] numbers, int target){
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index], numbers, target);
        dfs(index + 1, sum - numbers[index], numbers, target);
    }

}
