import java.util.*;
import java.io.*;

public class Main{
    
    static int[] parents;
    static List<Integer>[] list;
    static boolean[] chk;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        list = new ArrayList[n+1];
        parents = new int[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        chk = new boolean[n+1];
        parents = new int[n+1];
        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            list[a].add(b);
            list[b].add(a);
        }
        
        dfs(1);
        for(int i = 2; i <= n; i++){
            System.out.println(parents[i]);
        }
        
    }
    
    private static void dfs(int node){
        chk[node] = true;
       
        for(int n : list[node]){
            if(!chk[n]){
                parents[n] = node;
                dfs(n);
            }
        }
    }
}