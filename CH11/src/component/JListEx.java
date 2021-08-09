package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class JListEx extends JFrame {

	private Vector<String> vector = new Vector<String>();
	private JTextField tf = new JTextField("이름", 10);
	private JList<String> nameList = new JList<String>(vector);
	public JListEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("이름 입력 하고 엔터"));
		contentPane.add(tf);
		vector.add("1");
		vector.add("2");
		vector.add("3");
		contentPane.add(new JScrollPane(nameList));
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vector.add(tf.getText());
				tf.setText("");
				nameList.setListData(vector);
			}
		});
		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JListEx();
	}
}
