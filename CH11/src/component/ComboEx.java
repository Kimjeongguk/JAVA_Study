package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboEx extends JFrame {
	private String fruits[] = {"apple", "banana", "kiwi", "mango", "pear", "peach"};
	private ImageIcon images[] = {new ImageIcon("images/apple1.png"),new ImageIcon("images/apple2.png"),new ImageIcon("images/apple3.png")};
	private JLabel imgLabel = new JLabel(images[0]);
	public ComboEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox<String> strCombo = new JComboBox<String>(fruits);
		contentPane.add(strCombo);
		contentPane.add(imgLabel);
		strCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = strCombo.getSelectedIndex();
				imgLabel.setIcon(images[idx]);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ComboEx();
	}
}
