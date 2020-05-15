package programmers.exercise.greedy;

public class JoyStick {
    public static void main(String[] args) {
//        String name = "JEROEN";
//        String name = "JAN";
//        String name = "AZAAAZ";
//        String name = "BBAAAAA";
//        String name = "AABAAAAAAABBB";
//        String name = "ABAAAAAAABA";
//        String name = "BBBBAAAABA"; // 13
        String name = "BBBBAAAAAB"; // 14

        System.out.println(solution(name));
    }

    // 맨 마지막 커서에서 오른쪽으로 더 이상 커서를 움직일 수가 없는 듯
    public static int solution(String name) {
        int answer = 0;
        char[] chArr = name.toCharArray();
        // 바꿔야 하는 알파벳 갯수
        int num = 0;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] != 'A'){
                num++;
            }
        }

        // check[i]: i번째 알파벳을 이미 바꿨는지에 대한 여부
        boolean[] check = new boolean[chArr.length];

        // 현재 커서 위치
        int index = 0;
        // 현재 위치에서 가장 가까운 'A'가 아닌 위치를 찾아 바꾼다.
        while(num > 0){
            int left = index;
            int right = index;
            for (int i = 0; i < chArr.length; i++) {
                right = index + i;
                left = index - i;
//                if(right >= chArr.length){
//                    right -= chArr.length;
//                }
                if(left < 0){
                    left += chArr.length;
                }
                if(right < chArr.length && !check[right] && chArr[right] != 'A'){
                    answer += i; // 커서를 이동한 횟수
                    answer += Math.min(chArr[right] - 'A', 'Z' - chArr[right] + 1); // 위아래 동작 횟수
                    check[right] = true;
                    index = right;
                    num--;
                    break;
                }else{
                    if(!check[left] && chArr[left] != 'A'){
                        answer += i; // 커서를 이동한 횟수
                        answer += Math.min(chArr[left] - 'A', 'Z' - chArr[left] + 1); // 위아래 동작 횟수
                        check[left] = true;
                        index = left;
                        num--;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
