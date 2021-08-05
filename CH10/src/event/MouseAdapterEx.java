package event;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseAdapterEx extends JFrame {
	public MouseAdapterEx() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.addMouseListener(new MyMouseAdapter());
		
		
		this.setVisible(true);
	}
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			System.out.println("마우스 어뎁터로 구현");
		}
	}
	public static void main(String[] args) {
		new MouseAdapterEx();
	}
}
