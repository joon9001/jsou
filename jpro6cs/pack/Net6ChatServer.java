
package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//멀티 채팅 서버: Thread + Socket
public class Net6ChatServer {

	private static final int PORT = 5000;
//	private static List<Socket> clients = new ArrayList<Socket>();
	// 전통적인 arraylist
	private static List<Socket> clients = new CopyOnWriteArrayList<Socket>();
	// thread용 arraylist
	// CopyOnWriteArrayList : 컨텐츠를 읽어 어딘가에 전달할 때 컨텐츠를 복사해서 전달함.
	// 스레드에서 안심하고 처리가 가능
	// ExecutorService를 이용하면 thread pool을 생성해 병렬처리를 할 수 있다.
	private static ExecutorService pool = Executors.newFixedThreadPool(4);

	// 여러명의 소켓을 받기 위해 4개의 소켓을 받을 수 있는 스레드 풀을 만들엇다.
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("채팅 서버 서비스 시작 ... ");

		try {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("새 접속자와 연결" + clientSocket.getInetAddress());
				clients.add(clientSocket);
				// 스레드 풀 객체가 스레드를 실행
				pool.execute(new ClientHandler(clientSocket));
			}
		} finally { // 에러를 안 잡을 경우 catch를 안 써도 됨
			serverSocket.close();
		}

	}

	static class ClientHandler implements Runnable {
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		public ClientHandler(Socket socket) throws IOException {
			this.socket = socket;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true); // 출력 후 청소
		}

		@Override
		public void run() {
			try {
				String name = in.readLine(); // 접속자명 받기
				if (name == null) {
					throw new IOException("클라이언트 연결이 끊어졌습니다");
				}
				System.out.println(name + "님이 접속했습니다");
				broadcastMessage("^^;" + name + "님 입장 ^^");

				String message;
				while ((message = in.readLine()) != null) { // 메세지 수신
					broadcastMessage(name + "님 메세지: " + message);
				}
				;
			} catch (Exception e) {
				System.out.println("접속자 연결 오류 : " + e.getMessage());
			} finally {
				try {
					if (socket != null) {
						socket.close();
						clients.remove(socket);
						// 접속 종료 시 소켓이 담겨있는 clients arraylist에서 client 소켓 제거
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}

		private void broadcastMessage(String message) {
			for (Socket client : clients) {
				try {
					if (!client.isClosed()) { // 클라이언트 소켓이 닫히지 않은 경우
						// 클라이언트로 송신할 데이터를 위한 PrintWriter 객체를 생성해 송신 후
						// 자동으로 flush함
						PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
						// true는 autoflush가 true란 얘기
						clientOut.println(message);
					}
				} catch (Exception e) {
					System.out.println("broadcaseMessage err: " + e.getMessage());
				}
			}
		}
	}
}
