package component;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextAreaEx extends JFrame{
	public TextAreaEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JTextArea ta = new JTextArea(10,20);
		JTextField tf = new JTextField(20);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(tf.getText());
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
		});
		
		
		contentPane.add(new JLabel("입력후 엔터키치세요"));
		contentPane.add(tf);
		contentPane.add(new JScrollPane(ta));
		
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TextAreaEx();
	}
}
