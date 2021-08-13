package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// 렌더링 할곳
public class GamePanel extends JPanel {
	static int GAME_WIDTH=1200;
	static int GAME_HEIGHT=800;
	static int LOADING_TIME = 1000;
	
	// 전체 화면 캡쳐용 Image
	private Image bufferImage;
	private Graphics screenGraphics;
	
	// 화면 전환용 
	private String isState = "start";
	
	// 화면 전환용 Image 
	private Image startPage = new ImageIcon("images/start_page.jpg").getImage();  // 시작 화면
	private Image loadingPage = new ImageIcon("images/loading_page.jpg").getImage(); // 섦여 보여주기
	private Image gamePage = new ImageIcon("images/game_page.jpg").getImage(); // 게임 배경 
	
	//  Game 생성 
	Game game = new Game();
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(GamePanel.GAME_WIDTH,GamePanel.GAME_HEIGHT));
		this.setBackground(Color.BLACK);
		gameInit();
	}
	public void gameInit() {
		// Mouse 또는 Key
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_SPACE:
						game.shoot=false;
					break;
					case KeyEvent.VK_LEFT:
						game.left=false;
					break;
					case KeyEvent.VK_RIGHT:
						game.right=false;
					break;
					case KeyEvent.VK_UP:
						game.up=false;
					break;
					case KeyEvent.VK_DOWN:
						game.down=false;
					break;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_ENTER:
						if(isState=="start") {
							showLoading();
						}
					break;
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
						break;
					case KeyEvent.VK_SPACE:
						game.shoot=true;
						break;
					case KeyEvent.VK_R:
						if(game.isOver) {
							isState="start";
						}
						break;
					case KeyEvent.VK_LEFT:
						game.left=true;
					break;
					case KeyEvent.VK_RIGHT:
						game.right=true;

					break;
					case KeyEvent.VK_UP:
						game.up=true;

					break;
					case KeyEvent.VK_DOWN:
						game.down=true;

					break;
				}
			}
		});
	}
	public void showLoading() {
		isState="loading";
		Timer loadingTimer = new Timer();
		TimerTask loadingTask = new TimerTask() {
			public void run() {
				//System.out.println("3초뒤에 task 실행");
				isState="gaming";
				game = new Game();
				game.start();
			}
		};
		loadingTimer.schedule(loadingTask, GamePanel.LOADING_TIME);
	}
	public void paintComponent(Graphics g) {
		//그림 그리기...
		//메모리상에 먼저 그려놓기 더블버퍼링....
		bufferImage = this.createImage(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT); // 전체 화면 캡쳐
		screenGraphics = bufferImage.getGraphics(); // graphics
		screenCapture(screenGraphics);
		g.drawImage(bufferImage,0,0,null);
	}
	// 여기가 화면 그리는 곳
	public void screenCapture(Graphics g) {
		if(isState=="start") {
			g.drawImage(startPage, 0, 0, null);
		} else if(isState=="loading") {
			g.drawImage(loadingPage, 0, 0, null);
		} else if(isState=="gaming") {
			g.drawImage(gamePage, 0, 0, null);
			game.drawAll(g);//   game 화면 그리기
		}
		repaint();
	}
}















