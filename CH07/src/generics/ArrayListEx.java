package generics;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> a = new ArrayList<String>();
		int index = 0;
		for (int i=0; i<4; i++) {
			a.add(scanner.nextLine());
			if(a.get(index).length() < a.get(i).length() ) {
				index = i;
			}
		}
		for (int i=0; i<a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("가장긴거>>>" + a.get(index));
		
	}
}
