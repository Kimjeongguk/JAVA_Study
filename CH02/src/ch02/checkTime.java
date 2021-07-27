package ch02;

public class checkTime {
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int j=i; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int i=5;
		while(i>0) {
			int j=i;
			while(j>0) {
				System.out.print("*");
				j--;
			}
			i--;
			System.out.println();
		}
		i=5;
		do {
			int j =i;
			do {
				j--;
				System.out.print("*");
			}while(j>0);
			i--;
			System.out.println();
		}while(i>0);
		
		//for(;;) = 무한루프
		int sum=0;
		for(int k=1; k<=100; k++) {
			if (k%3==0) {
				sum+=k;
			}
		}
		System.out.println("3배수의 합 = "+sum);
	}
	
	
}
