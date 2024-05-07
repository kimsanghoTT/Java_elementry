package com.kh.SocketEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//채팅 시작 주최자
//port 2자리, 3자리, 4자리 : 컴퓨터에서 약속으로 지정한 숫자
public class ServerPre {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(12360);
			
			System.out.println("party chat open");
			
			//client의 연결 수락
			Socket clinetSocket = server.accept();
			System.out.println("client entered");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream()));
			
			PrintWriter out = new PrintWriter(clinetSocket.getOutputStream(), true);
			
			String message;
			
			while((message = in.readLine()) != null) {
				System.out.println("send : " + message);
				out.println("sucess : " + message);
			}
			
			clinetSocket.close();
			server.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
