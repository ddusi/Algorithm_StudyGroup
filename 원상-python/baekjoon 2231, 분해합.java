package jump2java;

import java.util.Scanner;

public class ����2231��_������ {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int size = String.valueOf(n).length();
		//���ڿ��� �޾Ƽ� �ڸ����� ����.
		int start = n - (9 * size);
		//ã�ƺ��� ������ �ּҰ�
		//�ּҰ����� �����ؾ� �������� ���� ���� ���� ���� �� ����.
		int anser = 0;
		
		// N�� �������� �� �ڸ������� ������ ����.
		//int N1 = N % 10;
		//N = N / 10;
		
		for(int i = start; i<n; i++) {
			int sum = i; //��
			int x = i;
			// ������ �� �ڸ����� ���� �ʿ��ϴϱ� ���� x�Ѱ��� ����.
			while(x > 0) {
				sum += x % 10;
				x /= 10;
				// x���� 0�̵Ǹ� while false 
				// sum + x�� ���ڸ����� ��
			}
			if(sum == n) {
				anser = i;
				break;
			}
		}
		System.out.println(anser);
	}
}

