package example;

import java.util.HashMap;
import java.util.Scanner;

public class ch03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		System.out.println("나라이름 인구 입력>>>>>(Korea 5000)");
		while(true) {
			String country = scanner.next();
			if (country.equals("그만")) {
				break;
			}
			int count = scanner.nextInt();
			h.put(country, count);
		}
		scanner.nextLine();
		while(true) {
			System.out.println("인구 검색>>>>");
			String country = scanner.nextLine();
			if (country.equals("그만")) {
				break;
			}else if(h.get(country) == null) {
				System.out.println("없음 ");
			}
			else {
				System.out.println(h.get(country));
			}
		}
	}
}
