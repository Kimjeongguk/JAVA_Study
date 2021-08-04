package example;

import javax.swing.JFrame;

public class ch01 extends JFrame {
	public ch01() {
		this.setTitle("title");
		this.setSize(400,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new ch01();
	}
}
