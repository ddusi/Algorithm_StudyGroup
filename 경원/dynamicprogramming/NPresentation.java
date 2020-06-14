package programmers.exercise.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NPresentation {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

    public static int solution(int N, int number) {
        int answer = 0;

        ArrayList<Set<Integer>> candidatesList = new ArrayList<>();
        candidatesList.add(new HashSet<>());
        Set<Integer> first = new HashSet<>();
        first.add(N);
        candidatesList.add(first);
        for (int i = 2; i <= 8; i++) {
            Set<Integer> candidates = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }
            candidates.add(Integer.parseInt(sb.toString()));
            candidates.add((-1) * Integer.parseInt(sb.toString()));
            candidatesList.add(candidates);
            makeNumber(i, i, N, 0, 0, candidates, candidatesList);
            makeNumber(i, i, N, 0, 1, candidates, candidatesList);
            for(int candidate : candidatesList.get(i)){
                if(candidate == number){
                    answer = i;
                    break;
                }
            }
            if(answer != 0){
                break;
            }
        }

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    /**
     *
     * @param start : 메소드가 처음 호출될 때, N을 몇 번 이용하여 숫자를 만드는지에 대한 파라미터 (for문에서 start에 대한 후보군 호출을 막기 위해 사용)
     * @param NLength : N을 몇 번 사용해야 하는지에 대한 파라미터
     * @param N : 사용할 숫자
     * @param prevNumber : 이전까지의 계산 이력
     * @param operator : 0(+), 1(-), 2(*), 3(/) -> 이전 계산 이력에 새로 만들 숫자를 어떻게 연산할 지에 대한 연산 표시
     * @param candidates : 새로 만든 숫자를 넣을 set
     * @param candidatesList : dp 용도의 set의 List
     */
    private static void makeNumber(int start, int NLength, int N, int prevNumber, int operator, Set<Integer> candidates, ArrayList<Set<Integer>> candidatesList) {
        if(NLength == 0){
            candidates.add(prevNumber);
            return;
        }

        for (int i = NLength; i >= 0; i--) {
            if(i == start){
                continue;
            }
            for(int candidateWithLengthI : candidatesList.get(i)){
                switch (operator){
                    case 0:
                        makeNumber(start, NLength - i, N, prevNumber + candidateWithLengthI, 0, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber + candidateWithLengthI, 1, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber + candidateWithLengthI, 2, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber + candidateWithLengthI, 3, candidates, candidatesList);
                        break;
                    case 1:
                        makeNumber(start, NLength - i, N, prevNumber - candidateWithLengthI, 0, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber - candidateWithLengthI, 1, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber - candidateWithLengthI, 2, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber - candidateWithLengthI, 3, candidates, candidatesList);
                        break;
                    case 2:
                        makeNumber(start, NLength - i, N, prevNumber * candidateWithLengthI, 0, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber * candidateWithLengthI, 1, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber * candidateWithLengthI, 2, candidates, candidatesList);
                        makeNumber(start, NLength - i, N, prevNumber * candidateWithLengthI, 3, candidates, candidatesList);
                        break;
                    case 3:
                        if(candidateWithLengthI != 0){
                            makeNumber(start, NLength - i, N, prevNumber / candidateWithLengthI, 0, candidates, candidatesList);
                            makeNumber(start, NLength - i, N, prevNumber / candidateWithLengthI, 1, candidates, candidatesList);
                            makeNumber(start, NLength - i, N, prevNumber / candidateWithLengthI, 2, candidates, candidatesList);
                            makeNumber(start, NLength - i, N, prevNumber / candidateWithLengthI, 3, candidates, candidatesList);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
