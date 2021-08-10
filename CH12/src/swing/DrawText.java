package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawText extends JFrame {
   MyPanel myPanel = new MyPanel();
   public DrawText() {
      this.setTitle("그래픽스로 그림 그리기....");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(300,300);
      
      //Container contentPane = this.getContentPane();
      //contentPane.add(myPanel);
      this.setContentPane(myPanel);
      this.setVisible(true);
      
   }
   
   class MyPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         //g.setColor(Color.RED); // 상수
         //g.setColor(new Color(255,0,0)); // 직접 만들어 쓰는 색깔
         g.setColor(new Color(0xff0000)); // 직접 만들어 쓰는 색깔
         for(int i=0;i<5;i++) {
            g.setFont(new Font("맑은 고딕",Font.BOLD,10*(i+1)));
            g.drawString("Hello Java",50,50*(i+1));
         }
      }
   }
   public static void main(String[] args) {
      new DrawText();
   }
}
