package ch03;

public class Book {
	   String title;
	   String author;
	   
	   void show() {
		   System.out.println("제목은 "+title+"      저자는"+ author);
	   }
	   
	   Book(){
		   this("제목없음","작자없음");
		   System.out.println("디폴트 생성자~");
	   }
	   //생성자 만들기.....
	   Book(String t) {
		   this(t, "작자미상");
//	      title = t;
//	      author = "작자미상";
	   }
	   Book(String title, String author) {
	      this.title = title;
	      this.author = author;
	   }
	   public static void main(String[] args) {
	      Book littlePrince = new Book("어린왕자","쌩떽쥐베리");
	      Book chunhyang = new Book("춘향전");
	      Book slamDunk = new Book();
	      //Book slamDunk = new Book(); // default Constructor는 기본에 생성자가 없을때 쓴다.
//	      System.out.println(littlePrince.title+"==="+littlePrince.author);
//	      System.out.println(chunhyang.title+"==="+chunhyang.author);
//	      System.out.println(slamDunk.title+"==="+slamDunk.author);
	      littlePrince.show();
	      chunhyang.show();
	      slamDunk.show();
	   }
	}