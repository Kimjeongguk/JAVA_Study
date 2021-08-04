package example;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ch05 extends JFrame {
	public ch05() {
		this.setTitle("title");
		this.setSize(800,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(4,4));
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
				Color.BLACK,
				Color.RED,
				Color.GREEN,
				Color.BLUE,
				Color.PINK,
				Color.YELLOW,
				Color.GRAY
		};
		for(int i=0; i<16; i++) {
			JLabel labels = new JLabel("btn"+i);
			labels.setOpaque(true);
//			labels.setBackground(colors[i]);
			labels.setBackground(new Color(
					(int)Math.round(Math.random()*255),
					(int)Math.round(Math.random()*255),
					(int)Math.round(Math.random()*255)
					));
			add(labels);
		}
		
		
	}
	public static void main(String[] args) {
		new ch05();
	}
}
