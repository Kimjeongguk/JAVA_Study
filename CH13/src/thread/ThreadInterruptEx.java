package thread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class TimerRunnabel implements Runnable {
	private JLabel timerLabel;
	private boolean flag = false;
	public TimerRunnabel(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	public void end() {
		flag=true;
	}
	@Override
	public void run() {
		int num = 0;
		while(true) {
			this.timerLabel.setText(Integer.toString(num));
			num++;
			try {
				Thread.sleep(10);
				if(flag) return;
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
}

public class ThreadInterruptEx extends JFrame{
	public ThreadInterruptEx() {
		this.setTitle("Thread Interrupt");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel("0");
		timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,30));
		contentPane.add(timerLabel);
		TimerRunnabel runnable = new TimerRunnabel(timerLabel);
		Thread th = new Thread(runnable);
		th.start();
		JButton stopBtn = new JButton("STOP");
		contentPane.add(stopBtn);
		stopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stopBtn.setEnabled(false);
				runnable.end();
//				th.interrupt();
			}
		});
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadInterruptEx();
	}
}
