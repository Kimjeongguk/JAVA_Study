package generics;

import java.util.Vector;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class PointVectorEx {
	public static void main(String[] args) {
		Vector<Point> vp = new Vector<Point>();
		vp.add(new Point(1,2));
		vp.add(new Point(21,122));
		vp.add(new Point(51,232));
		vp.add(new Point(2341,32));
		
		System.out.println(vp);
		
		vp.remove(0);
		System.out.println(vp);
		
		vp.clear();
		System.out.println(vp);
	}
}
