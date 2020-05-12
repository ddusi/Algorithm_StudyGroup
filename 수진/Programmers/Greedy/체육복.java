import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0; //수업을 들을 수 있는 학생 수(최종 반환값)
        
        List<Integer> lostList = new ArrayList<>(); //도난당한 학생 리스트
        for(int i : lost)
            lostList.add(i);
        
        List<Integer> reserveList = new ArrayList<>(); //여벌을 가져온 학생 리스트
        for(int i : reserve)
            reserveList.add(i);
        
        
        //1. 전체 학생 - 도난당한 학생 수
        answer = n - lostList.size();
        
        //2. + 여벌을 가져왔는데 도둑맞은 학생 수        
        for(int i = 0; i < lostList.size(); i++){
            for(int j = 0; j < reserveList.size(); j++){
                if(lostList.get(i) == reserveList.get(j)){
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    answer ++;
                    break;
                }
            }
        }      
        
        //3. + 여벌을 빌려줄 수 있는 학생 수
        for(int i = 0; i < lostList.size(); i++){
            int lostNum = lostList.get(i);
            for(int j = 0; j < reserveList.size(); j++){
                int reserveNum = reserveList.get(j);

                if(lostNum == reserveNum - 1 || lostNum == reserveNum + 1){
                    reserveList.remove(j);
                    answer ++;
                    break;
                }
            }
        }
        
        return answer;
    }
}