package mario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class GamePanel extends JPanel implements Runnable {
	private Thread th;
	private Image bg = new ImageIcon("images/bg.jpeg").getImage();
	private Image mario = new ImageIcon("images/mario.png").getImage();
	private Image mushroom = new ImageIcon("images/mushroom.png").getImage();
	private int marioX = 0;
	private int marioY = 0;
	private int mushX = 50;
	private int mushY = 50;
	public boolean up,down,left,right;
	private int score = 0;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(800,600));
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left = false;
					break;
				case KeyEvent.VK_RIGHT:
					right = false;
					break;
				case KeyEvent.VK_UP:
					up = false;
					break;
				case KeyEvent.VK_DOWN:
					down = false;
					break;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case KeyEvent.VK_UP:
					up = true;
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					break;
				}
			}
		});
		
		th = new Thread(this);
		th.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		g.drawImage(mario, marioX, marioY, null);
		g.drawImage(mushroom, mushX, mushY, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("맑은 고딕", Font.BOLD,24));
		g.drawString("SCORE : " + score, 50, 50);
	}
	private void marioMove() {
		if(left) {
			marioX-=10;
		}if (right) {
			marioX+=10;
		}if (up) {
			marioY-=10;
		}if (down) {
			marioY+=10;
		}
		repaint();
	}
	private void hitMushroom() {
		double distX = marioX - mushX;
		double distY = marioY - mushY;
		double distance =Math.sqrt(distX*distX + distY*distY);
		if(distance<20) {
//			System.out.println("충돌");
			mushX = (int)(Math.random()*770);
			mushY = (int)(Math.random()*570);
			score+=10;
		}
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
//			System.out.println("sadf");
			marioMove();
			hitMushroom();
		}
	}
	
}

public class Mario extends JFrame {
	public Mario() {
		this.setTitle("MARIO GO GO GO");
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new GamePanel());
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Mario();
	}
}
