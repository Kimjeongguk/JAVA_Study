package ch05;

abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int sub(int a, int b);
	public abstract double average(int[] a);
}
public class GoodCalc extends Calculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		for(int i=0; i<a.length; i++) {
			sum+=a[i];
		}
		return sum/a.length;
	}
	
}
