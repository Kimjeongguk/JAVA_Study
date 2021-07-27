package ch02;

import java.util.Scanner;

public class while01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		int i = 0;
		System.out.println("정수를 입력하세요. -1을 누르면 종료합니다.");
		while(i != -1) {
			sum+=i;
			i = scanner.nextInt();
			count++;
		}
		System.out.println(sum/(--count));
		
	}

}
