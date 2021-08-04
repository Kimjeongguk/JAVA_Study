package example;

import java.awt.*;

import javax.swing.*;

class NorthPanel extends JPanel {
	public NorthPanel() {
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setOpaque(true);
		this.setLayout(new FlowLayout());
		this.add(new JLabel("수식입력"));
		this.add(new JTextField(20));
	}
}
class SouthPanel extends JPanel {
	public SouthPanel() {
		
		this.setBackground(Color.YELLOW);
		this.setOpaque(true);
		this.setLayout(new FlowLayout());
		this.add(new JLabel("계산 결과"));
		this.add(new JTextField(20));
	}
}
class CenterPanel extends JPanel {
	public CenterPanel() {
		this.setBackground(Color.RED);
		this.setOpaque(true);
		this.setLayout(new GridLayout(4,4,5,5));
		this.add(new JButton("0"));
		this.add(new JButton("1"));
		this.add(new JButton("2"));
		this.add(new JButton("3"));
		this.add(new JButton("4"));
		this.add(new JButton("5"));
		this.add(new JButton("6"));
		this.add(new JButton("7"));
		this.add(new JButton("8"));
		this.add(new JButton("9"));
		this.add(new JButton("CE"));
		this.add(new JButton("계산"));
		this.add(new JButton("+"));
		this.add(new JButton("-"));
		this.add(new JButton("x"));
		this.add(new JButton("/"));
		
	}
}

public class ch07 extends JFrame {
	public ch07() {
		this.setTitle("title");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		add(new NorthPanel(), BorderLayout.NORTH);
		add(new SouthPanel(), BorderLayout.SOUTH);
		add(new CenterPanel(), BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new ch07();
	}
}
