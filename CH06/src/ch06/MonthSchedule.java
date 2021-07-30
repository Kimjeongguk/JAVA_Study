package ch06;

import java.util.Scanner;

class Day {
	private String work;
	public void set(String work) {this.work = work;}
	public String get() { return work; }
	public void show() {
		if(work == null) {
			System.out.println("없습니다.");
		}else {
			System.out.println(work + "입니다.");
		}
	}
}

public class MonthSchedule {
	private int nDays;
	int click = 0;
	int day;
	private Day days[];
	Scanner scanner;
	public MonthSchedule(int nDays) {
		scanner = new Scanner(System.in);
		this.nDays = nDays;
		this.days = new Day[nDays];
		for (int i=0; i<days.length; i++) {
			days[i] = new Day();
		}
	}
	
	public void input() {
		System.out.println("날짜(1~"+nDays+") >>>");
		while(true) {
			day = scanner.nextInt();
			scanner.nextLine();
			if (day < 0 || day > nDays) {
				System.out.println("다시 입력");
			}else {
				break;
			}
		}
		System.out.println("할일(빈칸없이입력)?  >>>");
		days[day-1].set(scanner.nextLine());
	}
	public void view() {
		for(int i=0; i<days.length; i++) {
			if (days[i].get() == null) {
				continue;
			}
			System.out.println(i+1 + "일의 할 일은 "+ days[i].get()+ "입니다.");
		}
	}
	public void finish() {
		System.out.println("프로그램을 종료합니다.");
		scanner.close();
	}
	public void run() {
		
		System.out.println("이번달 스케쥴 관리 프로그램.");
		while(true) {
			System.out.println("할일(입력:1, 보기:2, 끝내기:3) >>>");
			click = scanner.nextInt();
			switch (click) {
			case 1:
				input();
				break;
			case 2:
				view();
				break;
			case 3:
				finish();
				return;
			default:
				System.out.println("잘못 클릭했습니다.");	
			}
			
		}
	}
	public static void main(String[] args) {
		MonthSchedule august = new MonthSchedule(31);
		august.run();
	}
}
