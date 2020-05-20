package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//이진 검색 트리 출처다국어분류 Silver I
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        1 초	256 MB	6895	2618	1852	41.028%
//        문제
//        이진 검색 트리는 다음과 같은 세 가지 조건을 만족하는 이진 트리이다.
//
//        노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
//        노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
//        왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.
//
//
//        전위 순회 (루트-왼쪽-오른쪽)은 루트를 방문하고, 왼쪽 서브트리, 오른쪽 서브 트리를 순서대로 방문하면서 노드의 키를 출력한다.
//        후위 순회 (왼쪽-오른쪽-루트)는 왼쪽 서브트리, 오른쪽 서브트리, 루트 노드 순서대로 키를 출력한다.
//        예를 들어, 위의 이진 검색 트리의 전위 순회 결과는 50 30 24 5 28 45 98 52 60 이고, 후위 순회 결과는 5 28 24 45 30 60 52 98 50 이다.
//
//        이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.
//
//        입력
//        트리를 전위 순회한 결과가 주어진다. 노드에 들어있는 키의 값은 106보다 작은 양의 정수이다.
//        모든 값은 한 줄에 하나씩 주어지며, 노드의 수는 10,000개 이하이다. 같은 키를 가지는 노드는 없다.
//
//        출력
//        입력으로 주어진 이진 검색 트리를 후위 순회한 결과를 한 줄에 하나씩 출력한다.
//
//        예제 입력 1
//        50
//        30
//        24
//        5
//        28
//        45
//        98
//        52
//        60
//        예제 출력 1
//        5
//        28
//        24
//        45
//        30
//        60
//        52
//        98
//        50
public class BinaryTree5639_shotcut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineStr = null;
        List<String> list = new LinkedList<>();

        while((lineStr = br.readLine())!=null){
            if(lineStr.isEmpty()) break;
            list.add(lineStr);
        }

        StringBuffer sb = new StringBuffer();
        System.out.println(new BinaryTree5639_shotcut().solution(sb, list).toString());

    }

    class Node{
        public boolean isLeft;
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data, Node left, Node right, Node parent, boolean isLeft) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.isLeft = isLeft;
        }

    }

    private StringBuffer solution(StringBuffer sb, List<String> nodeInfo) {
        int length = nodeInfo.size();

        Node root = null;
        for(int i = 1 ; i <= length ; i ++ ) {
            int target = Integer.parseInt( nodeInfo.get(i-1) );
            Node node = new Node(target, null, null , null, true);
            if(i==1) {
                root = node;
                continue;
            }
            makeTree(root, node);
        }

        // 루트를 가진 트리가 만들어졌(다고 가정한)다.
        // 후위순회하여 테스트
        postOrderRecursive(sb, root);

        return sb;
    }
    private void postOrderRecursive(StringBuffer sb, Node node) {
        if(node == null) {
            return;
        }

        postOrderRecursive(sb, node.left);
        postOrderRecursive(sb, node.right);
        sb.append(node.data).append("\n");
    }

    private void makeTree(Node parent, Node target) {
        if(target.data < parent.data ){
            if(parent.left==null) {
                parent.left = target;
                target.parent = parent;
                return;
            }else{
                makeTree(parent.left, target);
            }
        }else{
            if(parent.right == null){
                parent.right = target;
                target.parent = parent;
                return;
            }else{
                makeTree(parent.right , target);
            }
        }

    }
}
