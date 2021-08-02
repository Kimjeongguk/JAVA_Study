package generics;

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		
		v.add(1);
		v.add(23);
		v.add(53);
		System.out.println(v);
		
		v.add(3,2000);
		int num = v.get(2);
		System.out.println(num);
		System.out.println(v.size());
		
		for (int i=0; i<v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}
