package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class ch04 extends JFrame{
	private int posX;
	private int posY;
	MyPanel myPanel = new MyPanel();
	private Point pressedPoint = null;
	public ch04() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		this.setContentPane(myPanel);
		
		
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple1.png");
		private Image img = icon.getImage();
		private int w, h;
		private int x = 100;
		private int y = 100;
		private boolean isDrag = false;
		public MyPanel() {
			w = img.getWidth(this);
			h = img.getHeight(this);
			pressedPoint = null;
			this.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
//					pressedPoint = e.getPoint();
					isDrag=false;
				}
				public void mousePressed(MouseEvent e) {
					pressedPoint = e.getPoint();
					if(pressedPoint.x>=x && pressedPoint.x <= x+w) {
						if(pressedPoint.y>=y && pressedPoint.y <= y+h) {
							isDrag = true;
						}
					}
				}
			});
			this.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					if(isDrag) {
						Point mousePoint = e.getPoint();
						x=x+mousePoint.x - pressedPoint.x;
						y=y+mousePoint.y - pressedPoint.y;
						pressedPoint = mousePoint;
						repaint();
					}
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, x, y, w, h, this);
		}
	}
	public static void main(String[] args) {
		new ch04();
	}
}
