package ch03;

public class Circle03 {
	int radius;
	
	Circle03(int radius){
		this.radius = radius;
	}
	
	public static void main(String[] args) {
		Circle03 firstCircle = new Circle03(1);
		Circle03 secondCircle = new Circle03(2);
		Circle03 thirdCircle;
		thirdCircle = secondCircle;
		firstCircle = secondCircle;
		System.out.println("fistCircle의 반지름은 ==="+firstCircle.radius);
		System.out.println("secondCircle의 반지름은 ==="+secondCircle.radius);
	}
}
