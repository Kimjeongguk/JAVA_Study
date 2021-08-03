package stream;

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24};
		
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("test03.out");
			for(int i=0; i<b.length; i++) {
				fout.write(b[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
