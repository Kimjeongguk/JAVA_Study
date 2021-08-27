package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// java           driver(모든 정보들이 들어가 있음  ojdbc  dbms 만드는회사에서는 보통 driver)
public class JDBC02 {
   
   public static final String driver = "oracle.jdbc.OracleDriver";
   public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
   public static final String id = "TEST_USER";
   public static final String password = "1234";
   
   public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
	   while(true) {
		   System.out.println("메뉴를고르세요 \n1.보기 \n2.입력 \n3.변경 \n4.삭제 \n5.종료");
		   int select = scanner.nextInt();
		   switch(select) {
		   case 1:
			   getData();
			   break;
		   case 2:
			   insertData();
			   break;
		   case 3:
			   updateData();
			   break;
		   case 4:
			   deleteData();
			   break;
		   case 5:
			   System.out.println("종료");
			   return;
		   default:
			   System.out.println("잘못누름");
			   break;
		   }
		   
		   
		   
		   
		
	   }
	   
   }
   public static void insertData() {
	   Connection conn = null;
		  PreparedStatement pstmt =  null; //오라클에 미리 질문던져놓기...
		  String sql = "INSERT INTO BOARD VALUES(SEQUENCE1.NEXTVAL, ?, ?, ?, ?)"; // members 에서 모든 컬럼의 값을 가져오기....
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("아이디를 입력하시오.");
		  String newId = scanner.nextLine();
		  System.out.println("이름을 입력하시오.");
		  String name = scanner.nextLine();
		  System.out.println("비밀번호를 입력하시오.");
		  String pw = scanner.nextLine();
		  System.out.println("내용 입력하시오.");
		  String contents = scanner.nextLine();
		  
		  try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, newId);
			pstmt.setNString(2, name);
			pstmt.setNString(3, pw);
			pstmt.setNString(4, contents);
			int result = pstmt.executeUpdate(); // 테이블에 값에 영향을 미치는 sql은 executeUpdate()를 써줘야함 자동 커밋임.
			System.out.println("result===>"+result);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
   }
   public static void updateData() {
	   Connection conn = null;
		  PreparedStatement pstmt =  null; //오라클에 미리 질문던져놓기...
		  String sql = "UPDATE BOARD SET ID = ? WHERE ID = ? AND PW = ?"; // members 에서 모든 컬럼의 값을 가져오기....
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("아이디를 입력하시오.");
		  String selectedID = scanner.nextLine();
		  System.out.println("변경할 아이디를 입력하시오.");
		  String changedID = scanner.nextLine();
		  System.out.println("비밀번호를 입력하시오.");
		  String selectedPW = scanner.nextLine();
		  
		  try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, changedID);
			pstmt.setNString(2, selectedID);
			pstmt.setNString(3, selectedPW);
			int result = pstmt.executeUpdate(); // 테이블에 값에 영향을 미치는 sql은 executeUpdate()를 써줘야함 자동 커밋임.
			System.out.println("result===>"+result);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
   }
   public static void deleteData() {
	  Connection conn = null;
	  PreparedStatement pstmt =  null; //오라클에 미리 질문던져놓기...
	  String sql = "DELETE FROM BOARD WHERE ID = ? AND PW = ?"; // members 에서 모든 컬럼의 값을 가져오기....
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("삭제할 아이디를 입력하시오.");
	  String selectedID = scanner.nextLine();
	  System.out.println("비밀번호를 입력하시오.");
	  String selectedPW = scanner.nextLine();
	  
	  try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setNString(1, selectedID);
		pstmt.setNString(2, selectedPW);
		int result = pstmt.executeUpdate(); // 테이블에 값에 영향을 미치는 sql은 executeUpdate()를 써줘야함 자동 커밋임.
		System.out.println("result===>"+result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
   }
   public static void getData() {
	   Connection conn = null;
      Statement stmt =  null;
      ResultSet rs = null;
      String sql = "SELECT * FROM BOARD ORDER BY NO DESC"; // members 에서 모든 컬럼의 값을 가져오기....
      
      //1. driver를 통해 db연결
      try {
         Class.forName(driver); // driver생성
         conn = DriverManager.getConnection(url, id, password); // 커넥션 통해서 연결....
         stmt = conn.createStatement(); // query 준비....
         rs = stmt.executeQuery(sql); // query 실행하고 결과값 반환...
//	         rs값을 출력 몇개가 있는지 모른다... eof
         while(rs.next()) {
        	String no = rs.getString("no");
            String id = rs.getString("id");
            String name = rs.getString("name");
            String password = rs.getString("pw");
            String contents = rs.getString("contents");
            System.out.printf("no : %s\t",no);
            System.out.printf("id : %s\t",id);
            System.out.printf("name : %s\t",name);
            System.out.printf("password : %s\t",password);
            System.out.printf("contents : %s\t",contents);
            System.out.println();
         }
         
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      }
   }
}




