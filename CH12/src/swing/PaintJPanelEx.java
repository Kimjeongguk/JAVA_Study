package swing;

import java.awt.*;

import javax.swing.*;

public class PaintJPanelEx extends JFrame {
	MyPanel myPanel = new MyPanel();
	public PaintJPanelEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setContentPane(myPanel); //기존에 JFrame이 가지고있는 기본 컨테이너를 내가 임의로 만든 JPanel로 대체
		
		
		
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}
	public static void main(String[] args) {
		new PaintJPanelEx();
	}
}
