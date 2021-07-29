package ch05;

class AA{
	public AA() {
		System.out.println("default a");
	}
	public AA(int x) {
		System.out.println("a");
	}
}
class BB extends AA{
	public BB() {
		System.out.println("default b");
	}
	public BB(int x) {
		super(x);
		System.out.println("b");
	}
}

public class ConstructorEx02 {
	public static void main(String[] args) {
		BB b = new BB(3);
	}
}
