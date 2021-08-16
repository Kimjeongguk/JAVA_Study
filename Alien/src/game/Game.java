package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private int delay = 20; 
	private int ufoDelay = 20; 
	public boolean up,down,left,right,shoot;
	public int count = 0;
	public boolean isOver;
	public int power = 5;
	public int speed = 10;
	Image endingPage = new ImageIcon("images/ending_page.jpg").getImage();
	
	
	PlayerBullet playerBullet;
	UFO ufo;
	RandomItem item;

	ArrayList<PlayerBullet> playerBulletList = new ArrayList<PlayerBullet>();
	ArrayList<UFO> ufoList = new ArrayList<UFO>();
	ArrayList<RandomItem> itemList = new ArrayList<RandomItem>();

	Player player = new Player(600, 600, 100);
	
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			keyProcess();
			playerBulletAction();
			
			makeUFO(); 
			ufoAction(); 
			itemAction();
		}
	}
	public void itemAction() {
		for(int i=0;i<itemList.size();i++) {
			item = itemList.get(i);
			item.moveY();
			// conflict whit ufo
			if (hitObject(new Rectangle(player.x, player.y, player.width, player.height),
		                  new Rectangle(item.x, item.y, item.width, item.height))) {
					itemList.remove(i);
		            int random = (int)(Math.random()*3);
		            
		            switch(random) {
		            case 0:
		            	player.hp -= 20;
		            	if(player.hp<=0) {
			            	isOver = true;
			            }
		            	System.out.println("-hp");
		            	break;
		            case 1:
		            	player.hp += 20;
		            	System.out.println("+hp");
		            	break;
		            case 2:
		            	power+=5;
		            	System.out.println("power");
		            	break;
		            }
		            
		            
		    }
			if(item.y>1000) {
				itemList.remove(item);
			}
		}
	}
	public void ufoAction() {
		for(int i=0;i<ufoList.size();i++) {
			ufo = ufoList.get(i);
			ufo.moveY();
			// conflict whit ufo
			if (hitObject(new Rectangle(player.x, player.y, player.width, player.height),
		                  new Rectangle(ufo.x, ufo.y, ufo.width, ufo.height))) {
		            ufoList.remove(i);
		            player.hp -= ufo.power;
		            if(player.hp<=0) {
		            	isOver = true;
		            }
		    }
			if(ufo.y>1000) {
				ufoList.remove(ufo);
			}
		}
	}
	public void playerBulletAction() {
		for(int i=0;i<playerBulletList.size();i++) {
			playerBullet = playerBulletList.get(i);
			playerBullet.shoot();
			
			for(int j=0;j<ufoList.size();j++) {
				ufo = ufoList.get(j);
				if( hitObject( new Rectangle(playerBullet.x,playerBullet.y,playerBullet.width,playerBullet.height),
						       new Rectangle(ufo.x,ufo.y,ufo.width,ufo.height)) ) {
					// attack ufo
					ufo.hp -= playerBullet.power;
					playerBulletList.remove(playerBullet);
					
				}
				if(ufo.hp<=0) {
					makeItem(ufo.x,ufo.y,ufo.speedY);
					ufoList.remove(ufo);
					player.score+=10;
				}
			}
			if(playerBullet.y<-30) {
				playerBulletList.remove(playerBullet);
			}
		}
	}

	public void makeUFO() {
		if(count%ufoDelay==0) {
			ufo = new UFO(  (int)(Math.random()*(GamePanel.GAME_WIDTH - 200))+100,-100,20);
			ufoList.add(ufo);
			ufo.speedY = (int)(Math.random()*5)+5;
		}
	}
	public void makeItem(int x, int y, int speed) {
		item = new RandomItem(x,y);
		item.speedY = speed;
		itemList.add(item);
	}
	
	public void keyProcess() {
		if(left) {
			if(player.x>0) {
				player.x-=player.speedX;
			}
		} 
		if(right) {
			if (player.x < 1130) {
				player.x+=player.speedX;
			}
		} 
		if(up) {
			if(player.y>0) {
				player.y-=player.speedY;
			}
		} 
		if(down) {
			if(player.y<730) {
				player.y+=player.speedY;
			}
		}
		if(shoot) {
			if(count%5==0) {
				playerBullet = new PlayerBullet(player.x+26, player.y-30, power);
				playerBulletList.add(playerBullet);
			}
		}
	}

	public void drawAll(Graphics g) {
		drawPlayer(g);
		drawPlayerBullet(g);
		drawUFO(g);
		drawInfo(g);
		drawItem(g);
	}
	public void drawInfo(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("맑은 고딕",Font.BOLD,20));
		g.drawString("SCORE : "+player.score, 50, 50);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("맑은 고딕",Font.BOLD,16));
		g.drawString("PLAYER HP : "+player.hp, 1000 , 50);
		
		g.setColor(Color.RED);
		g.fillRect(player.x+2, player.y+70, (int)(player.hp*0.6), 8); // hp bar
//		g.drawString(""+player.hp,player.x+20 , player.y+90);
		if(isOver) {
			g.drawImage(endingPage, 0,0, null);
		}
	}
	public void drawPlayer(Graphics g) {
		g.drawImage(player.image, player.x, player.y, null);
	}
	public void drawPlayerBullet(Graphics g) {
		for(int i=0;i<playerBulletList.size();i++) {
			playerBullet = playerBulletList.get(i);
			g.drawImage(playerBullet.image, playerBullet.x, playerBullet.y, null);
		}
	}
	public void drawUFO(Graphics g) {
		for(int i=0;i<ufoList.size();i++) {
			ufo = ufoList.get(i);
			g.drawImage(ufo.image, ufo.x, ufo.y, null);
			
			g.setColor(Color.RED);
			g.fillRect(ufo.x, ufo.y-10, ufo.hp*3, 5); // hp bar
		}
	}
	public void drawItem(Graphics g) {
		for(int i=0;i<itemList.size();i++) {
			item = itemList.get(i);
			g.drawImage(item.image, item.x, item.y, null);
		}
	}
	
	public boolean hitObject(Rectangle rect01,Rectangle rect02) {
		return rect01.intersects(rect02);
	}
}









