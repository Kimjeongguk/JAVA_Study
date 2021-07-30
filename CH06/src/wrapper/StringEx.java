package wrapper;

public class StringEx {
	public static void main(String[] args) {
		String a = " C#";
		String b = ",c++ ";
		System.out.println(a+"의 길이는 "+a.length());
		System.out.println(b+"의 길이는 "+b.length());
		a = a.concat(b); // 뮨저열 연결
		a = a.trim(); //공백 제거
		System.out.println(a);
		
		a = a.replace("C#","JAVA");
		System.out.println(a);
		String strArray [] = a.split(",");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		a = a.substring(2); // index n번부터 끝까지
		System.out.println(a);
	}
}
