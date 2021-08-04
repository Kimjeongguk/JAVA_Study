package example;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ch06 extends JFrame {
	public ch06() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		for(int i=0; i<20; i++) {
			JLabel label = new JLabel("j"+i);
			label.setBackground(new Color(
					(int)Math.round(Math.random()*255),
					(int)Math.round(Math.random()*255),
					(int)Math.round(Math.random()*255)
					));
			int x = (int)Math.round(Math.random()*200)+50;
			int y = (int)Math.round(Math.random()*200)+50;
			label.setOpaque(true);
			label.setLocation(x,y);
			label.setSize(20,20);
			contentPane.add(label);
		}
	}
	public static void main(String[] args) {
		new ch06();
	}
}
