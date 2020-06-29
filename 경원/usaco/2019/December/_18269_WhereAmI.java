package algorithm.baekjoon.usaco._2019.December;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _18269_WhereAmI {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        scn.nextLine();
        String colors = scn.nextLine();

        int answer = 1;
        while(answer <= N){
            boolean isPossible = true;
            Set<String> locationSet = new HashSet<>();
            for (int i = 0; i <= colors.length() - answer; i++) {
                String location = colors.substring(i, i + answer);
                if(locationSet.contains(location)){
                    isPossible = false;
                    break;
                }else{
                    locationSet.add(location);
                }
            }
            if(isPossible){
                break;
            }else{
                answer++;
            }
        }

        if(answer > N){
            answer = N;
        }

        System.out.println(answer);
    }
}
