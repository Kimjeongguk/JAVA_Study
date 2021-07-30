package etc;
import base.Shape;
public class Calc extends Shape {
	private int x, y;
	public Calc(int x, int y) {this.x =x; this.y = y;}
	public int sum() {return x+y; }
}
