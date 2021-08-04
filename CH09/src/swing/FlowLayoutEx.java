package swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		this.setTitle("flowlayout연습");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		add(new JButton("add"));
		add(new JButton("sub"));
		add(new JButton("div"));
		add(new JButton("mul"));
		add(new JButton("calc"));
	}
	public static void main(String[] args) {
		FlowLayoutEx flex = new FlowLayoutEx();
	}
}
