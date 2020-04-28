package programmers.exercise.heap;

import java.util.PriorityQueue;

public class RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;
//        int stock = 4;
//        int[] dates = {1,2,3,4};
//        int[] supplies = {1,1,1,1};
//        int k = 6;
        // result: 2
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<AbroadFactory> maxHeap = new PriorityQueue<>();

        int index = 0;
        for(int date = 0; date < k; date++){
            if(index < dates.length && date == dates[index]){
                AbroadFactory factory = new AbroadFactory(dates[index], supplies[index]);
                maxHeap.offer(factory);
                index++;
            }
            if(stock == 0){
                stock += maxHeap.poll().supply;
                answer++;
            }
            stock--;
        }

        return answer;
    }

    private static class AbroadFactory implements Comparable<AbroadFactory> {
        public int date;
        public int supply;

        public AbroadFactory(int date, int supply){
            this.date = date;
            this.supply = supply;
        }

        @Override
        public int compareTo(AbroadFactory o) {
            // 내림차순 구현
            if(this.supply < o.supply){
                return 1;
            }else if(this.supply > o.supply){
                return -1;
            }
            return 0;
        }
    }
}
