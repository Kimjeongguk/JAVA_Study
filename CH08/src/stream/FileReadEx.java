package stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadEx {
	public static void main(String[] args) {
		FileReader fr = null;//입출력 관련은 try catch로 감싸야한다.
		try {
			fr = new FileReader("test.txt");
			int c;
			while((c = fr.read()) != -1) {
				System.out.println((char)c);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
