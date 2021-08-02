package generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("baby","아기");
		h.put("love","사랑");
		h.put("watermelon","수박");
		
		System.out.println(h.get("love"));
		
		Scanner scanner = new Scanner(System.in);
		
		Set<String> keys = h.keySet(); // hashmap에있는 키 다 뽑아오기
		Iterator<String> it = keys.iterator(); // 키를 반복문으로 돌릴수 있음
		
		while(it.hasNext()) {
			System.out.println(h.get(it.next()));
		}
		while(true) {
			System.out.println("찾을단어 >>");
			String value = scanner.nextLine();
			if(value.equals("exit")) {
				break;
			}
			
			String str = h.get(value);
			
			if (str == null) {
				System.out.println("없는단어임");
			}else {
				System.out.println(str);
			}
			
		}
	}
}
