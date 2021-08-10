package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class ch02 extends JFrame{
	private MyPanel myPanel = new MyPanel();
	public ch02() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		this.setContentPane(myPanel);
		
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.png");
		private Image img = icon.getImage();
		private int posX = 100;
		private int posY = 100;
		public MyPanel() {
			this.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
					posX = e.getX();
					posY = e.getY();
					repaint();
				}
				@Override
				public void mouseDragged(MouseEvent e) {
					posX = e.getX();
					posY = e.getY();
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.RED);
			g.fillOval(posX, posY, 30, 30);
		}
	}
	public static void main(String[] args) {
		new ch02();
	}
}
