package multi_thread.concurrence.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程Web服务器
 */
public class SingleThreadWebServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7711);
		while (true) {
			Socket client = server.accept();
			handleReq(client);
		}
	}

	/**
	 * 处理请求
	 * 
	 * @param client
	 */
	private static void handleReq(Socket client) {
	}
}
