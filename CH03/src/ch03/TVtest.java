package ch03;

class TV {
	private int size;
	private String manufacturer;
	public TV() {
		this(0,"");
	}
	public TV(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public TV(int size, String manufacturer) {
		this.size = size;
		this.manufacturer = manufacturer;
	}
}


public class TVtest{
	public static void main(String[] args) {
		TV myTV = new TV();
	}
}