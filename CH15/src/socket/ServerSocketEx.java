package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

public class ServerSocketEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("server start");
			socket = listener.accept();
			System.out.println("client connect");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("bye end~~");
					break;
				}
				System.out.println("client : " + inputMessage);
				System.out.println("send>>>");
				String outputMessage = scanner.nextLine();
				out.write(outputMessage+"\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
