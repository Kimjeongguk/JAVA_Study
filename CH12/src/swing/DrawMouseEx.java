package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;


public class DrawMouseEx extends JFrame{
	MyPanel myPanel = new MyPanel();
	public DrawMouseEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setContentPane(myPanel); //기존에 JFrame이 가지고있는 기본 컨테이너를 내가 임의로 만든 JPanel로 대체
		
		
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>();
		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startPoint = e.getPoint();
					vStart.add(startPoint);
				}
				public void mouseReleased(MouseEvent e) {
					Point endPoint = e.getPoint();
					vEnd.add(endPoint);
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0; i<vStart.size(); i++) {
				Point start = vStart.elementAt(i);
				Point end = vEnd.elementAt(i);
				g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
			}
		}
	}
	public static void main(String[] args) {
		new DrawMouseEx();
	}
}
