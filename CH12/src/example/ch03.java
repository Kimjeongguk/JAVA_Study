package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class ch03 extends JFrame{
	private int posX;
	private int posY;
	private Point pressedPoint = null;
	public ch03() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		ImageIcon icon = new ImageIcon("images/apple1.png");
		JLabel imgLabel = new JLabel(icon);
		contentPane.add(imgLabel);
		imgLabel.setSize(icon.getIconWidth(),icon.getIconHeight());
		imgLabel.setLocation(100, 100);
		
		imgLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				pressedPoint = e.getPoint();
			}
		});
		imgLabel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point endPoint = imgLabel.getLocation();
				Point mousePoint = e.getPoint();
				imgLabel.setLocation(endPoint.x+mousePoint.x-pressedPoint.x, endPoint.y+mousePoint.y-pressedPoint.y);
				
			}
		});
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple1.png");
		private Image img = icon.getImage();
		
	}
	public static void main(String[] args) {
		new ch03();
	}
}
