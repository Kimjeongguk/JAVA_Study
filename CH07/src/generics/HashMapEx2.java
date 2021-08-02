package generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("kim", 90);
		h.put("lee", 12);
		h.put("park", 45);
		h.put("cho", 74);
		
		Set<String> keys = h.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + h.get(key));
		}
	}
}
