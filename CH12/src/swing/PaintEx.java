package swing;

import java.awt.*;
import javax.swing.*;

public class PaintEx extends JFrame {
	MyPanel myPanel = new MyPanel();
	public PaintEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setContentPane(myPanel);
		
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			 for(int j=0;j<10;j++) {
	            for(int i=0;i<10;i++) {
	               g.setColor(Color.RED);
	               g.drawRect(30*i, 30*j, 30, 30);
	            }
	         }
		}
	}
	public static void main(String[] args) {
		new PaintEx();	
	}
}
