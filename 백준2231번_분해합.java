package jump2java;

import java.util.Scanner;

public class 백준2231번_분해합 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int size = String.valueOf(n).length();
		//문자열로 받아서 자릿수를 구함.
		int start = n - (9 * size);
		//찾아보기 시작한 최소값
		//최소값부터 시작해야 분해합의 가장 작은 값을 구할 수 있음.
		int anser = 0;
		
		// N의 변수값을 각 자리수별로 나눠서 저장.
		//int N1 = N % 10;
		//N = N / 10;
		
		for(int i = start; i<n; i++) {
			int sum = i; //합
			int x = i;
			// 어차피 각 자릿수의 합이 필요하니까 변수 x한개만 선언.
			while(x > 0) {
				sum += x % 10;
				x /= 10;
				// x값이 0이되면 while false 
				// sum + x의 각자릿수별 값
			}
			if(sum == n) {
				anser = i;
				break;
			}
		}
		System.out.println(anser);
	}
}

