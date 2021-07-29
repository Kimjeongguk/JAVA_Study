package ch05;

class Point {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void showPoint() {
		System.out.println("("+x+","+y+")");
	}
}
class ColorPoint extends Point {
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void showColorPoint() {
		System.out.println(color);
		showPoint();
	}
}
public class ColorPointEx {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(10);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.setX(20);
		cp.setY(20);
		cp.setColor("red");
		cp.showColorPoint();
	}
}
