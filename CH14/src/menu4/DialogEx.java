package menu4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MyDialog extends JDialog {
	public MyDialog(JFrame frame, String title) {
		super(frame,title,true);
		this.setSize(300,200);
	}
}

public class DialogEx extends JFrame{
	Container contentPane;
	private MyDialog dialog;
	public DialogEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JButton btn = new JButton("show dialog");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		this.setSize(800,600);
		this.setVisible(true);
		contentPane.add(btn);
		dialog = new MyDialog(this, "MyDialog 입니다.");
	}
	public static void main(String[] args) {
		new DialogEx();
	}
}
