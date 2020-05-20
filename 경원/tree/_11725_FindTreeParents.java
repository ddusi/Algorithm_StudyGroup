package algorithm.baekjoon.stepwise.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class _11725_FindTreeParents {
	private static int N = 0;
	private static ArrayList<ArrayList<Integer>> adjacencyList = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int nFreq = 0;
		while((str = br.readLine()) != null){
			if(N == 0){
				N = Integer.parseInt(str);
				adjacencyList = new ArrayList<>();
				for(int i = 0; i <= N; i++){
					adjacencyList.add(new ArrayList<>());
				}
			}else{
				nFreq++;
				String[] strArr = str.split(" ");
				int a = Integer.parseInt(strArr[0]);
				int b = Integer.parseInt(strArr[1]);
				adjacencyList.get(a).add(b);
				adjacencyList.get(b).add(a);
				if(N - 1 == nFreq){
					break;
				}
			}
		}

		int[] parents = new int[N + 1];

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		// BFS
		while(!stack.isEmpty()){
			int parent = stack.pop();
			for (int i = 0; i < adjacencyList.get(parent).size(); i++) {
				if(parents[adjacencyList.get(parent).get(i)] == 0 && adjacencyList.get(parent).get(i) != 1){
					parents[adjacencyList.get(parent).get(i)] = parent;
					stack.push(adjacencyList.get(parent).get(i));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			sb.append(parents[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
