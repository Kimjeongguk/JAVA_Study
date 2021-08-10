package money;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeSlider extends JFrame {
	public ChangeSlider() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		Container contentPane = this.getContentPane();
//		contentPane.setBackground(new Color(255,0,0));
		JSlider slider = new JSlider(JSlider.HORIZONTAL,1,100,50);
		JLabel label = new JLabel("I Hate JAVA");
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setFont(new Font("맑은 고딕", Font.BOLD,slider.getValue()/2));
			}
		});
		label.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(slider,BorderLayout.NORTH);
		contentPane.add(label,BorderLayout.CENTER);
		label.setFont(new Font("맑은 고딕", Font.BOLD,25));
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ChangeSlider();
	}
}
