package algorithm.baekjoon.stepwise.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1991_TreeTraversal {
	
	private static final String DOT = ".";

	private static class Node {
		private String name;
		private Node left;
		private Node right;
		public Node(){
			this.name = null;
			this.left = null;
			this.right = null;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	private static class Tree {
		private Node root;
		private int level;
		public void preOrder(Node node, StringBuilder sb){
			sb.append(node.getName());
			if(node.getLeft() != null){
				preOrder(node.getLeft(), sb);
			}
			if(node.getRight() != null){
				preOrder(node.getRight(), sb);
			}
		}
		public void inOrder(Node node, StringBuilder sb){
			if(node.getLeft() != null){
				inOrder(node.getLeft(), sb);
			}
			sb.append(node.getName());
			if(node.getRight() != null){
				inOrder(node.getRight(), sb);
			}
		}
		public void postOrder(Node node, StringBuilder sb){
			if(node.getLeft() != null){
				postOrder(node.getLeft(), sb);
			}
			if(node.getRight() != null){
				postOrder(node.getRight(), sb);
			}
			sb.append(node.getName());
		}
		public Node getRoot() {
			return root;
		}
		public void setRoot(Node root) {
			this.root = root;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
	}
	
	private static void insertNode(Node node, String[] strArr){
		if(strArr[0].equals(node.getName())){
			if(!DOT.equals(strArr[1])){
				node.setLeft(new Node());
				node.getLeft().setName(strArr[1]);				
			}
			if(!DOT.equals(strArr[2])){
				node.setRight(new Node());
				node.getRight().setName(strArr[2]);				
			}
		}else{
			if(node.getLeft() != null){
				insertNode(node.getLeft(), strArr);
			}
			if(node.getRight() != null){
				insertNode(node.getRight(), strArr);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int nodeNum = 0;
		int freq = 0;
		Tree tree = new Tree();
		tree.setRoot(new Node());
		while((str = br.readLine()) != null){
			if(freq == 0){
				nodeNum = Integer.parseInt(str);
			}else{
				String[] strArr = str.split(" ");
				if(freq == 1){
					tree.getRoot().setName(strArr[0]);
					if(!DOT.equals(strArr[1])){
						tree.getRoot().setLeft(new Node());
						tree.getRoot().getLeft().setName(strArr[1]);
					}
					if(!DOT.equals(strArr[2])){
						tree.getRoot().setRight(new Node());
						tree.getRoot().getRight().setName(strArr[2]);
					}
				}else{
					insertNode(tree.getRoot(), strArr);
				}
			}
			if(freq == nodeNum){
				break;
			}
			freq++;
		}
		StringBuilder sb = new StringBuilder();
		tree.preOrder(tree.getRoot(), sb);
		bw.write(sb.toString());
		bw.newLine();
		sb = new StringBuilder();
		tree.inOrder(tree.getRoot(), sb);
		bw.write(sb.toString());
		bw.newLine();
		sb = new StringBuilder();
		tree.postOrder(tree.getRoot(), sb);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
