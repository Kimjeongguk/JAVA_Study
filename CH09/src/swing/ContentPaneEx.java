package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame{
	public ContentPaneEx() {
		this.setTitle("ContnetPane 과 JFrame");
		this.setSize(300,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(Color.orange);
		add(new JButton("btn01"));
		this.add(new JButton("btn02"));
		add(new JButton("btn03"));
		
	}
	public static void main(String[] args) {
		ContentPaneEx contentPaneEx = new ContentPaneEx();
	}
}
