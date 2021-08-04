package example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
class NorthPanel3 extends JPanel {
	public NorthPanel3() {
		
		this.setBackground(Color.GRAY);
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.add(new JButton("open"));
		this.add(new JButton("read"));
		this.add(new JButton("close"));
		
	}
}
class CenterPanel3 extends JPanel {
	public CenterPanel3() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setOpaque(true);
		this.setLayout(null);
		JLabel label1 = new JLabel("hello");
		label1.setBounds(50, 50, 100, 20);
		JLabel label2 = new JLabel("love");
		label2.setBounds(100, 150, 100, 20);
		JLabel label3 = new JLabel("java");
		label3.setBounds(200, 140, 100, 20);
		this.add(label1);
		this.add(label2);
		this.add(label3);
	}
}
public class WordGame extends JFrame {
	public WordGame() {
		this.setTitle("title");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		add(new NorthPanel3(),BorderLayout.NORTH);
		add(new CenterPanel3(),BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new WordGame();
	}
}
