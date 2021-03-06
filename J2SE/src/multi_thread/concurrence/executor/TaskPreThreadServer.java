package multi_thread.concurrence.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskPreThreadServer {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(8811);
		while (true) {
			final Socket client = server.accept();
			new Thread() {
				public void run() {
					handleReq(client);
				};
			}.start();
		}
	}

	protected static void handleReq(Socket client) {

	}
}
