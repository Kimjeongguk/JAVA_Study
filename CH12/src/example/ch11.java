package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ch11 extends JFrame {
	private String itemNames[] = {"apple","cherry","strawberry","banana"};
	private JTextField tf[] = new JTextField[4];
	private int angles[] = new int[4];
	private int percentages[] = new int[4];
	private Color colors[] = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
	private int data[] = {0,0,0,0};
	ChartPanel chartPanel = new ChartPanel();
	public ch11() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		
		Container contentPane = this.getContentPane();
		InputPanel inputPanel = new InputPanel();
		contentPane.add(inputPanel, BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	class InputPanel extends JPanel {
		public InputPanel() {
			this.setBackground(Color.GRAY);
			this.setPreferredSize(new Dimension(500,50));
			for(int i=0; i<itemNames.length; i++) {
				tf[i] = new JTextField("0",5);
				tf[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JTextField txt = (JTextField)e.getSource();
						int num = Integer.parseInt(txt.getText());
						int sum = 0;
						for(int i=0; i<data.length; i++) {
							data[i] = Integer.parseInt(tf[i].getText());
							sum+=data[i];
						}
						for(int i=0; i<data.length; i++) {
							angles[i] = (int)Math.round(((double)data[i]/(double)sum)*360);
							percentages[i] = (int)Math.round(((double)data[i]/(double)sum)*100);
						}
						chartPanel.repaint();
					}
				});
				this.add(new JLabel(itemNames[i]));
				this.add(tf[i]);
			}
		}
	}
	class ChartPanel extends JPanel {
		public ChartPanel() {
			this.setPreferredSize(new Dimension(500,350));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;
			for(int i=0; i<data.length; i++) {
				g.setColor(colors[i]);
				g.setFont(new Font("맑은 고딕", Font.BOLD,12));
				g.drawString(itemNames[i]+" : "+percentages[i], 50+100*i, 20);
				g.fillArc(150, 100, 200, 200, startAngle, angles[i]);
				startAngle+=angles[i];
			}
			
		}
	}
	public static void main(String[] args) {
		new ch11();
	}
}
