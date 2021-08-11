package thread;

class Food {
	synchronized public void receiveOrder (String Waiter) {
		for(int i=0; i<5; i++) {
			System.out.println(Waiter+ "가 주문을 받습니다.");
		}
		System.out.println(Waiter+"주 문을 주방에 전달");
		System.out.println("===");
	}
	synchronized public void makeFood (String Chef) {
		for(int i=0; i<5; i++) {
			System.out.println(Chef+ "가 음식을 만듬.");
		}
		System.out.println(Chef+"가 음식을 다 만들었습니다.");
		System.out.println("===");
	}
}

class Waiter extends Thread {
	String Waiter;
	Food food;
	public Waiter(String Waiter, Food food) {
		this.Waiter = Waiter;
		this.food = food;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			food.receiveOrder(Waiter);
		}
	}
}

class Chef extends Thread {
	String Chef;
	Food food;
	public Chef(String Chef, Food food) {
		this.Chef = Chef;
		this.food = food;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			food.makeFood(Chef);
		}
	}
}

public class Restaurant {
	public static void main(String[] args) {
		Food food = new Food();
		Waiter waiter = new Waiter("웨이터", food);
		Chef chef = new Chef("요리사",food);
		waiter.start();
		chef.start();
	}
}
