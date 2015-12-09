package socket_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class Server {
	public static void main(String[] args) {
		try {
			// 1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;// 记录客户端的数量
			System.out.println("***服务器即将启动，等待客户端的连接***");
			while (true) {
				// 2.循环监听等待客户端的连接
				socket = serverSocket.accept();// 调用accept()方法开始监听，等待客户端的连接，socket就是当前连接上服务端的客户端
				
				// 3.一旦客户端和服务端建立了通信，开始互相传输数据，此处使用线程来处理
				ServerThread serverThread = new ServerThread(socket);// 创建一个新的线程
				serverThread.start();// 启动线程
				
				count++;// 统计客户端的数量
				System.out.println("客户端的数量：" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的IP：" + address.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
