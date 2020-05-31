package programmers.exercise.fullsearch;

import java.util.*;

public class FindPrimeNumber2 {
    public static void main(String[] args) {
//        String numbers = "13579";
//        String numbers = "137";
//        String numbers = "1234";
//        String numbers = "1111";
//        String numbers = "7843";
//        String numbers = "1231";
        String numbers = "0101";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        char[] chArr = numbers.toCharArray();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            nums.add(Integer.parseInt(String.valueOf(chArr[i])));
        }
        ArrayList<Integer> permutation = null;
        boolean[] checklist = null;

        Set<Integer> numSet = new HashSet<>();

        for (int i = 1; i <= nums.size(); i++) {
            permutation = new ArrayList<>();
            checklist = new boolean[nums.size()];
            addAllCombination(nums, numSet, permutation, checklist, i);
        }

        Iterator<Integer> iter = numSet.iterator();
        while(iter.hasNext()){
            if(isPrime(iter.next())){
                answer++;
            }
        }

        return answer;
    }

    private static void addAllCombination(ArrayList<Integer> nums, Set<Integer> numSet, ArrayList<Integer> permutation, boolean[] checklist, int r) {
        if(permutation.size() == r){
            StringBuilder sb = new StringBuilder();
            for (int each : permutation) {
                sb.append(each);
            }
            numSet.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if(!checklist[i]){
                checklist[i] = true;
                permutation.add(nums.get(i));
                addAllCombination(nums, numSet, permutation, checklist, r);
                permutation.remove(permutation.size() - 1);
                checklist[i] = false;
            }
        }
    }

    private static boolean isPrime(int num){
        if(num == 2){
            return true;
        }
        if(num == 0 || num == 1 || num % 2 == 0){
            return false;
        }
        int sqrt = (int) Math.sqrt(num) + 1;
        if(num % sqrt == 0){
            return false;
        }
        for (int i = 3; i <= sqrt; i += 2) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
