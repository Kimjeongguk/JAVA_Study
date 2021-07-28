package ch01;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.next();
		System.out.println("당신의 이름은 " +name + "이고,");
		
		String city = scanner.next();
		System.out.println("도시는 " +city + "이고,");
		
		int age = scanner.nextInt();
		System.out.println("나이는 " +age+ "이고,");
		
		int weight = scanner.nextInt();
		System.out.println("몸무게는 " +weight+ "이고,");
		
		scanner.close();
	}
}
