package thread;

class SharedBoard {
	private int sum = 0;
	synchronized public void add() {
		int n = sum;
		n+=10;
		sum = n;
		System.out.println(Thread.currentThread().getName()+":"+sum);
		
	}
}

class StudentThread extends Thread {
	private SharedBoard board;
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			this.board.add();
		}
	}
}

public class SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		StudentThread th01 = new StudentThread("name", board);
		StudentThread th02 = new StudentThread("name2", board);
		th01.start();
		th02.start();
	}
}
