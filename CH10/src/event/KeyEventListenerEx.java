package event;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyEventListenerEx extends JFrame{
	public KeyEventListenerEx() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKeyListener02());
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		this.setVisible(true);
	}
	class MyKeyListener02 extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			System.out.println(keyCode+"==="+keyChar);
		}
	}
	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}
	public static void main(String[] args) {
		new KeyEventListenerEx();
	}
}
