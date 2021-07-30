package ch06;

class Rect {
	private int width;
	private int height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public boolean equals(Object obj) {
		Rect r = (Rect)obj;
		if (this.width == r.width && this.height == r.height) {
			return true;
		}else {
			return false;
		}
	}
}

public class RectEqualsEx {
	public static void main(String[] args) {
		Rect r01 = new Rect(10,10);
		Rect r02 = new Rect(10,10);
		System.out.println(r01.equals(r02));
	}
}
