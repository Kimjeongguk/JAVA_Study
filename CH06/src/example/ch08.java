package example;

import java.util.Scanner;

public class ch08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력 하세요. 빈칸 있어도 되고 영어 한글 모두 가능");
		String str = scanner.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			str = str.substring(1)+str.charAt(0);
			System.out.println(str);
		}
	}
}
