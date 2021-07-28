package ch03;

import java.util.Scanner;

public class Rectangle {
   int width;
   int height;
   
   Rectangle(){
	   
   }
   
   int getArea() {
      return width*height; 
   }
   
   public static void main(String[] args) {
      System.out.println("넓이 높이를 입력하세요.");
      Rectangle rect = new Rectangle();
      Scanner scanner  = new Scanner(System.in);
      rect.width = scanner.nextInt();
      rect.height = scanner.nextInt();
      int area = rect.getArea();
      System.out.println("사각형의 면적은 "+area+"입니다.");
      scanner.close();
   }
}