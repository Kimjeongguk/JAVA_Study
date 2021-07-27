package ch02;

import java.util.Scanner;

public class continue01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<5; i++) {
			int num = scanner.nextInt();
			if(num < 0) {
				continue;
			}
			sum += num;
		}
		System.out.println(sum);
	}
}
