package ch03;

public class Circle {
	int radius;
	String name;
	
	Circle(){
		System.out.println("생성~~~");
	}
	
	double  getArea() {
		return radius*radius*3.14;
	}
	public static void main(String[] args) {
		Circle pizza = new Circle();
		pizza.name = "페페로니";
		pizza.radius = 12;
		double area = pizza.getArea();
		System.out.println("피자이름 :"+pizza.name+"반지름은 : "+pizza.radius+" 면적은 : "+area);
	
		Circle donut = new Circle();
		donut.name = "던킨";
		donut.radius = 5;
		double area2 = donut.getArea();
		System.out.println("도넛이름 :"+donut.name+"반지름은 : "+donut.radius+" 면적은 : "+area2);
	
		
	
	}
}
