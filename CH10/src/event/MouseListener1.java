package event;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListener1 extends JFrame {
	public JLabel label = new JLabel("hello");
	public MouseListener1() {
		this.setTitle("sdf");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.addMouseListener(new MListener());
		contentPane.setLayout(null);
		label.setSize(50,20);
		label.setLocation(100,100);
		add(label);
		
		this.setVisible(true);
	}
	class MListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		new MouseListener1();
	}
}
