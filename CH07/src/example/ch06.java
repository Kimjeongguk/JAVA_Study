package example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Location {
	private String city;
	private int x;
	private int y;
	public Location(String city, int x, int y){
		this.city = city;
		this.x = x;
		this.y = y;
	}
	public void printMap() {
		System.out.println(this.city+"\t"+this.x+"\t"+this.y);
	}

}
public class ch06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Location> h = new HashMap<String, Location>();
		System.out.println("도시, 경도, 위도를 입력하세요.");
		for(int i=0; i<4; i++) {
			String info = scanner.nextLine();
			String[] infoList = info.split(", ");
			h.put(infoList[0],new Location(infoList[0],Integer.parseInt(infoList[1]),Integer.parseInt(infoList[2])));
		}
		Set<String> keys = h.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			h.get(key).printMap();	
			System.out.println("=======================");
		}
		while(true) {
			System.out.println("도시이름>>>>>>>");
			String key = scanner.nextLine();
			if(key.equals("그만")) {
				break;
			}
			if(h.get(key) == null) {
				System.out.println(key+"정보없음");
			}else {
				h.get(key).printMap();
			}
			
		}
	}
}
