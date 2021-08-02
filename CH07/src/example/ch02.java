package example;

import java.util.ArrayList;
import java.util.Scanner;

public class ch02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> ary = new ArrayList<String>();
		System.out.println("6개의 학점을 빈칸 구분하여 입력(A/B/C/D/F)");
		for(int i=0; i<6; i++) {
			ary.add(scanner.next());
		}
		double sum = 0;
		for(int i=0; i<ary.size(); i++) {
			switch(ary.get(i)) {
			case "A":
				sum+=4.0;
				break;
			case "B":
				sum+=3.0;
				break;
			case "C":
				sum+=2.0;
				break;
			case "D":
				sum+=1.0;
				break;
			default:
				sum+=0.0;
				break;
			}
		}
		System.out.println(sum/ary.size());
	}
}
