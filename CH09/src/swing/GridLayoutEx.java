package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class GridLayoutEx extends JFrame {
	public GridLayoutEx() {
		this.setTitle("grid");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		GridLayout grid = new GridLayout(4,2);
		grid.setVgap(10);
		c.setLayout(grid);
		add(new JLabel("이름"));
		add(new JTextField(""));
		add(new JLabel("학번"));
		add(new JTextField(""));
		add(new JLabel("학과"));
		add(new JTextField(""));
		add(new JLabel("과목"));
		add(new JTextField(""));
		
	}
	public static void main(String[] args) {
		GridLayoutEx grid = new GridLayoutEx();
		
	}
}
