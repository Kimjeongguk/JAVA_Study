package component;

import java.awt.*;
import javax.swing.*;

public class JListEx2 extends JFrame {
	private String fuits[] = {"apple", "banana", "kiwi", "mango", "pear", "peach"};
	private ImageIcon images[] = {new ImageIcon("images/apple1.png"),new ImageIcon("images/apple2.png"),new ImageIcon("images/apple3.png")};
	public JListEx2() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JList<String> strList = new JList<String>(fuits);
		contentPane.add(strList);
		JList<ImageIcon> imgList = new JList<ImageIcon>();
		imgList.setListData(images);
		contentPane.add(imgList);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JListEx2();
	}
}
