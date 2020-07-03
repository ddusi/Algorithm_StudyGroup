package algorithm.baekjoon.usaco._2019.December.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18266_Meetings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NL = br.readLine().split(" ");
        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);

        XWD[] xwds = new XWD[N];

        int totalWeight = 0;
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            int x = Integer.parseInt(strArr[1]);
            int w = Integer.parseInt(strArr[0]);
            int d = Integer.parseInt(strArr[2]);
            xwds[i] = new XWD(x, w, d);
            totalWeight += w;
        }

        // x 기준으로 오름차순 정렬
        Arrays.sort(xwds);

        // 방향에 따라 왼쪽으로 얼마나 가야 하는지, 오른쪽으로 얼마나 가야하는지를 담는다.
        ArrayList<Integer> lTimes = new ArrayList<>();
        ArrayList<Integer> rTimes = new ArrayList<>();
        for (int i = 0; i < xwds.length; i++) {
            if(xwds[i].d == -1){
                lTimes.add(xwds[i].x);
            }else{
                rTimes.add(L - xwds[i].x);
            }
        }

        TW[] tws = new TW[N];
        int index = 0;

        // [0, L] 위에 있는 cow들 중 d == -1 인 것들의 수만큼(=lTimes.size()) 무조건 왼쪽 barn에 도달
        for (int i = 0; i < lTimes.size(); i++) {
            // 단, 도달하는 cow는 [0, L] 위에 있는 cow들 중 왼쪽부터 lTimes.size() 만큼 순차적으로 도달한다.
            // xwds는 이미 x에 대해 오름차순 정렬
            tws[index++] = new TW(lTimes.get(i), xwds[i].w);
        }

        // [0, L] 위에 있는 cow들 중 d == 1 인 것들의 수만큼(=rTimes.size()) 무조건 오른쪽 barn에 도달
        // xwds가 x기준의 오름차순 정렬이고, rTimes의 원소는 L-xwds[i] 이기 때문에 내림차순 정렬되어 있다.
        // 때문에 오름차순으로 변경해준다.
        rTimes.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        });
        for (int i = 0; i < rTimes.size(); i++){
            // 단, 도달하는 cow는 [0, L] 위에 있는 cow들 중 오른쪽부터 rTimes.size() 만큼 순차적으로 도달
            // xwds가 x에 대해 오름차순 정렬되어 있기 때문에 뒤에 있는 cow부터 먼저 오른쪽 barn에 도달한다.
            tws[index++] = new TW(rTimes.get(i), xwds[N - 1 - i].w);
        }

        // tws를 도달 시간(t) 기준으로 오름차순 정렬
        Arrays.sort(tws);

        int tot = 0;
        int tmpIndex = 0;
        while(2 * tot < totalWeight){
            tot += tws[tmpIndex++].w;
        }

        // T: 움직이지 않는 소의 무게가 절반을 넘었을 때의 최소 T
        int T = tws[tmpIndex - 1].t;

        int meetings = 0;
        // 오른쪽으로 가는 cow의 x를 넣기 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < xwds.length; i++) {
            if(xwds[i].d == 1){
                queue.offer(xwds[i].x);
            }else{
                // d == -1 일 경우 (왼쪽으로 가는 cow) queue에 쌓인 오른쪽으로 가는 cow와의 거리가 2T를 넘지 않을 때를 찾는다.
                while(!queue.isEmpty() && queue.peek() + 2 * T < xwds[i].x){
                    queue.poll();
                }
                // 오른쪽으로 가는 cow중 남은 것들은 모두 현재 체크하는 왼쪽 소와의 거리가 2T 이하이므로, 무조건 만난다.
                meetings += queue.size();
            }
        }

        System.out.println(meetings);
    }

    private static class XWD implements Comparable<XWD> {
        int x;
        int w;
        int d;
        public XWD(int x, int w, int d){
            this.x = x;
            this.w = w;
            this.d = d;
        }

        @Override
        public int compareTo(XWD o) {
            return (this.x < o.x)? -1 : (this.x == o.x)? 0 : 1;
        }
    }

    private static class TW implements Comparable<TW> {
        int t;
        int w;
        public TW(int t, int w){
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(TW o) {
            return (this.t < o.t)? -1 : (this.t == o.t)? 0 : 1;
        }
    }
}
