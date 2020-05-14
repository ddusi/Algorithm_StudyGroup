package programmers.exercise.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportsUniform {
    public static void main(String[] args) {
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {1, 3, 5};
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {3};
//        int n = 3;
//        int[] lost = {3};
//        int[] reserve = {1};
//        int n = 5;
//        int[] lost = {1, 2};
//        int[] reserve = {2, 3};
        int n = 5;
        int[] lost = {1, 2, 4, 5};
        int[] reserve = {1, 3, 4};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        // 잃어버린 사람 중 여벌을 가져온 사람을 제외시킨다.
        for (int i = 0; i < lost.length; i++) {
            int index = Arrays.binarySearch(reserve, lost[i]);
            if(index < 0){
                lostList.add(lost[i]);
            }
        }

        // 여벌을 가져온 사람 중 잃어버린 사람을 제외시킨다.
        for (int i = 0; i < reserve.length; i++) {
            int index = Arrays.binarySearch(lost, reserve[i]);
            if(index < 0){
                reserveList.add(reserve[i]);
            }
        }

        int answer = n - lostList.size();

        // 오름차순으로 잃어버린 사람들에 대해 양 옆으로 여벌을 가져온 사람이 있는지 확인한다.
        // 잃어버린 사람과 여벌을 가져온 사람들 모두 오름차순으로 정렬해놓았기 때문에 가능하다.
        int j = 0;
        for (int i = 0; i < lostList.size(); i++) {
            while(j < reserveList.size()){
                if(reserveList.get(j) == lostList.get(i) - 1){ // ex. lost: 2, reserve: 1
                    answer++;
                    j++;
                    break;
                }else if(reserveList.get(j) == lostList.get(i) + 1){ // ex. lost: 2, reserve: 3
                    answer++;
                    j++;
                    break;
                }else{
                    if(reserveList.get(j) > lostList.get(i) + 1){ // ex. lost: 2, reserve: 4 -> 해당 lost의 경우 여벌을 빌려줄 수 없다. 다음 lost 원소로 넘어간다.
                        break;
                    }
                }
                j++;
            }
        }
        
        return answer;
    }
}
