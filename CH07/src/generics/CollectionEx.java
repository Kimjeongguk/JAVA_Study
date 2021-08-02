package generics;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionEx {
	private static void printList(List<String> list) {
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			String seperator;
			if(it.hasNext()) {
				seperator = "->";
			}else {
				seperator = "\n";
			}
			System.out.print(str+seperator);
		}
	}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("터미네이터");
		myList.add(0,"엔드게임");
		myList.add(2,"아바타");
		
		Collections.sort(myList);
		printList(myList);
		Collections.reverse(myList);
		printList(myList);
		
		int index = Collections.binarySearch(myList, "아바타") + 1;
		System.out.println(index);
	}
}
