package ch03;

import java.util.Scanner;

class CurrencyConverter {
	private static double rate;
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}
	public static double toDollar(double won) {
		return won/rate;
	}
	public static double toWon(double dollar) {
		return dollar * rate;
	}
	
}
public class StaticTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1달러에 해당하는 환율을 입력하세요.");
		double rate = scanner.nextDouble();
		CurrencyConverter.setRate(rate);
		System.out.println("백만원을 달러로 바꾸면"+ CurrencyConverter.toDollar(1000000));
		System.out.println("백달러는 "+ CurrencyConverter.toWon(100));
	}
}
