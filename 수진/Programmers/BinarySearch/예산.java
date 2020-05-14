import java.util.*;

class Solution {
    public int solution(int[] budgets, int M) {

        long sum = 0; //총합
        int min = 0; //최솟값
        int max = 0; //최댓값
        int mid = 0; //중간값
        int premid = 0; //중간비교값
        
        Arrays.sort(budgets);
        max = budgets[budgets.length-1];
        //min = budgets[0];
        
        for(int i : budgets){
            sum += i;
        }
        
        //총합이 예산보다 적으면 최댓값이 상한.
        if(sum < M)
            return max;
        
        //총합이 예산보다 클 때, 이분탐색.
        else{
            while(true){
                sum = 0;
                mid = (min + max) / 2;

                if(premid == mid){
                    return mid;
                }
                
                for(int i : budgets){
                    if(i > mid)
                        sum += mid;
                    else
                        sum += i;
                }
                if(sum > M)
                    max = mid;
                else
                    min = mid;
                
                premid = mid;
            }
        }

    }
}