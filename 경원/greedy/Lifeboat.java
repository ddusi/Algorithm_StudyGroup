package programmers.exercise.greedy;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
//        int[] people = {10,20,30,40,50,60,70,80,90};
//        int limit = 100;
//        int[] people = {50, 50, 50, 60, 60, 60};
//        int limit = 110;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int startIndex = 0;
        int endIndex = people.length - 1;
        // 정렬된 배열의 시작과 끝 인덱스 값의 합이 limit을 넘는지 체크한다.
        // 만약 넘을 경우 끝 인덱스의 값은 보트에 1명밖에 태우지 못한다는 의미이므로 끝 인덱스만 하나 줄이고 횟수를 증가시킨다.
        // 넘지 않을 경우 시작과 끝 인덱스를 둘 다 갱신시키고 보트 횟수를 증가시킨다.
        while(startIndex < endIndex){
            if(people[startIndex] + people[endIndex] <= limit){
                startIndex++;
            }
            endIndex--;
            answer++;
        }

        // 만약 시작 인덱스와 끝 인덱스가 같다면, 해당 인덱스 값은 보트를 타지 않았으므로 횟수를 증가시킨다.
        if(startIndex == endIndex){
            answer++;
        }

        return answer;
    }
}
