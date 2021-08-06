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


public class JButtonEx extends JFrame{
	public JButtonEx(){
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon icon1 = new ImageIcon("images/apple1.png");
		ImageIcon icon2 = new ImageIcon("images/apple2.png");
		ImageIcon icon3 = new ImageIcon("images/apple3.png");
		
		JButton btn = new JButton(icon1);
		btn.setBorderPainted(false);//테두리 투명처리
		btn.setContentAreaFilled(false);//포커스 일때 투명처리
		btn.setRolloverIcon(icon2);
		btn.setPressedIcon(icon3);
		btn.setFocusPainted(false);//버튼이 원래 가지고있는 배경 투명 처리
		add(btn);
		this.setTitle("title");
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JButtonEx();
	}
}
