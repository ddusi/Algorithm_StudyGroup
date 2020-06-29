package algorithm.baekjoon.usaco._2019.December;

import java.util.*;

public class _18270_LivestockLineup {
    private static final String REDUNDANCY = " must be milked beside ";

    private static final String[] COW_NAMES = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        scn.nextLine();
        Map<String, ArrayList<String>> adjacencyList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] cows = scn.nextLine().split(REDUNDANCY);
            if(!adjacencyList.containsKey(cows[0])){
                adjacencyList.put(cows[0], new ArrayList<>());
            }
            if(!adjacencyList.containsKey(cows[1])){
                adjacencyList.put(cows[1], new ArrayList<>());
            }
            adjacencyList.get(cows[0]).add(cows[1]);
            adjacencyList.get(cows[1]).add(cows[0]);
        }

        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        for(String cow : adjacencyList.keySet()){
            if(adjacencyList.get(cow).size() == 2){
                continue;
            }
            ArrayList<String> group = makeGroup(cow, adjacencyList);
            if(groups.isEmpty()){
                groups.add(group);
            }else{
                boolean dupCheck = false;
                for (int i = 0; i < groups.size(); i++) {
                    if(groups.get(i).get(0).equals(group.get(group.size() - 1))){
                        if(groups.get(i).get(0).compareTo(group.get(0)) > 0){
                            groups.remove(i);
                            groups.add(group);
                        }
                        dupCheck = true;
                        break;
                    }
                }
                if(!dupCheck){
                    groups.add(group);
                }
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        Set<String> doesNotContainInGroup = new HashSet<>();
        for (int i = 0; i < COW_NAMES.length; i++) {
            doesNotContainInGroup.add(COW_NAMES[i]);
        }
        for (int i = 0; i < groups.size(); i++) {
            queue.offer(groups.get(i).get(0));
            for (int j = 0; j < groups.get(i).size(); j++) {
                doesNotContainInGroup.remove(groups.get(i).get(j));
            }
        }

        for(String cow : doesNotContainInGroup){
            queue.offer(cow);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            String str = queue.poll();
            sb.append(str).append("\n");
            for (int i = 0; i < groups.size(); i++) {
                if(str.equals(groups.get(i).get(0))){
                    for (int j = 1; j < groups.get(i).size(); j++) {
                        sb.append(groups.get(i).get(j)).append("\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static ArrayList<String> makeGroup(String start, Map<String, ArrayList<String>> adjacencyList) {
        ArrayList<String> answer = new ArrayList<>();
        Set<String> cowGroup = new HashSet<>();
        answer.add(start);
        cowGroup.add(start);
        while(adjacencyList.containsKey(start)){
            ArrayList<String> besideCows = adjacencyList.get(start);
            boolean besideCowsIsAllInCowGroups = true;
            for (int i = 0; i < besideCows.size(); i++) {
                if(!cowGroup.contains(besideCows.get(i))){
                    answer.add(besideCows.get(i));
                    cowGroup.add(besideCows.get(i));
                    start = besideCows.get(i);
                    besideCowsIsAllInCowGroups = false;
                    break;
                }
            }
            if(besideCowsIsAllInCowGroups){
                break;
            }
        }

        return answer;
    }
}
