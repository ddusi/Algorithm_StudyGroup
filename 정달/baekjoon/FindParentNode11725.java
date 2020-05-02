package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리의 부모 찾기 Silver II
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        1 초	256 MB	11103	4705	3511	44.102%
//        문제
//        루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
//        출력
//        첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
//
//        예제 입력 1
//        7
//        1 6
//        6 3
//        3 5
//        4 1
//        2 4
//        4 7
//        예제 출력 1
//        4
//        6
//        1
//        3
//        1
//        4
//        예제 입력 2
//        12
//        1 2
//        1 3
//        2 4
//        3 5
//        3 6
//        4 7
//        4 8
//        5 9
//        5 10
//        6 11
//        6 12
//        예제 출력 2
//        1
//        1
//        2
//        3
//        3
//        4
//        4
//        5
//        5
//        6
//        6
public class FindParentNode11725 {

    class Node{
        public int data;
        public Node parent;
        public Node left;
        public Node right;
        public Deque<Node> que;
        public boolean visited;
        public Node(int data, Node parent, Node left, Node right) {
            visited = false;
            que = new ArrayDeque<>();
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public void solution(List<String> nodeInfos, int totalNodeSize, StringBuffer sb){
        int length = nodeInfos.size();
        Node root = null;
        TreeMap<Integer, Node> map = new TreeMap<>();
        for(String nodeInfo : nodeInfos){
            String[] tmp = nodeInfo.split(" ");
            int val1 = intVal(tmp[0]);
            int val2 = intVal(tmp[1]);
            Node node1 = map.get(val1);
            Node node2 = map.get(val2);
            if(node1 == null){
                node1 = new Node(val1, null, null, null);
                map.put(val1, node1);
            }
            if(node2 == null){
                node2 = new Node(val2, null, null, null);
                map.put(val2, node2);
            }
            node1.que.add(node2);
            node2.que.add(node1);
        }

        linkNodes(map);

        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it = keySet.iterator();
        int index = 0;
        while(it.hasNext()){

            Node node = map.get(it.next());
            if(index==0){
                index ++;
                continue;
            }
            sb.append(node.parent.data).append("\n");
        }
        System.out.println(sb.toString());
    }

    private void linkNodes(Map<Integer, Node> map){
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(map.get(1));
        while(!deque.isEmpty()){

            Node target = deque.poll();
            target.visited = true;
            while(!target.que.isEmpty()){
                Node links = target.que.poll();
                if(!links.visited){
                    if(target.left == null) {
                        target.left = links;
                        deque.add(links);
                    }else{
                        target.right = links;
                        deque.add(links);
                    }
                }else{
                    target.parent = links;
                }
            }
        }


    }

    private int intVal(String val) {
        return Integer.valueOf(val);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int lines = Integer.parseInt(br.readLine());
        String lineStr = null;
        List<String> nodeInfos = new LinkedList<>();
        while((lineStr = br.readLine())!=null){
            if(lineStr.isEmpty()) break;
            nodeInfos.add(lineStr);
        }

        new FindParentNode11725().solution(nodeInfos,lines,sb);

    }
}
