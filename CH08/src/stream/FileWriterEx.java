package stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fw = null;
		int c;
		try {
			fw = new FileWriter("text02.txt");
			while(true) {
				String line = scanner.nextLine();
				if (line.length() == 0) break;
				fw.write(line,0,line.length());
				fw.write("\r\n",0,2);
			}
			fw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
