package event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e);
		JButton btn = (JButton)e.getSource();
		System.out.println(btn.getText());
	}
	
}

public class IndependentEventListener extends JFrame {
	public IndependentEventListener() {
		this.setTitle("독립클레스 이벤트 리스너");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		add(btn);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new IndependentEventListener();
	}
}
