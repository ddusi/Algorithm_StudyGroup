package study.programmers.hash;

import java.util.*;

//위장
//문제 설명
//        스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
//
//        예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
//
//        종류	이름
//        얼굴	동그란 안경, 검정 선글라스
//        상의	파란색 티셔츠
//        하의	청바지
//        겉옷	긴 코트
//        스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
//        스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
//        같은 이름을 가진 의상은 존재하지 않습니다.
//        clothes의 모든 원소는 문자열로 이루어져 있습니다.
//        모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
//        스파이는 하루에 최소 한 개의 의상은 입습니다.
//        입출력 예
//        clothes	return
//        [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
//        [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
//        입출력 예 설명
//        예제 #1
//        headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
//
//        1. yellow_hat
//        2. blue_sunglasses
//        3. green_turban
//        4. yellow_hat + blue_sunglasses
//        5. green_turban + blue_sunglasses
//        예제 #2
//        face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
//
//        1. crow_mask
//        2. blue_sunglasses
//        3. smoky_makeup
public class Hash42578 {
    public int solution(String[][] clothes) {
        int result = 0;

        Map<String, Integer> closet = new HashMap<>();

        if(clothes==null || clothes.length==0) {
            return result;
        }

        for(String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
        }

        int groupSize = closet.size();


        int[] comb = new int[groupSize];
        Set<String> keySet = closet.keySet();
        Iterator<String> it = keySet.iterator();
        int index = 0;
        int finalResult = 0;
        while(it.hasNext()) {
            // 답보고 ㅜㅠ
            int cnt =  closet.get( it.next() );
//            comb[index] = closet.get( it.next() );
            index ++;
            finalResult += (cnt + 1 ); // 해당 항목의 옷을 입지 않을 경우 추가.

        }
        finalResult = finalResult -1 ;// 벌거숭이일 경우 제외
//        for(int i = 0; i < groupSize ; i ++ ) {
//            result += getSum(i + 1, comb);
//        }
//        return result;
        return finalResult;
    }

    public int getSum(int mulNum, int[] comb){
        boolean[] visited = new boolean[comb.length];
        Deque<List > que = new ArrayDeque<>();
        int sum = 0;
        LinkedList<Integer > q1 = new LinkedList<>();
        combination(mulNum,0 ,comb, que, visited , mulNum, q1);
        while(!que.isEmpty()){
            List<Integer> a = que.pop();
            int mul = 1;
            for(int i : a) {
                mul = i * mul;
            }
            sum += mul;
        }
        return sum;
    }

    public void combination(int mulNum, int start, int[] comb , Deque<List > que, boolean[] visited, int r, LinkedList<Integer> q1 ){
        if(r == 0 ) {
            LinkedList<Integer> result1 = new LinkedList<>(q1);
            Collections.copy(result1, q1);
            que.push(result1);
            return;
        }

        for(int i = start; i < comb.length; i ++ ) {
            q1.push(comb[i]);
            combination(mulNum, i+1, comb, que, visited, r-1 , q1);
            q1.pop();
        }
    }

    public static void main(String[] args) {
        String[][] clothes = new String[30][2];
        for(int i = 0 ; i < 30 ; i ++) {
            clothes[i][0] = "clothName" + i;
            clothes[i][1] = "gearName"  + (i%30);
        }

        System.out.println(new Hash42578().solution(clothes));;

    }
}
