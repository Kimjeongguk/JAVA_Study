package example;

import java.util.Scanner;

public class ch09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int user;
		int computer;
		while(true) {
			System.out.println("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>>");
			user = scanner.nextInt();
			computer = (int)Math.random()*3 + 1;
			if (user == 4) {
				return;
			}
			if (user==1 && computer == 3) {
				System.out.println("철수 (가위) : 컴퓨터(보)");
				System.out.println("철수가 이겼습니다.");
			} else if (user==2 && computer == 1) {
				System.out.println("철수 (바위) : 컴퓨터(가위)");
				System.out.println("철수가 이겼습니다.");
			}else if (user==3 && computer == 2) {
				System.out.println("철수 (보) : 컴퓨터(바위)");
				System.out.println("철수가 이겼습니다.");
			}else if (user==3 && computer == 2) {
				System.out.println("철수 (보) : 컴퓨터(바위)");
				System.out.println("컴퓨터가 이겼습니다.");
			}else if (user==3 && computer == 2) {
				System.out.println("철수 (보) : 컴퓨터(바위)");
				System.out.println("컴퓨터가 이겼습니다.");
			}else if (user==3 && computer == 2) {
				System.out.println("철수 (보) : 컴퓨터(바위)");
				System.out.println("컴퓨터가 이겼습니다.");
			} 
		
		}
	}
}
