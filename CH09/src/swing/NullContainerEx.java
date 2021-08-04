package swing;
import java.awt.*;

import javax.swing.*;
public class NullContainerEx extends JFrame {
	public NullContainerEx() {
		this.setTitle("null container layout");
		this.setSize(300,300);
		this.setVisible(true);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		JLabel label = new JLabel("hellow swing");
		JButton btn = new JButton("click");
//		btn.setSize(100,50);
//		btn.setLocation(10,50);
//		btn.setBounds(10,10,100,50);
//		add(btn);
		
		for(int i=0; i<10; i++) {
			JButton btns = new JButton("btn"+i);
			btns.setSize(100,20);
			btns.setLocation((i%5)*100, (i/5)*30);
			contentPane.add(btns);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		NullContainerEx nx = new NullContainerEx();
	}
}
