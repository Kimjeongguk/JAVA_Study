package stream;

import java.io.*;

public class BufferedIOEx {
	public static void main(String[] args) {
		
		FileReader fr = null;
		int c;
		try {
			fr = new FileReader("test04.txt");
			BufferedOutputStream bOut = new BufferedOutputStream(System.out,8);
			while((c = fr.read()) != -1) {
				bOut.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
