package ch05;
interface PhoneInterface{
	final int TIMEOUT = 1000;
	void sendCall();
	void receiveCall();
}

interface Mobile extends PhoneInterface {
	public abstract void sendSMS();
	public abstract void receiveSMS();
}

interface MP3 {
	void paly();
	void stop();
}
class PDA {
	public int calculate(int x, int y) {
		return x+y;
	}
}
class SamsungPhone extends PDA implements Mobile, MP3 {

	@Override
	public void sendCall() {
		System.out.println("ballll");
	}
	@Override
	public void receiveCall() {
		System.out.println("receive");
	}
	@Override
	public void paly() {
		System.out.println("play");
	}
	@Override
	public void stop() {
		System.out.println("stop");
	}
	@Override
	public void sendSMS() {
		System.out.println("send message");
	}
	@Override
	public void receiveSMS() {
		System.out.println("receive message");
	}

}


public class InterfaceEx {
	public static void main(String[] args) {
		SamsungPhone sp = new SamsungPhone();
		sp.sendCall();
		sp.receiveCall();
		sp.calculate(1, 2);
		sp.paly();
		sp.stop();
	}
}
