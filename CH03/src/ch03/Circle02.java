package ch03;

public class Circle02 {
	int radius;
	String name;
	
	Circle02(){
		radius=1;
		name = "noname";
	}
	
	Circle02(int r, String n){
		radius = r;
		name = n;
	}
	
	double getArea() {
		return radius*radius*3.14;
	}
	
	
	public static void main(String[] args) {
		Circle02 pizza = new Circle02();
		Circle02 donut = new Circle02(20, "던킨");
	}
}
