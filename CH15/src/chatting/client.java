package chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import chatting.Server.Receiver;

public class client extends JFrame {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	private Receiver receiver;
	private JTextField sender;
	public client() {
		this.setTitle("채팅 클라이언트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		receiver = new Receiver();
//		receiver.setEditable(false);
		sender = new JTextField();
		contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);
		contentPane.add(sender, BorderLayout.SOUTH);
		this.setSize(400,500);
		sender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = sender.getText();
				
				try {
					out.write(message+"\n");
					out.flush();
					receiver.append("\n 클라이언트 : "+message);
					sender.setText("");
					sender.requestFocus();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		try {
			socket = new Socket("localhost",8988);
			receiver.append("서버에 접속됨");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread th = new Thread(receiver);
		th.start();
		this.setVisible(true);
	}
	class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String message = null;
			while(true) {
				try {
					message = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.append("\n서버 : "+message);
			}
		}
		
	}
	public static void main(String[] args) {
		new client();
	}
}
