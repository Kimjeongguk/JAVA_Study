package menu3;

import java.awt.*;
import javax.swing.*;

public class ToolBarEx extends JFrame {
	Container contentPane;
	public ToolBarEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = this.getContentPane();
		createToolBar();
		
		this.setSize(800,600);
		this.setVisible(true);
	}
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("toolbar");
		toolBar.setBackground(Color.GRAY);
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("images/mystery.png")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/ufo.png")));
		toolBar.add(new JLabel("SEARCH"));
		toolBar.add(new JTextField("Text Field"));
		contentPane.add(toolBar,BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new ToolBarEx();
	}
}
