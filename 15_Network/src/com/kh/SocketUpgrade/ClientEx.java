package com.kh.SocketUpgrade;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientEx {
	private static boolean isRunning;
	private static Socket clientSocket = null;
	private static final int SERVER_PORT = 12377;//서버가 열어놓은 포트번호.
	//서버 포트번호 = 클라이언트 포트번호 여야함

	public static void main(String[] args) {
		String serverHostname = "localhost"; // 우리집 주소 = localhost = 127.0.0.1
		isRunning = true;
		//서버와 연결이 된다면 연결하고, 서버에 연결되어있는 방문자는 한 번 연결하면 끝이지만
		//서버에서 강제로 종료하고 다시 접속하려면 다시 여기를 타고 null값을 보여줌
		Thread serverThread = new Thread(() -> {
			// 서로 다른 쓰레드에서 동작한다
			//서버에서 방문자에게 메시지를 보내는 값. 처음에는 아무 대화도 없기 떄문에 null
			ServerToClientThread serverToClientThread = null;
			
			//방문자가 서버에게 메시지를 보내는 값. 처음에는 아무 대화도 없기 떄문에 null
			ClientToServerThread clientToServerThread = null;

			while (isRunning) {
				if (clientSocket == null) {
					try {
						System.out.println("Server finding...");
						clientSocket = new Socket(serverHostname, SERVER_PORT);
						if (clientSocket.isConnected()) {
							System.out.println("Connected to server.");
							//서버와 접속되면 대화를 시작하기위한 그릇을 생성
							serverToClientThread = new ServerToClientThread();
							serverToClientThread.start();
							clientToServerThread = new ClientToServerThread();
							clientToServerThread.start();
						}
						
					} catch (IOException e) {
						System.out.println("Failed to connect to server. Retrying...");
						if (serverToClientThread != null) {
							serverToClientThread.setFlag(false);
						}
						if (clientToServerThread != null) {
							clientToServerThread.setFlag(false);
						}
					}
				}
				try {
					//만약에 서버랑 클라이언트 연결이 끊어진다면 1초마다 다시 재접속 시도
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
				}
			}
		});
		serverThread.start();

	}

	static class ClientToServerThread extends Thread {
		private boolean flag = true;
		private final OutputStream out;
		private final BufferedReader br;

		ClientToServerThread() throws IOException {
			out = clientSocket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		}

		@Override
		public void run() {
			super.run();
			while (flag) {
				try {
					String input = br.readLine();
					//서버에서 종료하고 싶다면 exit를 입력후 종료
					if (input.equals("finish")) {
						System.out.println("Client Off... Goodbye!");
						clientSocket = null;
						isRunning = false;
						break;
					}
					PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8), true);
					writer.println(input);
				} catch (IOException e) {
					System.out.println("Failed to send message.");
				}
			}
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}

	static class ServerToClientThread extends Thread {
		private boolean flag = true;
		private final BufferedReader reader;

		public ServerToClientThread() throws IOException {
			InputStream in = clientSocket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		}

		@Override
		public void run() {
			super.run();
			while (flag) {
				try {
					String response = reader.readLine();
					System.out.println("Response from server: " + response);
				} catch (IOException e) {
					System.out.println("Disconnected from server.");
					clientSocket = null;
					break;
				}
			}
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}

}
