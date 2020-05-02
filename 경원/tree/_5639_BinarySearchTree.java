package algorithm.baekjoon.stepwise.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _5639_BinarySearchTree {
    private static StringBuilder sb = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nums = new ArrayList<>();
        String str;
        while((str = br.readLine()) != null){
            try {
                nums.add(Integer.parseInt(str));
            }catch(NumberFormatException e){
                break;
            }
        }

        // BST 만들기
        Node root = makeTree(nums, 0, nums.size() - 1);

        sb = new StringBuilder();
        // BST에 대한 후위 순회
        postOrder(root);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static Node makeTree(List<Integer> nums, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new Node(nums.get(start));
        }
        int value = nums.get(start);
        Node node = new Node(value);
        boolean doesMakeTree = false;
        for(int i = start + 1; i <= end; i++){
            if(nums.get(i) > value){
                node.left = makeTree(nums, start + 1, i - 1);
                node.right = makeTree(nums, i, end);
                doesMakeTree = true;
                break;
            }
        }
        if(!doesMakeTree){
            node.left = makeTree(nums, start + 1, end);
        }
        return node;
    }

    private static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        sb.append(root.value).append("\n");
    }

    private static class Node{
        public Node left = null;
        public Node right = null;
        public int value;
        public Node(int value){
            this.value = value;
        }
    }
}
