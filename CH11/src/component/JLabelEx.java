package component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class JLabelEx extends JFrame{
	public JLabelEx(){
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel txtLabel = new JLabel("asdsasd");
		add(txtLabel);
		
		ImageIcon apple = new ImageIcon("images/apple.png");
		Image appleImg = apple.getImage();
		Image changeImg = appleImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		apple = new ImageIcon(changeImg);
		JLabel imgLabel = new JLabel(apple);
		add(imgLabel);
		
		JLabel bothLabel = new JLabel("ssssssssssssssssssssssssss",apple,SwingConstants.CENTER);
		add(bothLabel);
		this.setTitle("title");
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JLabelEx();
	}
}
