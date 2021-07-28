package ch01;

import java.util.Scanner;

public class ScannerTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		
		int number = scanner.nextInt();
		int h = number / (60*60);
		int m = (number % (60*60)) / 60;
		int s = (number % (60*60)) % 60;
		System.out.println(h+"시간"+ m+"분" +s+"초");
	}

}
