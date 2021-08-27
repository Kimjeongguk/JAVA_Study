package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// java           driver(��� �������� �� ����  ojdbc  dbms �����ȸ�翡���� ���� driver)
public class JDBC02 {
   
   public static final String driver = "oracle.jdbc.OracleDriver";
   public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
   public static final String id = "TEST_USER";
   public static final String password = "1234";
   
   public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
	   while(true) {
		   System.out.println("�޴��������� \n1.���� \n2.�Է� \n3.���� \n4.���� \n5.����");
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
			   System.out.println("����");
			   return;
		   default:
			   System.out.println("�߸�����");
			   break;
		   }
		   
		   
		   
		   
		
	   }
	   
   }
   public static void insertData() {
	   Connection conn = null;
		  PreparedStatement pstmt =  null; //����Ŭ�� �̸� ������������...
		  String sql = "INSERT INTO BOARD VALUES(SEQUENCE1.NEXTVAL, ?, ?, ?, ?)"; // members ���� ��� �÷��� ���� ��������....
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("���̵� �Է��Ͻÿ�.");
		  String newId = scanner.nextLine();
		  System.out.println("�̸��� �Է��Ͻÿ�.");
		  String name = scanner.nextLine();
		  System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
		  String pw = scanner.nextLine();
		  System.out.println("���� �Է��Ͻÿ�.");
		  String contents = scanner.nextLine();
		  
		  try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, newId);
			pstmt.setNString(2, name);
			pstmt.setNString(3, pw);
			pstmt.setNString(4, contents);
			int result = pstmt.executeUpdate(); // ���̺� ���� ������ ��ġ�� sql�� executeUpdate()�� ������� �ڵ� Ŀ����.
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
		  PreparedStatement pstmt =  null; //����Ŭ�� �̸� ������������...
		  String sql = "UPDATE BOARD SET ID = ? WHERE ID = ? AND PW = ?"; // members ���� ��� �÷��� ���� ��������....
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("���̵� �Է��Ͻÿ�.");
		  String selectedID = scanner.nextLine();
		  System.out.println("������ ���̵� �Է��Ͻÿ�.");
		  String changedID = scanner.nextLine();
		  System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
		  String selectedPW = scanner.nextLine();
		  
		  try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, changedID);
			pstmt.setNString(2, selectedID);
			pstmt.setNString(3, selectedPW);
			int result = pstmt.executeUpdate(); // ���̺� ���� ������ ��ġ�� sql�� executeUpdate()�� ������� �ڵ� Ŀ����.
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
	  PreparedStatement pstmt =  null; //����Ŭ�� �̸� ������������...
	  String sql = "DELETE FROM BOARD WHERE ID = ? AND PW = ?"; // members ���� ��� �÷��� ���� ��������....
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("������ ���̵� �Է��Ͻÿ�.");
	  String selectedID = scanner.nextLine();
	  System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
	  String selectedPW = scanner.nextLine();
	  
	  try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setNString(1, selectedID);
		pstmt.setNString(2, selectedPW);
		int result = pstmt.executeUpdate(); // ���̺� ���� ������ ��ġ�� sql�� executeUpdate()�� ������� �ڵ� Ŀ����.
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
      String sql = "SELECT * FROM BOARD ORDER BY NO DESC"; // members ���� ��� �÷��� ���� ��������....
      
      //1. driver�� ���� db����
      try {
         Class.forName(driver); // driver����
         conn = DriverManager.getConnection(url, id, password); // Ŀ�ؼ� ���ؼ� ����....
         stmt = conn.createStatement(); // query �غ�....
         rs = stmt.executeQuery(sql); // query �����ϰ� ����� ��ȯ...
//	         rs���� ��� ��� �ִ��� �𸥴�... eof
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




