package socket2;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class CalcServer {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			listener = new ServerSocket(9998);
			System.out.println("연결기다리는중....");
			socket = listener.accept();
			System.out.println("연결됨");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine();
				System.out.println(inputMessage);
				StringTokenizer st = new StringTokenizer(inputMessage, " ");
				int num01 = Integer.parseInt(st.nextToken());
				String operator = st.nextToken();
				int num02 = Integer.parseInt(st.nextToken());
				String result = Integer.toString(num01 + num02);
				out.write(result+"\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
