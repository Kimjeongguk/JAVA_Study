package component;

import java.awt.*;

import javax.swing.*;

public class JTextFieldEx extends JFrame{
	public JTextFieldEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		add(new JLabel("이름"));
		add(new JTextField(20));
		add(new JLabel("학과"));
		add(new JTextField("컴푸터 공학과", 20));
		add(new JLabel("주소"));
		add(new JTextField("서울시...",20));
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTextFieldEx();
	}
}
