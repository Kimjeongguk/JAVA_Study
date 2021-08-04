package example;

import java.awt.*;

import javax.swing.*;

public class ch02 extends JFrame {
	public ch02() {
		this.setTitle("title");
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container contentPane = this.getContentPane();
		
		contentPane.setLayout(new BorderLayout(10,10));
		add(new JButton("North"),BorderLayout.NORTH);
		add(new JButton("South"),BorderLayout.SOUTH);
		add(new JButton("West"),BorderLayout.WEST);
		add(new JButton("Center"),BorderLayout.CENTER);
		add(new JButton("East"),BorderLayout.EAST);
		
	}
	public static void main(String[] args) {
		new ch02();
	}
}
