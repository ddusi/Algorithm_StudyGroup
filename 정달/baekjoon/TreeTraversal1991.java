package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리 순회 분류 Silver I
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        2 초	128 MB	15660	9629	7361	63.109%
//        문제
//        이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal),
//        후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
//
//
//
//        예를 들어 위와 같은 이진 트리가 입력되면,
//
//        전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
//        중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
//        후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
//        가 된다.
//
//        입력
//        첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다.
//        둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
//        노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며,
//        항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.
//
//        출력
//        첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다.
//        각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
//
//        예제 입력 1
//        7
//        A B C
//        B D .
//        C E F
//        E . .
//        F . G
//        D . .
//        G . .
//        예제 출력 1
//        ABDCEFG
//        DBAECFG
//        DBEGFCA
public class TreeTraversal1991 {

    public StringBuffer solution(List<String[]> nodeInfo){
        StringBuffer sb = new StringBuffer();

        String[][] nodeArray = new String[26][];

        int length = nodeInfo.size();
        for(int i = 0 ; i < length ; i ++ ) {
            String[] tmp = nodeInfo.get(i);
            nodeArray[getAdd( tmp[0] ) ] = tmp;
        }
//        반복
//        preOrder(sb, nodeArray);
//        inOrder(sb, nodeArray);
//        postOrder(sb, nodeArray);

//        재귀
        preOrderRecursive(sb, nodeArray, 0);
        sb.append("\n");
        inOrderRecursive(sb, nodeArray, 0);
        sb.append("\n");
        postOrderRecursive(sb, nodeArray, 0);
        sb.append("\n");

        return sb;
    }

    private void process(StringBuffer sb, String target){
        sb.append(target);
    }

    // 전위순회
    private void preOrder(StringBuffer sb, String[][] nodeArray){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){

            int nodeIndex = stack.pop();
            process(sb, nodeArray[nodeIndex][0]);

            int rightIndex = getAdd(nodeArray[nodeIndex][2]);
            if(rightIndex > 0 ){
                stack.push(rightIndex);
            }

            int leftIndex = getAdd(nodeArray[nodeIndex][1]);
            if(leftIndex > 0 ){
                stack.push(leftIndex);
            }

        }
        sb.append("\n");
    }
    // 후위순회
    private void postOrder(StringBuffer sb, String[][] nodeArray){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        boolean[] visited = new boolean[nodeArray.length];

        while(!stack.isEmpty()){

            int nodeIndex = stack.peek();
            int childNum = 0;

            int rightIndex = getAdd(nodeArray[nodeIndex][2]);
            int leftIndex = getAdd(nodeArray[nodeIndex][1]);
            if(rightIndex > 0  && !visited[rightIndex] ){
                stack.push(rightIndex);
                childNum ++;
            }
            if(leftIndex > 0 && !visited[leftIndex]  ){
                stack.push(leftIndex);
                childNum ++;
            }

            if( childNum == 0 ){
                stack.pop();
                visited[nodeIndex] = true;
                process(sb, nodeArray[nodeIndex][0]);
            }
        }
        sb.append("\n");
    }
    // 중위순회
    private void inOrder(StringBuffer sb, String[][] nodeArray){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        boolean[] visited = new boolean[nodeArray.length];

        while(!stack.isEmpty()){

            int nodeIndex = stack.peek();

            int rightIndex = getAdd(nodeArray[nodeIndex][2]);
            int leftIndex = getAdd(nodeArray[nodeIndex][1]);

            if(leftIndex > 0 && !visited[leftIndex]  ){
                stack.push(leftIndex);
            }else{

                stack.pop();
                visited[nodeIndex] = true;
                process(sb, nodeArray[nodeIndex][0]);

                if(rightIndex > 0  && !visited[rightIndex] ){
                    stack.push(rightIndex);
                }

            }

        }
        sb.append("\n");
    }

    private int getAdd(String l){
        if(".".equals(l)){
            return -1;
        }else{
            return l.charAt(0) - 'A';
        }
    }

    //recursive 전위순회
    private void preOrderRecursive(StringBuffer sb, String[][] nodeArray, int index){

        if(index<0){
            return;
        }

        int leftIndex = getAdd(nodeArray[index][1]);
        int rightIndex = getAdd(nodeArray[index][2]);

        process(sb, nodeArray[index][0]);

        preOrderRecursive(sb, nodeArray, leftIndex);

        preOrderRecursive(sb, nodeArray, rightIndex);

    }
    //recursive 중위
    private void inOrderRecursive(StringBuffer sb, String[][] nodeArray, int index){

        if(index<0){
            return;
        }

        int leftIndex = getAdd(nodeArray[index][1]);
        int rightIndex = getAdd(nodeArray[index][2]);
        inOrderRecursive(sb, nodeArray, leftIndex);

        process(sb, nodeArray[index][0]);

        inOrderRecursive(sb, nodeArray, rightIndex);

    }

    //recursive 후위
    private void postOrderRecursive(StringBuffer sb, String[][] nodeArray, int index){

        if(index<0){
            return;
        }

        int leftIndex = getAdd(nodeArray[index][1]);
        int rightIndex = getAdd(nodeArray[index][2]);
        postOrderRecursive(sb, nodeArray, leftIndex);
        postOrderRecursive(sb, nodeArray, rightIndex);

        process(sb, nodeArray[index][0]);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());

        List<String[]> nodeInfo = new LinkedList<>();

        for ( int i = 0 ; i < line ; i ++ ) {

            String[] aa = br.readLine().trim().split(" ");
            nodeInfo.add(aa);

        }

        System.out.println(new TreeTraversal1991().solution(nodeInfo).toString());

    }
}
