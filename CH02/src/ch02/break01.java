package ch02;

import java.util.Scanner;

public class break01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("exit를 쓰면 종료.");
		while(true) {
			System.out.println(">>>>");
			String txt = scanner.nextLine();
			if(txt.equals("exit")) {
				break;
			}
		}
		System.out.println("끝");
		scanner.close();
	}

}
