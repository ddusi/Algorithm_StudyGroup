package study.programmers.hash;

import java.util.*;

//문제 설명
//        스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//
//        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//        노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
//
//        제한사항
//        genres[i]는 고유번호가 i인 노래의 장르입니다.
//        plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
//        genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
//        장르 종류는 100개 미만입니다.
//        장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
//        모든 장르는 재생된 횟수가 다릅니다.
//        입출력 예
//        genres	plays	return
//        [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
//        입출력 예 설명
//        classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
//
//        고유 번호 3: 800회 재생
//        고유 번호 0: 500회 재생
//        고유 번호 2: 150회 재생
//        pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
//
//        고유 번호 4: 2,500회 재생
//        고유 번호 1: 600회 재생
//        따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
public class Hash42579_2 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        int size = genres.length;
        HashMap<String, Integer> genresTotal = new HashMap<>();                 // 장르별로 플레이횟수 더해두기
        HashMap<String, LinkedList<Integer>> genresGroups = new HashMap<>();    // 장르별로 플레이 횟수 많은 순서 기억하기

        // genres를 돌면서
        for(int i = 0 ; i < size; i ++ ) {
            String genresName = genres[i];
            int playCnt = plays[i];

            genresTotal.merge(genresName, playCnt, (exist, init)-> exist + init ); // 장르별 플레이횟수 합산

            // 장르별 플레이 횟수 순위 인덱스 기억하기
            if(genresGroups.get(genresName) == null) {
                LinkedList<Integer> l1 = new LinkedList<>();
                l1.add(i);
                genresGroups.put(genresName, l1);

            } else {
                LinkedList<Integer> l2 = genresGroups.get(genresName);

                // 처음꺼보다 크면 맨앞에, 두번째꺼가 있으면 그거랑 비교해서 크면 두번째, 그외엔 걍 끝에 애드
                if( plays[l2.get(0)] < playCnt ){
                    l2.addFirst(i);
                }else if(l2.size() > 1 && plays[l2.get(1)] < playCnt ){
                    l2.add(1, i);
                }else{
                    l2.add(i);
                }
            }
        }

        // 장르별 플레이횟수 순위 정렬
        List<String> keySetList = new ArrayList<>(genresTotal.keySet());
        Collections.sort(keySetList,(o1, o2) -> genresTotal.get(o2).compareTo(genresTotal.get(o1)));

        List<Integer> result = new LinkedList<>();

        // 1위부터 돌면서 결과 만들기
        for(String key :  keySetList) {
            LinkedList<Integer> list = genresGroups.get(key);
            int limit = 2;
            for(int index:list){
                result.add(index);
                limit --;
                if(limit==0) break;
            }
        }

        answer = new int[result.size()];
        for(int i = 0 ; i < result.size(); i ++ ) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] genres = new String[]{"classic", "classic", "classic", "classic", "classic"};
        String[] genres = new String[]{"classic", "pop1", "classic", "classic", "pop", "jazz"};
//        int[] plays = new int[]{1, 2, 3, 4, 5};
        int[] plays = new int[]{8500, 12600, 150, 800, 2500, 7000};

        int[] a = new Hash42579_2().solution(genres,plays);
        for(int aa: a){
            System.out.println(aa);
        }
    }
}
