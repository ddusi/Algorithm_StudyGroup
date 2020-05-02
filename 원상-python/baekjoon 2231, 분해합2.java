package jump2java;

import java.util.*;

public class 백준2231번_분해합2 {
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.close();
  
      for(int i = 1; i < n; i++){
          if(n == (i + sum(i))){
              System.out.println(i);
              return;
          }
      }
      System.out.println(0);
  }

  private static int sum(int num){
      int sum = 0;
      String n = String.valueOf(num);
      int len = n.length();
  
      for(int i = 0; i < len; i++){
          sum += n.charAt(i) - '0';
       // sum += Integer.parseInt(String.valueOf(n.charAt(i)));
				}
      return sum;
  }
}