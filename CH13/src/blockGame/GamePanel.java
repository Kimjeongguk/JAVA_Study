package blockGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	   static int BALL_DIAMETER = 100;
	   static int BLOCK_ROW = 5;
	   static int BLOCK_COLUMN = 10;
	   static int BLOCK_WIDTH = 60;
	   static int BLOCK_HEIGHT = 30;
	   static int BLOCK_GAP = 2;
	   static int PADDLE_WIDTH = 90;
	   static int PADDLE_HEIGHT = 20;
	   static int GAME_WIDTH = BLOCK_WIDTH*BLOCK_COLUMN+BLOCK_GAP*(BLOCK_COLUMN - 1);
	   static int GAME_HEIGHT = 900;
	   
	   private Thread th;
	   private int score = 0;
	   private int gameCount = 0;
	   private boolean isFlag = false;
	   private int life = 3;
	   
	   private Ball ball = new Ball();
	   private Paddle paddle = new Paddle();
	   
	   private Block blocks[][] = new Block[GamePanel.BLOCK_ROW][GamePanel.BLOCK_COLUMN];
	   
	   public GamePanel() {
	      this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
	      //this.setSize(GAME_WIDTH,GAME_HEIGHT);
	      this.setBackground(Color.BLACK);
	      th = new Thread(this);
	      th.start();
	      for(int i=0;i<GamePanel.BLOCK_ROW;i++) { // 5
	         for(int j = 0;j<GamePanel.BLOCK_COLUMN;j++) { // 10
	            blocks[i][j] = new Block(); // 각각의 블럭을 생성  배열의 각각에 block
	            blocks[i][j].x = GamePanel.BLOCK_WIDTH*j+GamePanel.BLOCK_GAP*j;
	            blocks[i][j].y = 100 + GamePanel.BLOCK_HEIGHT*i+GamePanel.BLOCK_GAP*i;
	            blocks[i][j].width = GamePanel.BLOCK_WIDTH;
	            blocks[i][j].height = GamePanel.BLOCK_HEIGHT;
	            blocks[i][j].color = i;
	         }
	      }
	      //좌우키보드 이벤트 달기....
	      this.setFocusable(true);
	      this.requestFocus();
	      this.addKeyListener(new KeyListener() {
	         @Override
	         public void keyTyped(KeyEvent e) {}
	         @Override
	         public void keyReleased(KeyEvent e) {
	            switch(e.getKeyCode()) {
	               case KeyEvent.VK_LEFT:
	               paddle.left=false;
	               break;
	               case KeyEvent.VK_RIGHT:
	               paddle.right=false;
	               break;
	            }
	            if(isFlag && e.getKeyCode() == KeyEvent.VK_ENTER ) {
	               isFlag = false;
	               score = 0;
	               life = 3;
	               th = new Thread(GamePanel.this);
	               th.start();
	               for(int i=0;i<GamePanel.BLOCK_ROW;i++) { // 5
	                  for(int j = 0;j<GamePanel.BLOCK_COLUMN;j++) { // 10
	                     blocks[i][j] = new Block(); // 각각의 블럭을 생성  배열의 각각에 block
	                     blocks[i][j].x = GamePanel.BLOCK_WIDTH*j+GamePanel.BLOCK_GAP*j;
	                     blocks[i][j].y = 100 + GamePanel.BLOCK_HEIGHT*i+GamePanel.BLOCK_GAP*i;
	                     blocks[i][j].width = GamePanel.BLOCK_WIDTH;
	                     blocks[i][j].height = GamePanel.BLOCK_HEIGHT;
	                     blocks[i][j].color = i;
	                  }
	               }
	            }
	         }
	         @Override
	         public void keyPressed(KeyEvent e) {
	            switch(e.getKeyCode()) {
	               case KeyEvent.VK_LEFT:
	               paddle.left=true;
	               break;
	               case KeyEvent.VK_RIGHT:
	               paddle.right=true;
	               break;
	               case KeyEvent.VK_ENTER:
	               break;
	            }
	         }
	      });
	   }
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.setColor(Color.WHITE);
	      g.fillOval(ball.x,ball.y,ball.width, ball.height);
	      g.setColor(Color.RED);
	      g.fillRect(paddle.x,paddle.y,paddle.width,paddle.height);
	      g.setColor(Color.WHITE);
	      g.setFont(new Font("맑은 고딕",Font.BOLD,20));
	      g.drawString("SCORE : "+score,GamePanel.GAME_WIDTH/2-40, 40);
	      
	      g.setFont(new Font("맑은 고딕",Font.BOLD,16));
	      g.drawString("LIFE : "+life,GamePanel.GAME_WIDTH-80, 40);
	      //enter 눌렀을때 다시 게임 시작할 수 있게....
	      
	      //thread 생성해서 주구장창..
	      if(isFlag) {
	         super.paintComponent(g);
	         g.setFont(new Font("맑은 고딕",Font.BOLD,50));
	         g.drawString("SCORE : "+score,GamePanel.GAME_WIDTH/2-150, GamePanel.GAME_HEIGHT/2);
	      }
	      
	      for(int i=0;i<GamePanel.BLOCK_ROW;i++) { // 5
	         for(int j = 0;j<GamePanel.BLOCK_COLUMN;j++) { // 10
	            //g.setColor(Color.yellow);
	            if(blocks[i][j].isHide) {
	               continue;
	            }
	            if(blocks[i][j].color == 0) {
	               g.setColor(Color.BLUE);
	            }  else if(blocks[i][j].color == 1) {
	               g.setColor(Color.GREEN);
	            } else if(blocks[i][j].color == 2) {
	               g.setColor(Color.MAGENTA);
	            } if(blocks[i][j].color == 3) {
	               g.setColor(Color.YELLOW);
	            } if(blocks[i][j].color == 4) {
	               g.setColor(Color.WHITE);
	            }
	            g.fillRect(blocks[i][j].x, blocks[i][j].y, blocks[i][j].width, blocks[i][j].height);
	         }
	      }
	   }
	   @Override
	   public void run() {
	      while(!isFlag) {
	         try {
	            Thread.sleep(20);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         repaint();
	         paddleMove();
	         ballMove();
	         checkWall();
	         checkBlock();
	         checkGameEnd();
	      }
	   }
	   public void checkGameEnd() {
	      int gameCount = 0;
	      for(int i=0;i<GamePanel.BLOCK_ROW;i++) { // 5
	         for(int j = 0;j<GamePanel.BLOCK_COLUMN;j++) { // 10
	            Block block = blocks[i][j];
	            if(block.isHide) {
	               //score+=(GamePanel.BLOCK_ROW-i)*10;
	               gameCount++;
	            }
	         }
	      }
	      System.out.println(gameCount);
	      if(gameCount>=GamePanel.BLOCK_ROW*GamePanel.BLOCK_COLUMN) {
	         isFlag = true;
	      }
	      if(life<=0) {
	         isFlag = true;
	      }
	   }
	   public void paddleMove() {
	      if(paddle.left) {
	         paddle.x-=10;
	         if(paddle.x<0) {
	            paddle.x = 0;
	            paddle.left= false;
	         }
	      }
	      if(paddle.right) {
	         paddle.x+=10;
	         if(paddle.x+ paddle.width>=GamePanel.GAME_WIDTH) {
	            paddle.x = GamePanel.GAME_WIDTH-paddle.width;
	            paddle.right= false;
	         }
	      }
	   }
	   public void checkWall() {
	      if(ball.dir==0) { //up right
	         if(ball.y < 0) {//위쪽 벽에 닿았을때
	            ball.dir=1;
	         }
	         if(ball.x > GamePanel.GAME_WIDTH - GamePanel.BALL_DIAMETER) {
	            ball.dir = 2;
	         }
	      } else if(ball.dir == 1) { // down right   
	         if(ball.y > GamePanel.GAME_HEIGHT - GamePanel.BALL_DIAMETER) {
	            ball.dir = 0;
	         }
	         if(ball.x > GamePanel.GAME_WIDTH - GamePanel.BALL_DIAMETER) {
	            ball.dir = 3;
	         }
	         // paddle과의 충돌
	         if(ball.y+GamePanel.BALL_DIAMETER >= paddle.y) {
	            if( hitObject( new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                         new Rectangle(paddle.x,paddle.y,paddle.width,paddle.height)  )) {
	               ball.dir = 0;
	            }
	         }
	         if(ball.y >= GamePanel.GAME_HEIGHT-GamePanel.BALL_DIAMETER) {
	               ball.x = GamePanel.GAME_WIDTH/2 - GamePanel.BALL_DIAMETER/2;
	               ball.y = GamePanel.GAME_HEIGHT/2 - GamePanel.BALL_DIAMETER/2;
	               ball.dir = 0;
	               life--;
	         }
	         
	      } else if(ball.dir==2) { // up left
	         if(ball.y < 0) {//위쪽 벽에 닿았을때
	            ball.dir=3;
	         }
	         if(ball.x < 0) {
	            ball.dir = 0;
	         }
	      } else if(ball.dir==3) { // down left
	         if(ball.y > GamePanel.GAME_HEIGHT - GamePanel.BALL_DIAMETER) {
	            // 여기 부분 수정...
	            ball.dir = 2;
	         }
	         if(ball.x < 0) {
	            ball.dir = 1;
	         }
	         // paddle과의 충돌
	         if(ball.y+GamePanel.BALL_DIAMETER >= paddle.y) {
	            if( hitObject( new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                         new Rectangle(paddle.x,paddle.y,paddle.width,paddle.height)  )) {
	               ball.dir = 2;
	            }
	         }
	         if(ball.y >= GamePanel.GAME_HEIGHT-GamePanel.BALL_DIAMETER) {
	               ball.x = GamePanel.GAME_WIDTH/2 - GamePanel.BALL_DIAMETER/2;
	               ball.y = GamePanel.GAME_HEIGHT/2 - GamePanel.BALL_DIAMETER/2;
	               ball.dir = 0;
	               life--;
	         }
	      }
	   }
	   // checkBlock
	   public void checkBlock() {
	      for(int i=0;i<GamePanel.BLOCK_ROW;i++) { // 5
	         for(int j = 0;j<GamePanel.BLOCK_COLUMN;j++) { // 10
	            Block block = blocks[i][j];
	            if(!block.isHide) { // 화면에 보이는 것들만...
	               if(ball.dir==0) { // up right
	                  if(hitObject(
	                        new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                        new Rectangle(block.x,block.y,block.width,block.height))) {
	                        if(ball.x>=block.x && ball.x+ball.width<= block.x+block.width) {
	                           ball.dir = 1;
	                        } else {
	                           ball.dir = 2;
	                        }
	                        blocks[i][j].isHide = true;
	                        score+=(GamePanel.BLOCK_ROW-i)*10;
	                        // 공이 패들을 만나지 않고
	                  }
	               }
	               
	               else if(ball.dir==1) { // down right
	                  if(hitObject(
	                        new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                        new Rectangle(block.x,block.y,block.width,block.height))) {
	                        
	                        if(ball.x>=block.x && ball.x+ball.width<= block.x+block.width) {
	                           ball.dir = 0;
	                        } else {
	                           ball.dir = 3;
	                        }
	                        blocks[i][j].isHide = true;
	                        score+=(GamePanel.BLOCK_ROW-i)*10;
	                        
	                  }
	               }
	               else if(ball.dir==2) { //up left
	                  if(hitObject(
	                        new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                        new Rectangle(block.x,block.y,block.width,block.height))) {
	                        
	                        if(ball.x>=block.x && ball.x+ball.width<= block.x+block.width) {
	                           ball.dir = 3;
	                        } else {
	                           ball.dir = 0;
	                        }
	                        blocks[i][j].isHide = true;
	                        score+=(GamePanel.BLOCK_ROW-i)*10;
	                        
	                  }
	               }
	               else if(ball.dir==3) { // down left
	                  if(hitObject(
	                        new Rectangle(ball.x,ball.y,ball.width,ball.height),
	                        new Rectangle(block.x,block.y,block.width,block.height))) {
	                        // 드로잉을 아 
	                     
	                        if(ball.x>=block.x && ball.x+ball.width<= block.x+block.width) {
	                           ball.dir = 2;
	                        } else {
	                           ball.dir = 1;
	                        }
	                        blocks[i][j].isHide = true;
	                        score+=(GamePanel.BLOCK_ROW-i)*10;
	                        
	                  }
	               }
	            }
	         }
	      }
	   }
	   
	   public void ballMove() {
	      //벽을 세워서 충돌을 감지해야
	      if(ball.dir==0) { //up right
	         ball.x+=ball.speed;
	         ball.y-=ball.speed;
	      } else if(ball.dir==1) { // down right
	         ball.x+=ball.speed;
	         ball.y+=ball.speed;
	      } else if(ball.dir==2) { // up left
	         ball.x-=ball.speed;
	         ball.y-=ball.speed;
	      } else if(ball.dir==3) { // down left
	         ball.x-=ball.speed;
	         ball.y+=ball.speed;
	      }
	   }
	   
	   public boolean hitObject(Rectangle ball,Rectangle rect) {
	      return ball.intersects(rect);
	   }
	}

