package example;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ch01 extends JFrame {
	public ch01() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JCheckBox ck01 = new JCheckBox("버튼활성화");
		JCheckBox ck02 = new JCheckBox("버튼 비활성화");
		
		JButton btn = new JButton("Test Button");
		
		ck01.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					btn.setEnabled(true);
				}else {
					btn.setEnabled(false);
				}
			}
		});
		ck02.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);
				}
			}
		});
		
		contentPane.add(ck01);
		contentPane.add(ck02);
		contentPane.add(btn);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ch01();
	}
}
