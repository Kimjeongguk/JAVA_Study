package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ch01 extends JFrame{
	private MyPanel myPanel = new MyPanel();
	public ch01() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		this.setContentPane(myPanel);
		
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.png");
		private Image img = icon.getImage();
		private JButton btn = new JButton("SHOW/HIDE");
		private boolean isShow = true;
		
		public MyPanel() {
			this.add(btn);
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					isShow = !isShow;
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(isShow) {
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	}
	public static void main(String[] args) {
		new ch01();
	}
}
