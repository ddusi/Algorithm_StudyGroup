package programmers.exercise.hash;

import java.util.HashMap;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesTypeAndNums = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            clothesTypeAndNums.put(clothes[i][1], clothesTypeAndNums.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String type : clothesTypeAndNums.keySet()) {
            answer *= (clothesTypeAndNums.get(type) + 1);
        }

        return answer - 1;
    }
}
