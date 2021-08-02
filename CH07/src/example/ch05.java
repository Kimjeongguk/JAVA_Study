package example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Student {
	private String name;
	private String department;
	private int num;
	private double avg;
	
	public Student(String name, String department, int num, double avg) {
		this.name = name;
		this.department = department;
		this.num = num;
		this.avg = avg;
	}
	
	public void printInfo() {
		System.out.println("이름:"+this.name);
		System.out.println("학과:"+this.department);
		System.out.println("학번:"+this.num);
		System.out.println("학점평균:"+this.avg);
	}
	public void searchPrint() {
		System.out.println(this.name + ", "+ this.department+", "+ this.num + ", "+this.avg);
	}

	public String getName() {
		return name;
	}
}

public class ch05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		ArrayList<Student> sList = new ArrayList<Student>();
//		
//		System.out.println("이름, 학과, 학번, 학점평균 입력하세요.");
//		for(int i=0; i<4; i++) {
//			String info = scanner.nextLine();
//			String[] infoList = info.split(", ");
//			sList.add(new Student(infoList[0],infoList[1],Integer.parseInt(infoList[2]),Double.parseDouble(infoList[3])));
//		}
//		for(int i=0; i<sList.size(); i++) {
//			sList.get(i).printInfo();
//			System.out.println("==========================");
//		}
//		while(true) {
//			System.out.println("학생입력>>>>>>>");
//			String name = scanner.nextLine();
//			if(name.equals("그만")) {
//				break;
//			}
//			for(int i=0; i<sList.size(); i++) {
//				if(sList.get(i).getName().equals(name)) {
//					sList.get(i).searchPrint();
//				}
//			}
//		}
		HashMap<String, Student> h = new HashMap<String, Student>();
		System.out.println("이름, 학과, 학번, 학점평균 입력하세요.");
		for(int i=0; i<4; i++) {
			String info = scanner.nextLine();
			String[] infoList = info.split(", ");
			h.put(infoList[0],new Student(infoList[0],infoList[1],Integer.parseInt(infoList[2]),Double.parseDouble(infoList[3])));
		}
		Set<String> keys = h.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			h.get(key).printInfo();	
			System.out.println("=======================");
		}
		while(true) {
			System.out.println("학생입력>>>>>>>");
			String key = scanner.nextLine();
			if(key.equals("그만")) {
				break;
			}
			if(h.get(key) == null) {
				System.out.println("정보없음");
			}else {
				h.get(key).searchPrint();
			}
			
		}
	}
}
