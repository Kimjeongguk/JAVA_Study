package example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ch03 extends JFrame {
	public ch03() {
		this.setTitle("title");
		this.setSize(800,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container contentPane = this.getContentPane();
		
		contentPane.setLayout(new GridLayout(1,10));
		
		for(int i=0; i<10; i++) {
			add(new JButton("btn"+(i+1)));
		}
		
		
	}
	public static void main(String[] args) {
		new ch03();
	}
}
