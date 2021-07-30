package ch06;

class Point01 {
	   private int x, y;
	   public Point01(int x, int y)  {
	      this.x = x;
	      this.y = y;
	   }
	   //Override  
	   public boolean equals(Object obj) {
	      Point01 p = (Point01)obj;
	      if(x==p.x && y == p.y) {
	         return true;
	      } else {
	         return false;
	      }
	   }
	}
	public class EqualsEx {
	   public static void main(String[] args) {
	      Point01 p01 = new Point01(2,3);
	      Point01 p02 = new Point01(2,3);
	      Point01 p03 = new Point01(3,4);
	      if(p01==p02) {
	         System.out.println("p01 과 p02는 같습니다.");
	      } else {
	         System.out.println("p01 과 p02는 같지 않습니다.");
	      }
	      
	      if(p01.equals(p02)) {
	         System.out.println("p01 과 p02는 같습니다.");
	      } else {
	         System.out.println("p01 과 p02는 같지 않습니다.");
	      }
	   }
	}
