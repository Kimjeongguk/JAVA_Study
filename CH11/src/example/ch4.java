package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ch4 extends JFrame{
	private int units[] = {50000,10000,1000,500,100,50,10,1};
	private String unitTitles[] = {"오만원","만원","천원","오백원","백원","오십원","십원","일원"};
	private JTextField tf[] = new JTextField[8];
	private JCheckBox chks[] = new JCheckBox[7];
	public ch4() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		Container contentPane = this.getContentPane();
//		contentPane.setLayout(new FlowLayout());
		
		contentPane.setBackground(new Color(255,0,0));
		JPanel topPanel = new JPanel();
		JPanel contentsPanel = new JPanel();
		JLabel title = new JLabel("금액");
		JTextField money = new JTextField("금액입력", 15);
		JButton btn = new JButton("계산");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int inputMoney = Integer.parseInt(money.getText());
				int res;
				for (int i=0; i<units.length; i++) {
					
					if(i<units.length-1) {
//						System.out.println(chks[i].isSelected());
						if(!chks[i].isSelected()) {
							tf[i].setText("0");
							continue;
						}
					}
					res = inputMoney/units[i];
					tf[i].setText(Integer.toString(res));
					if(res>0) {
						inputMoney = inputMoney%units[i];
					}
				}
			}
		});
		
		topPanel.add(title);
		topPanel.add(money);
		topPanel.add(btn);
		contentsPanel.setLayout(new GridLayout(8,3,10,10));
		
		for(int i=0; i<units.length; i++) {
			contentsPanel.add(new JLabel(unitTitles[i]));
			tf[i] = new JTextField(15);
			contentsPanel.add(tf[i]);
			if (i<units.length-1) {
				chks[i] = new JCheckBox();
				contentsPanel.add(chks[i]);
			}
			
		}
//		for(int j=0; j<chks.length; j++) {
//			chks[j] = new JCheckBox();
//			contentsPanel.add(chks[j]);
//		}
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(contentsPanel, BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ch4();
	}
}
