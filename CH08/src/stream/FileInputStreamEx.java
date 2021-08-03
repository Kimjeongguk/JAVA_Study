package stream;

import java.io.*;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte b[] = new byte[6];
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("test03.out");
			int n=0, c;
			while ( (c=fin.read()) != -1 ) {
				b[n] = (byte)c;
				n++;
			}
			for(int i=0; i<b.length; i++) {
				System.out.print(b[i]+ " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
