package array;

import java.util.Scanner;

public class Array01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5];
		int intArray2[] = {1,2,3,4,5,6,7};
		int max = 0;
		for(int i =0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
			if(intArray[i]>max) {
				max = intArray[i];
			}
		}
		scanner.close();
		for(int j=0; j<intArray.length; j++) {
			System.out.println(intArray[j]);
		}
		System.out.println("제일 큰 숫자는 "+max+"입니다.;");
	}

}
