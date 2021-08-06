package component;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarRank extends JFrame{
	int current = 2;

	public CarRank() {
		JLabel  titleLabel = new JLabel("SELECT YOUR DREAMCAR");
	      titleLabel.setFont(new Font("맑은 고딕",Font.BOLD,32));
	      titleLabel.setHorizontalAlignment(JLabel.CENTER);
	      
	      Container contentPane = this.getContentPane();

	      JPanel mainPanel = new JPanel();
	      JPanel leftPanel = new JPanel();
	      JLabel vsLabel = new JLabel("VS");
	      JPanel rightPanel = new JPanel();
	      
	      leftPanel.setLayout(new BorderLayout());
	      rightPanel.setLayout(new BorderLayout());
	      
	      vsLabel.setFont(new Font("맑은 고딕",Font.BOLD,32));
	      
	      ImageIcon leftImg = new ImageIcon("images/car01.png");
	      ImageIcon rightImg = new ImageIcon("images/car02.png");
	      
	      
	      JButton leftBtn = new JButton(leftImg);
	      JButton rightBtn = new JButton(rightImg);
	      
	      JLabel leftLabel = new JLabel("포니");
	      JLabel rightLabel = new JLabel("벤츠");
	      
	      leftLabel.setFont(new Font("맑은 고딕",Font.BOLD,24));
	      rightLabel.setFont(new Font("맑은 고딕",Font.BOLD,24));
	      leftLabel.setHorizontalAlignment(JLabel.CENTER);
	      rightLabel.setHorizontalAlignment(JLabel.CENTER);
	      
	      String carImgs[] = {"car01.png","car02.png","car03.png","car04.png","car05.png","car06.png",
	            "car07.png","car08.png","car09.png","car10.png","car11.png","car12.png","car13.png",
	            "car14.png","car15.png","car16.png"};
	      String carTitles[] = {"포니","벤츠","아우디","스팅어","g80","스타렉스",
	            "car07.png","car08.png","car09.png","car10.png","car11.png","car12.png","car13.png",
	            "car14.png","car15.png","car16.png"};
	      
	      
	      leftBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 if(current >= 15) {
		            	rightBtn.setVisible(false);
		            	vsLabel.setVisible(false);
		            	rightLabel.setVisible(false);
		            	titleLabel.setText("YOUR DREAMCAR IS"+leftLabel.getText());
		            	return;
		            }
	            ImageIcon rightImg = new ImageIcon("images/"+carImgs[current]);
	            current++;
	            rightBtn.setIcon(rightImg);
	            rightLabel.setText(carTitles[current]);
	         }
	      });
	      rightBtn.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 if(current >= 15) {
			            	leftBtn.setVisible(false);
			            	vsLabel.setVisible(false);
			            	leftLabel.setVisible(false);
			            	titleLabel.setText("YOUR DREAMCAR IS"+rightLabel.getText());
			            	return;
			            }
		            ImageIcon leftImg = new ImageIcon("images/"+carImgs[current]);
		            current++;
		            leftBtn.setIcon(leftImg);
		            leftLabel.setText(carTitles[current]);
		         }
		      });
	      
	      leftBtn.setBorderPainted(false);
	      rightBtn.setBorderPainted(false);
	      leftBtn.setContentAreaFilled(false);
	      rightBtn.setContentAreaFilled(false);
	      leftBtn.setFocusPainted(false);
	      rightBtn.setFocusPainted(false);
	      
	      leftPanel.add(leftBtn,BorderLayout.NORTH);
	      leftPanel.add(leftLabel,BorderLayout.SOUTH);
	      
	      rightPanel.add(rightBtn,BorderLayout.NORTH);
	      rightPanel.add(rightLabel,BorderLayout.SOUTH);
	      
	      mainPanel.add(leftPanel);
	      mainPanel.add(vsLabel);
	      mainPanel.add(rightPanel);
	      
	      contentPane.add(titleLabel,BorderLayout.NORTH);
	      contentPane.add(mainPanel,BorderLayout.CENTER);
	      
	      this.setTitle("DREAMCAR");
	      this.setSize(800,500);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setLocationRelativeTo(null);
	      this.setVisible(true);


	}
	
	public static void main(String[] args) {
		new CarRank();
	}
}
