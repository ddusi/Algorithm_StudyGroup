import java.util.*;
import java.io.*;

public class Main{
    
    static Map<String, List<String>> tree = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            String[] arr = br.readLine().split("\\s");
            List<String> list = new ArrayList<>();
            
            list.add(arr[1]);
            list.add(arr[2]);
            tree.put(arr[0], list);
        }
        
        preOrder("A");
        System.out.println();
        centerOrder("A");
        System.out.println();
        postOrder("A");
    }
    
    //전위순회
    private static void preOrder(String node){
        if(".".equals(node))
            return;
        
        System.out.print(node);
        preOrder(tree.get(node).get(0));
        preOrder(tree.get(node).get(1));        
    }
    
    //중위순회
    private static void centerOrder(String node){
        if(".".equals(node))
            return;
        
        centerOrder(tree.get(node).get(0));
        System.out.print(node);
        centerOrder(tree.get(node).get(1));
    }
    
    //후위순회
    private static void postOrder(String node){
        if(".".equals(node))
            return;
        
        postOrder(tree.get(node).get(0));
        postOrder(tree.get(node).get(1));
        System.out.print(node);
    }
}