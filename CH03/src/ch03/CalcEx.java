package ch03;


class Calc {
	public static int abs(int num) {
//		if (num<0) {
//			return -num;
//		}
//		return num;
		return num > 0 ? num : -num;
	}
}

public class CalcEx {
	public static void main(String[] args) {
//		abs(-5);
//		Calc calc = new Calc();
		System.out.println(Calc.abs(-5));
	}
}
