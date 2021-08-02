package example;

import java.util.Scanner;
import java.util.Vector;

public class ch01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Vector<Integer> v = new Vector<Integer>();
		int index = 0;
		System.out.println("-1 립력하면 종료");
		while(true) {
			int a = scanner.nextInt();
			if (a == -1) {
				break;
			}
			v.add(a);
			if (v.get(index) < a) {
				index = v.size()-1;
			}
		}
		System.out.println("가장큰수 ==>" + v.get(index));
	}
}
