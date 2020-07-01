package programmers.exercise.hash;

import java.util.HashSet;

public class PhoneNumberList {
    public static void main(String[] args) {
//        String[] phoneBook = {"119", "97674223", "1195524421"};
//        String[] phoneBook = {"123", "456", "789"};
        String[] phoneBook = {"1192456", "119"};
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phoneBook) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phoneBook.length; i++) {
            set.add(phoneBook[i]);
        }
        for (String phoneNumber : set) {
            for (int j = 1; j < phoneNumber.length(); j++) {
                if(set.contains(phoneNumber.substring(0, j))){
                    answer = false;
                    break;
                }
            }
            if(answer == false){
                break;
            }
        }
        return answer;
    }
}
