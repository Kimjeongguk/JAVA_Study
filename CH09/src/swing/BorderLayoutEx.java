package swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame{
	public BorderLayoutEx() {
		this.setTitle("BorderLayoutEx");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = new Container();
		c.setLayout(new BorderLayout(10,10));
		add(new JButton("Calc"), BorderLayout.CENTER);
		add(new JButton("add"), BorderLayout.NORTH);
		add(new JButton("sub"), BorderLayout.SOUTH);
		add(new JButton("mul"), BorderLayout.EAST);
		add(new JButton("div"), BorderLayout.WEST);
		
		
	}
	public static void main(String[] args) {
		BorderLayoutEx blex = new BorderLayoutEx();
	}
}
