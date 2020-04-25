package study.programmers.stackqueue;

import java.util.*;

//프린터
//        문제 설명
//        일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
//        이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
//        이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
//
//        1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//        2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//        3. 그렇지 않으면 J를 인쇄합니다.
//        예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
//
//        내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
//
//        현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
//        내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
//        인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
//        location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
//        입출력 예
//        priorities	location	return
//        [2, 1, 3, 2]	2	1
//        [1, 1, 9, 1, 1, 1]	0	5
//        입출력 예 설명
//        예제 #1
//
//        문제에 나온 예와 같습니다.
//
//        예제 #2
//
//        6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
public class Printer42587_2 {

    public int solution(int[] priorities, int location) {

        int cnt = 0 ;
        Queue<Integer> q = new LinkedList<>();
        // 주어진 배열을 큐에 순서대로 넣는다. 이때 넣어놓기 때문에 전달된 location값이 살아있다.
        for(int i : priorities){
            q.add(i);
        }

        // 다음에 찾아야할 최대숫자값 효과적으로 추적하기 위해 소팅을 해둔다. ( 오름차순 )
        Arrays.sort(priorities);
        int size = priorities.length -1 ; // 왜 사이즈를 길이 -1하는건지???? 요부분 잘 이해안간다....

        while(!q.isEmpty()){
            Integer a = q.poll();
            if(a == priorities[size-cnt]){
                // 큐의 맨 앞의것을 가져와봤는데, 현재 찾아야할 최대값과 같다.

                cnt ++ ; // 순환 한번 한거임.
                location --; // 내가 찾는 것의 위치가 앞으로 한단계 당겨졌다!

                if(location < 0){
                    break; // 내가 찾는 것의 위치가 0보다 작다는 것은, 출력 되었다는 뜻이다!
                }
            }else{
                // 큐의 맨앞의 거을 가져와봤는데, 아직 큐에 남아있는 최대값과 다르다면,
                location --; // 어쨌든 내가 찾는 것의 위치는 앞으로 한단계 당겨졌다... (처음에 poll 했으므로 )
                q.add(a); // 먼저 나가야할 최대값이 아니므로, 다시 맨 뒤로 보낸다.
                if(location < 0) {
                    // 내가 찾는 위치의 것이 출력되어버렸다면, 아직 자기 순서가 아니므로 다시 뒤로 들어갈꺼다.
                    // 그래서 맨뒤로 갔으므로 현재큐의 길이로 위치를 재조정 해준다.
                    location = q.size()-1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 1, 3, 2};
        int location = 2;
//        int[] array1 = new int[]{1, 1, 9, 1, 1, 1};
//        int location = 0;

        int result = new Printer42587_2().solution(array1, location);
            System.out.print(result);
    }
}
