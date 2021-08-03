package stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangul {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader in = null;
		try {
			fis = new FileInputStream("test.txt");
			in = new InputStreamReader(fis, "UTF-8");
			int c;
			while((c = in.read()) != -1) {
				System.out.print(c);
			}
			in.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
