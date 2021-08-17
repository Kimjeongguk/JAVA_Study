package menu2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuListener;

public class JMenuEx extends JFrame {
	private JLabel imgLabel = new JLabel();
	public JMenuEx() {
		this.setTitle("title");
		Container contentPane = this.getContentPane();
		contentPane.add(imgLabel);
		
		createMenu();
		this.setSize(800,600);
		this.setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");
		JMenuItem menuItem[] = new JMenuItem[4];
		String itemTitle[] = {"Load","Hide","Reshow","Exit"};
		MenuActionListener menuActionListener = new MenuActionListener();
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(menuActionListener);
			screenMenu.add(menuItem[i]);
		}
		
		mb.add(screenMenu);
		
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		this.setJMenuBar(mb);
		
	}
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "Load":
				imgLabel.setIcon(new ImageIcon("images/game_page.jpg"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "Reshow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new JMenuEx();
	}
}
