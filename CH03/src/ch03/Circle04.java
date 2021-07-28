package ch03;

public class Circle04 {
	int radius;
	Circle04(int raduis){
		this.radius = raduis;
	}
	double getArea() {
		return radius*radius*3.14;
	}
	public static void main(String[] args) {
		Circle04 c01 = new Circle04(1);
		Circle04 c02 = new Circle04(2);
		Circle04 c03 = new Circle04(3);
		Circle04 c04 = new Circle04(4);
		Circle04 c05 = new Circle04(5);
		
		Circle04 circleArray[] = new Circle04[5];
		for(int i = 0; i<5; i++) {
			circleArray[i] = new Circle04(i+1);
		}
		System.out.println(circleArray[2].getArea());
	}
}
