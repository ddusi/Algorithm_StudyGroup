package programmers.exercise.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
        int[] plays = {500, 500, 500, 500, 500};
        int[] answer = solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<PlayIndex>> genresPlaysMap = new HashMap<>();
        HashMap<String, Integer> genresTotalPlaysMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresTotalPlaysMap.put(genres[i], genresTotalPlaysMap.getOrDefault(genres[i], 0) + plays[i]);
            if(!genresPlaysMap.containsKey(genres[i])){
                PriorityQueue<PlayIndex> priorityQueue = new PriorityQueue<>();
                genresPlaysMap.put(genres[i], priorityQueue);
            }
            PlayIndex playIndex = new PlayIndex(plays[i], i);
            genresPlaysMap.get(genres[i]).offer(playIndex);
        }

        PriorityQueue<GenreTotalPlay> queue = new PriorityQueue<>();
        for(String genre : genresTotalPlaysMap.keySet()){
            GenreTotalPlay tmp = new GenreTotalPlay(genre, genresTotalPlaysMap.get(genre));
            queue.offer(tmp);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            GenreTotalPlay tmp = queue.poll();
            list.add(genresPlaysMap.get(tmp.genre).poll().index);
            if(!genresPlaysMap.get(tmp.genre).isEmpty()){
                list.add(genresPlaysMap.get(tmp.genre).poll().index);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private static class GenreTotalPlay implements Comparable<GenreTotalPlay> {
        String genre;
        int totalPlay;
        public GenreTotalPlay(String genre, int totalPlay){
            this.genre = genre;
            this.totalPlay = totalPlay;
        }

        @Override
        public int compareTo(GenreTotalPlay o) {
            return this.totalPlay < o.totalPlay ? 1 : -1;
        }
    }

    private static class PlayIndex implements Comparable<PlayIndex>{
        int play;
        int index;
        public PlayIndex(int play, int index){
            this.play = play;
            this.index = index;
        }


        @Override
        public int compareTo(PlayIndex o) {
            if(this.play > o.play){
                return -1;
            }else if(this.play < o.play){
                return 1;
            }
            return this.index < o.index ? -1 : 1;
        }
    }
}
