package thread;

import java.awt.*;

import javax.swing.*;

class FlickLabel extends JLabel implements Runnable {
	private long delay;
	
	public FlickLabel(String txt, long delay) {
		super(txt);
		this.setOpaque(true);
		this.delay = delay;
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		int num = 0;
		
		while(true) {
			if(num==0) {
				this.setBackground(Color.YELLOW);
			}else {
				this.setBackground(Color.GREEN);
			}
			if(num==0) {
				num=1;
			}else {
				num=0;
			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
}

public class FlickLabelEx extends JFrame{
	public FlickLabelEx() {
		this.setTitle("title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		
		FlickLabel flickLabel01 = new FlickLabel("깜빡", 500);
		JLabel label = new JLabel("아무것도 아님");
		FlickLabel flickLabel02 = new FlickLabel("깜빡", 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(flickLabel01);
		contentPane.add(label);
		contentPane.add(flickLabel02);
		
		
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new FlickLabelEx();
	}
}
