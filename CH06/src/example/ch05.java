package example;

import java.util.Calendar;

public class ch05 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int h = now.get(Calendar.HOUR);
		int h1 = now.get(Calendar.HOUR_OF_DAY);
		int m = now.get(Calendar.MINUTE);
		System.out.println("현재시간은 "+h+"시 "+m+"분 입니다.");
		if (h1 >= 4 && h1 < 12) {
			System.out.println("Good Morning");
		}else if (h1 >= 12 && h1 < 18) {
			System.out.println("Good Afternoon");
		}else if (h1 >= 18 && h1 < 20) {
			System.out.println("Good Evening");
		}else {
			System.out.println("Good Night");
		}
	}
}
