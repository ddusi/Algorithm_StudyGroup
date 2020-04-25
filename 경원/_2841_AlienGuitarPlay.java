package algorithm.baekjoon.stepwise.stack;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class _2841_AlienGuitarPlay {
    private static int N = 0;
    private static int fretN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nAndFret = br.readLine().split(" ");
        N = Integer.parseInt(nAndFret[0]);
        fretN = Integer.parseInt(nAndFret[1]);
        HashMap<Integer, Stack<Integer>> stringToFret = new HashMap<>();

        int answer = 0;
        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split(" ");
            int string = Integer.parseInt(strArr[0]);
            int fret = Integer.parseInt(strArr[1]);
            if(!stringToFret.containsKey(string)){
                Stack<Integer> stack = new Stack<>();
                stack.push(fret);
                answer++;
                stringToFret.put(string, stack);
            }else{
                Stack<Integer> frets = stringToFret.get(string);
                while(!frets.isEmpty() && frets.peek() > fret){
                    answer++;
                    frets.pop();
                }
                if(frets.isEmpty() || frets.peek() != fret){
                    answer++;
                    frets.push(fret);
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
