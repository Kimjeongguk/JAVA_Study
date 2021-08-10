package swing;

import java.awt.*;
import javax.swing.*;

public class DrawImage extends JFrame {
	MyPanel myPanel = new MyPanel();
	
	public DrawImage() {
		this.setTitle("title");
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setSize(400,400);
	      this.setContentPane(myPanel);
	      
	      this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.png");
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
//			g.drawImage(img,0,0,this);
//			g.drawImage(img, 0, 0, getWidth(),this.getHeight(), this);
			g.setClip(100,20,200,150);
			g.setColor(Color.RED);
			g.setFont(new Font("맑은 고딕", Font.BOLD,50));
			g.drawImage(img,0,0,this);
			g.drawString("iisssssssssssssssii", 10, 150);
		}
	}
	public static void main(String[] args) {
		new DrawImage();
	}
}
