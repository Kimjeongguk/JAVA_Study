package example;

import java.util.Calendar;
import java.util.Scanner;

class Person {
	String name;
	int time;
	
	Person(String name){
		this.name = name;
		this.time = 0;
	}
}
public class ch06 {
	static Calendar now;
	static Scanner scanner = new Scanner(System.in);
	int a;
	int b;
	public static int start() {
		System.out.println("시작 <Enter>키>>");
		scanner.nextLine();
		now = Calendar.getInstance();
		int s = now.get(Calendar.SECOND);
		System.out.println(s);
		System.out.println("10초 예상 후 <Enter>키>>");
		scanner.nextLine();
		now = Calendar.getInstance();
		int e = now.get(Calendar.SECOND);
		System.out.println(e);
		if (e < s)
			e = e+60;
		return e-s;
	}
	public static void end() {
		
	}
	public static void main(String[] args) {
		Person H = new Person("황기태");
		Person L = new Person("이재문");
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
		
		H.time = start();
		L.time = start();
		
		
		System.out.println("황기태의 결과 "+H.time+", 이재문의 결과 "+L.time+", 승자는 " );
		H.time = Math.abs(H.time-10);
		L.time = Math.abs(L.time-10);
		System.out.println(H.time > L.time ? "이재문" : "황기태");
	}
}
