package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//욕심쟁이 판다 분류 Gold III
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        2 초	256 MB	19668	6267	4016	29.917%
//        문제
//        n*n의 크기의 대나무 숲이 있다. 욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다.
//        그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다.
//        그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다.
//        이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.
//        만약에 그런 지점이 없으면 이 판다는 불만을 가지고 단식 투쟁을 하다가 죽게 된다(-_-)
//
//        이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데, 어떤 지점에 처음에 풀어 놓아야 하고,
//        어떤 곳으로 이동을 시켜야 둘 다 소중한 생명이지만 판다가 최대한 오래 살 수 있는지 고민에 빠져 있다.
//        우리의 임무는 이 사육사를 도와주는 것이다. n*n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 오래 살려면 어떤 경로를 통하여 움직여야 하는지 구하여라.
//
//        입력
//        첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다. 그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다.
//        대나무 숲의 정보는 공백을 사이로 두고 각 지역의 대나무의 양이 정수 값으로 주어진다. 대나무의 양은 1,000,000보다 작거나 같은 자연수이다.
//
//        출력
//        첫째 줄에는 판다가 최대한 살 수 있는 일수(K)를 출력한다.
//
//        예제 입력 1
//        4
//        14 9 12 10
//        1 11 5 4
//        7 15 2 13
//        6 3 16 8
//        예제 출력 1
//        4
public class GreedyPanda1937 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int howMany = Integer.parseInt(br.readLine());
        List<String[]> paramList = new ArrayList<>();
        for(int i = 0 ; i < howMany ; i ++) {
            String[] params = new String[howMany];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for(int j = 0 ; j< howMany; j ++){
                params[j]=st.nextToken();
            }
            paramList.add(params);
        }

        System.out.println(new GreedyPanda1937().solution(paramList));
    }

    public String solution(List<String[]> paramList){

        int size = paramList.size();
        Forest[] woods = new Forest[size*size];

        int index = 0;
        for (String[] forest:paramList){
            for(String wood : forest){
                Forest f = new Forest();
                f.index=index;
                f.howmanyBamboo = Integer.valueOf(wood);
                woods[index] = f;
                index ++;
            }
        }

        for(int k = 0 ; k < size*size ; k ++) {
             makeForestmap(woods, size, k);
        }
        int max = 0;
        for(int k = 0 ; k < size*size ; k ++) {
            int result = checkMaxDepth(woods, k);
            woods[k].maxSuvDay = result;
            if(max < result){
                max = result;
            }
        }

        return max + "";
    }

    public int checkMaxDepth(Forest[] woods, int index){

        Deque<Integer> que = new ArrayDeque<>();
        que.push(index);
        int[] depth = new int[woods.length];
        int nowDepth = 1;
        int maxDepth = 0;
        depth[index] = nowDepth;
        while(!que.isEmpty()){
            int nowIndex = que.poll();
            Forest f = woods[nowIndex];
            nowDepth = depth[nowIndex];
            if(woods[nowIndex].north!=null){
                if(woods[nowIndex].north.maxSuvDay!=0){
                    maxDepth = Math.max(maxDepth,woods[nowIndex].north.maxSuvDay +1 );
                }else{
                    depth[woods[nowIndex].north.index] = nowDepth+1;
                    que.add(woods[nowIndex].north.index);
                }
            }
            if(woods[nowIndex].south!=null){
                if(woods[nowIndex].south.maxSuvDay!=0){
                    maxDepth = Math.max(maxDepth,woods[nowIndex].south.maxSuvDay +1 );
                }else{
                    depth[woods[nowIndex].south.index] = nowDepth+1;
                    que.add(woods[nowIndex].south.index);
                }
            }
            if(woods[nowIndex].west!=null){
                if(woods[nowIndex].west.maxSuvDay!=0){
                    maxDepth = Math.max(maxDepth,woods[nowIndex].west.maxSuvDay +1 );
                }else{

                    depth[woods[nowIndex].west.index] = nowDepth+1;
                    que.add(woods[nowIndex].west.index);
                }
            }
            if(woods[nowIndex].east!=null){
                if(woods[nowIndex].east.maxSuvDay!=0){
                    maxDepth = Math.max(maxDepth,woods[nowIndex].east.maxSuvDay +1 );
                }else{
                    depth[woods[nowIndex].east.index] = nowDepth+1;
                    que.add(woods[nowIndex].east.index);
                }
            }
        }
        return Math.max(maxDepth,nowDepth );
    }
    public void makeForestmap( Forest[] woods, int size, int nowIndex){

                if(nowIndex - size >= 0 &&  woods[nowIndex-size].howmanyBamboo > woods[nowIndex].howmanyBamboo ){
//        moveNorth
                    woods[nowIndex].north = woods[nowIndex-size];
                }

                if(nowIndex%size +1 < size && woods[nowIndex + 1].howmanyBamboo > woods[nowIndex].howmanyBamboo ) {
//        moveEast
                    woods[nowIndex].east = woods[nowIndex + 1];
                }

                if( nowIndex%size - 1 >= 0 && woods[nowIndex - 1].howmanyBamboo > woods[nowIndex].howmanyBamboo ){
//        moveWest
                    woods[nowIndex].west = woods[nowIndex -1];
                }

                if(nowIndex + size < size*size && woods[nowIndex + size].howmanyBamboo > woods[nowIndex].howmanyBamboo ){
//        moveSouth
                    woods[nowIndex].south = woods[nowIndex + size];
                }

    }


    class Forest{

        public int index;
        public int howmanyBamboo;
        public int maxSuvDay = 0;
        public Forest north;
        public Forest south;
        public Forest east;
        public Forest west;
    }
}
