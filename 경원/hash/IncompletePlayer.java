package programmers.exercise.hash;

import java.util.HashMap;

public class IncompletePlayer {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
        }

        for(String player : participantMap.keySet()){
            if(participantMap.get(player) != 0){
                answer = player;
                break;
            }
        }
        return answer;
    }
}
