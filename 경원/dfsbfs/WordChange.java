package programmers.exercise.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WordChange {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    private static int answer = 0;

    public static int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        bfs(queue, 0, words, target, new boolean[words.length]);
        return answer;
    }

    /**
     * queue에서 단어를 하나씩 빼면서 다음 연결된 단어를 찾는다.
     * 이 때 기존에 방문한 단어인지 여부와, 타겟 단어인지를 체크한다.
     * 만약 타겟 단어가 연결된 단어 중 하나라면, 전역변수를 갱신하고 바로 리턴한다.
     * (bfs이기 때문에 먼저 찾은 경로가 최소 경로 중 하나임이 보장 된다.)
     *
     * 타겟 단어로 변환할 수 없을 시 전역변수 answer는 갱신되지 않을 것
     * @param queue
     * @param freq
     * @param words
     * @param target
     * @param check
     */
    private static void bfs(Queue<String> queue, int freq, String[] words, String target, boolean[] check){
        if(queue.isEmpty()){
            return;
        }
        String word = queue.poll();
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals(word) && !check[i] && isConnected(word, words[i])){
                if(words[i].equals(target)){
                    answer = freq + 1;
                    return;
                }
                queue.offer(words[i]);
                check[i] = true;
                bfs(queue, freq + 1, words, target, check);
                check[i] = false;
            }
        }
    }

    private static boolean isConnected(String str1, String str2){
        int check = 0;
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        for (int i = 0; i < chArr1.length; i++) {
            if(chArr1[i] != chArr2[i]){
                check++;
            }
            if(check > 1){
                break;
            }
        }
        return (check == 1) ? true : false;
    }
}
