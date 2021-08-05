package event;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import event.KeyEventListenerEx.MyKeyListener02;

public class KeyCodeEx extends JFrame{
	Container contentPane;
	public KeyCodeEx() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKey());
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		this.setVisible(true);
	}
	class MyKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("Key pressd");
			char keyChar = e.getKeyChar();
			int keyCode = e.getKeyCode();
			if (keyChar == '%') {
				System.out.println("%눌렀음");
				contentPane.setBackground(Color.YELLOW);
			}else if(keyCode == KeyEvent.VK_F1) {
				System.out.println("F1눌렀음");
				contentPane.setBackground(Color.GREEN);
			}
		}
	}
	public static void main(String[] args) {
		new KeyCodeEx();
	}
}
