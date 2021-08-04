package example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

class NorthPanel2 extends JPanel {
	public NorthPanel2() {
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.add(new JButton("열기"));
		this.add(new JButton("닫기"));
		this.add(new JButton("나가기"));
		
	}
}
class SouthPanel2 extends JPanel {
	public SouthPanel2() {
		
		this.setBackground(Color.YELLOW);
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		this.add(new JButton("WordInput"));
		this.add(new JTextField(15));
	}
}
class CenterPanel2 extends JPanel {
	public CenterPanel2() {
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setLayout(null);
		for(int i=0; i<10; i++) {
			JLabel label = new JLabel("*");
			label.setSize(20,20);
			label.setForeground(Color.RED);
			label.setLocation((int)Math.round(Math.random()*200+50), (int)Math.round(Math.random()*200+50));
			this.add(label);
		}
		
	}
}
public class ch08 extends JFrame {
	public ch08() {
		this.setTitle("title");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		add(new NorthPanel2(),BorderLayout.NORTH);
		add(new SouthPanel2(),BorderLayout.SOUTH);
		add(new CenterPanel2(),BorderLayout.CENTER);
		
		this.setVisible(true);//다른 컨테이너 또는 컴포넌트를 먼저 로딩하고 마지막에 보이게 하기 위해서 아래쪽에 적어 두는게 좋다.
	}
	public static void main(String[] args) {
		new ch08();
	}
}
