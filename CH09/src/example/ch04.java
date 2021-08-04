package example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ch04 extends JFrame {
	public ch04() {
		this.setTitle("title");
		this.setSize(800,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container contentPane = this.getContentPane();
		
		contentPane.setLayout(new GridLayout(1,10));
		Color colors[] = {
				Color.RED,
				Color.GREEN,
				Color.BLUE,
				Color.PINK,
				Color.YELLOW,
				Color.GRAY,
				Color.ORANGE,
				Color.MAGENTA,
				Color.DARK_GRAY,
				Color.BLACK
		};
		for(int i=0; i<10; i++) {
			JButton btns = new JButton("btn"+i);
			btns.setBackground(colors[i]);
			add(btns);
		}
		
		
	}
	public static void main(String[] args) {
		new ch04();
	}
}
