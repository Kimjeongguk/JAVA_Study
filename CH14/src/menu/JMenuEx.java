package menu;

import javax.swing.*;

public class JMenuEx extends JFrame {
	public JMenuEx() {
		this.setTitle("title");
		createMenu();
		this.setSize(300,300);
		this.setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("Reshow"));
		screenMenu.add(new JMenuItem("Exit"));
		mb.add(screenMenu);
		this.setJMenuBar(mb);
		
	}
	public static void main(String[] args) {
		new JMenuEx();
	}
}
