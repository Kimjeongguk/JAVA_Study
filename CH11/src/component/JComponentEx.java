package component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class JComponentEx extends JFrame{
	public JComponentEx(){
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JButton btn01 = new JButton("Magenta/Yellow Button");
		JButton btn02 = new JButton("Disabled Button");
		JButton btn03 = new JButton("getX(), getY()");
		
		add(btn01);
		add(btn02);
		add(btn03);
		btn01.setBackground(Color.MAGENTA);
		btn01.setForeground(Color.YELLOW);
//		btn01.setSize(200,100); borderlayout flowlayout 에서는 안먹음
//		btn01.setPreferredSize(new Dimension(200,100));
		btn02.setEnabled(false);
		
		btn03.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				System.out.println(btn.getX()+"===="+btn.getY());
				JComponentEx frame = (JComponentEx)btn.getTopLevelAncestor();
			}
			
		});
		this.setTitle("title");
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JComponentEx();
	}
}
