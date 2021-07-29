package ch05;

class Shape{
	public Shape() {}
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Line extends Shape{
	public void draw() {
		System.out.println("Line Draw");
	}
}
class Rect extends Shape {

	@Override
	public void draw() {
		System.out.println("Rect Draw");
	}
	
}

class Circle extends Shape{

	@Override
	public void draw() {
		System.out.println("Circle Draw");
	}
	
}

public class MethodOverridingEx {
	static void paint(Shape s) {
		s.draw();
	}
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();
		Line shape1 = new Line();
		shape1.draw();
		
		paint(new Line());
		paint(new Rect());
	}
}
