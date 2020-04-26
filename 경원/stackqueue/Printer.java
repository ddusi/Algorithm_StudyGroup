package programmers.exercise.stackqueue;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> priorityQueue = new LinkedList<>();
        for(int priority : priorities){
            queue.offer(priority);
        }
        Arrays.sort(priorities);
        for(int i = priorities.length - 1; i >= 0; i--){
            priorityQueue.offer(priorities[i]);
        }

        int index = location;
        while(!queue.isEmpty()){
            if(queue.peek() == priorityQueue.peek()){
                if(index == 0){
                    answer++;
                    break;
                }else{
                    answer++;
                    queue.poll();
                    priorityQueue.poll();
                    index--;
                }
            }else{
                if(index == 0){
                    index = queue.size() - 1;
                }else{
                    index--;
                }
                queue.offer(queue.poll());
            }
        }
        return answer;
    }
}
