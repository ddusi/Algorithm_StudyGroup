package jump2java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준1427번_소트인사이드 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);	
			ArrayList<Integer> arrayList = new ArrayList<>();
			
			int n= sc.nextInt();
			
			while(n!=0) {
				arrayList.add(n%10);
				n/=10;
			}
			
			Collections.sort(arrayList, Collections.reverseOrder()); //내림차순 정렬코드
			
			for(int i=0;i<arrayList.size();i++) {
				System.out.print(arrayList.get(i));
			}
		}
}
			
		