package event;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import event.KeyCodeEx.MyKey;

public class TextMoveEx extends JFrame{
	private JLabel label = new JLabel("hello");
	public TextMoveEx() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKey1());
		
		contentPane.add(label);
		label.setLocation(100, 50);
		label.setSize(100,20);
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		this.setVisible(true);
	}
	class MyKey1 extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				label.setLocation(label.getX()-10, label.getY());
				break;
			case KeyEvent.VK_RIGHT:
				label.setLocation(label.getX()+10, label.getY());
				break;
			case KeyEvent.VK_UP:
				label.setLocation(label.getX(), label.getY()-10);
				break;

			case KeyEvent.VK_DOWN:
				label.setLocation(label.getX(), label.getY()+10);
				break;

			}
		}
	}
	public static void main(String[] args) {
		new TextMoveEx();
	}
}
