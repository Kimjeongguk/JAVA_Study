package event;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import event.TextMoveEx.MyKey1;

public class MouseListenerEx extends JFrame{
	private JLabel label = new JLabel("mouse event");
	public MouseListenerEx() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		myMouseListener myMouseListener = new myMouseListener();
//		contentPane.addKeyListener(new MyKey1());
		contentPane.addMouseListener(myMouseListener);
		contentPane.addMouseMotionListener(myMouseListener);
		contentPane.add(label);
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		this.setVisible(true);
	}
	class myMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			label.setText("Dragged ("+(e.getX()+","+e.getY()+")"));
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			label.setText("Moved ("+(e.getX()+","+e.getY()+")"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Container contentPane = (Container)e.getSource();
				contentPane.setBackground(new Color(r,g,b));
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			Component contentPane = (Component)e.getSource();
			contentPane.setBackground(Color.YELLOW);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			Component contentPane = (Component)e.getSource();
			contentPane.setBackground(Color.GREEN);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			label.setText("pressed ("+(e.getX()+","+e.getY()+")"));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}
