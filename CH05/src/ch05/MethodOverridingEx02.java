package ch05;
 
class Shape02{
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println("Shape");
	}
}
class Circle02 extends Shape02{

	@Override
	public void draw() {
		System.out.println("Circle");
	}
	
}
public class MethodOverridingEx02 {
	public static void main(String[] args) {
		Shape02 b = new Circle02();
		b.paint();
	}
}
