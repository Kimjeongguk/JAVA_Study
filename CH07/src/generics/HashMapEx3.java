package generics;

import java.util.HashMap;
import java.util.Scanner;

class Student {
	private int id;
	private String tel;
	
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public String getTel() {
		return tel;
	}
}
public class HashMapEx3 {
	public static void main(String[] args) {
		HashMap<String, Student> h = new HashMap<String, Student>();
		
		h.put("가나다", new Student(1, "010-1234-1234"));
		h.put("라마바", new Student(2, "010-1212-1111"));
		h.put("사아자", new Student(3, "010-3434-2222"));
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String name = scanner.nextLine();
			if(name.equals("exit")) {
				break;
			}else if (h.get(name) == null) {
				System.out.println("정보없음");
			}else {
				System.out.println(h.get(name).getId() + "  " + h.get(name).getTel());
			}
		}
		
	}
	
	
}
