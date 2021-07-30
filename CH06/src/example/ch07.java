package example;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ch07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		while(true) {
			str = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(str," ");
			if (str.equals("그만")) {
				System.out.println("종료합니다...");
				return;
			}
			
			System.out.println("어절의 개수는 " + st.countTokens());
		}
	}
}
