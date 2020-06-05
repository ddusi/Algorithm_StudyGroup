import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> que = new LinkedList<>();

        for(int pri : priorities){
            que.add(pri);
        }
        Arrays.sort(priorities); //우선순위를 비교하기 위해 오름 차순 정렬
        int length = priorities.length-1; //오름차순 한 마지막 요소가 가장 큰 수 

        while(!que.isEmpty()){
            int current = que.poll();

            if(current == priorities[length - answer]){
                answer++;
                location--;
                if(location<0){
                    break;
                }
            }else{
                que.add(current);
                location--;
                if(location<0){
                    location = que.size()-1;
                }
            }
        }
        return answer;
}
}
