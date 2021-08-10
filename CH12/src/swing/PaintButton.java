package swing;

import java.awt.*;

import javax.swing.*;

public class PaintButton extends JFrame{
	public PaintButton() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		Container contentPane = this.getContentPane();
		contentPane.add(new MyButton("뭐 어쩌라고"));

		this.setVisible(true);
	}
	class MyButton extends JButton {
		public MyButton(String str) {
			super(str);
		}
		public void paintComponebt(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(0, 0, this.getWidth()-1, this.getHeight()-1);
		}
	}
	
	public static void main(String[] args) {
		new PaintButton();	
	}
}
