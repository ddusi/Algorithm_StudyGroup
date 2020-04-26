package programmers.exercise.stackqueue;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution(prices);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length - 1; i++){
            int ans = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] < prices[i]){
                    ans++;
                    answer[i] = ans;
                    break;
                }else{
                    ans++;
                }
            }
            if(ans != 0){
                answer[i] = ans;
            }
        }
        return answer;
    }
}
