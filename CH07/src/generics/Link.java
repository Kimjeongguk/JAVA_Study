package generics;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Link {
	
	private static void printTime(List<Integer> list) {
		double start = System.currentTimeMillis();
		for (int i=0; i<10000000; i++) {
			list.add(i);
		}
		double end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	public static void main(String[] args) {
		List<Integer> linkedList = new LinkedList<Integer>();
		List<Integer> arrayList = new ArrayList<Integer>();
		System.out.println("array");
		printTime(arrayList);
		System.out.println("link");
		printTime(linkedList);
	}
}
