
package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Net6ChatClient {
	private static final String HOST = "192.168.0.29";
	private static final int PORT = 5000;
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(HOST, PORT);
		System.out.println("서버에 연결되었습니다.");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // 출력 후 청소
		Scanner scanner = new Scanner(System.in);
		System.out.println("접속자명 입력: ");
		String name = scanner.nextLine();
		out.println(name); // 서버로 접속자명 전송
		
		Thread readThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String serverMessage;
					while((serverMessage = in.readLine()) != null) {
						System.out.println(serverMessage);
					}
				} catch (Exception e) {
					System.out.println("수신데이터 오류 : " + e.getMessage());
				}
				
			}
		});
		readThread.start();
		
		String msg;
		while((msg = scanner.nextLine()) != null) {
			if(msg.isEmpty()) {
				out.println(msg); // 채팅 메세지 전송
			}
		}
		
		socket.close();
		scanner.close();
	}

}

