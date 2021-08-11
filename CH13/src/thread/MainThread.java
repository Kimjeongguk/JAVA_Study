package thread;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("메인도 하나의 스레드다.=="+Thread.currentThread().getName());
		System.out.println("우선순위"+Thread.MIN_PRIORITY);
		System.out.println("우선순위"+Thread.MAX_PRIORITY);
		System.out.println("우선순위"+Thread.NORM_PRIORITY);
		System.out.println("우선순위"+Thread.currentThread().getPriority());
	}
}
