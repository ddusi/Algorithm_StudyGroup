package jump2java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ����1427��_��Ʈ�λ��̵� {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);	
			ArrayList<Integer> arrayList = new ArrayList<>();
			
			int n= sc.nextInt();
			
			while(n!=0) {
				arrayList.add(n%10);
				n/=10;
			}
			
			Collections.sort(arrayList, Collections.reverseOrder()); //�������� �����ڵ�
			
			for(int i=0;i<arrayList.size();i++) {
				System.out.print(arrayList.get(i));
			}
		}
}
			
		