import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //무게 순으로 정렬
        Arrays.sort(people);
        
        int smallIdx = 0; //최소 몸무게 사람의 인덱스       
        int bigIdx = people.length - 1; //최대 몸무게 사람의 인덱스
        
        //아직 안 탄 사람들 중, 두 사람 몸무게의 합이 limit를 넘는지 확인
        while(smallIdx <= bigIdx){
            if(people[smallIdx] + people[bigIdx] <= limit){
                smallIdx ++;
            }
            bigIdx --;
            answer ++;
        }
        
        return answer;
    }
}