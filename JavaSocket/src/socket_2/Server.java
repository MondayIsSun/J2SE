package socket_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���½
 * ��������
 */
public class Server {
	public static void main(String[] args) {
		try {
			// 1.����һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;// ��¼�ͻ��˵�����
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			while (true) {
				// 2.ѭ�������ȴ��ͻ��˵�����
				socket = serverSocket.accept();// ����accept()������ʼ�������ȴ��ͻ��˵����ӣ�socket���ǵ�ǰ�����Ϸ���˵Ŀͻ���
				
				// 3.һ���ͻ��˺ͷ���˽�����ͨ�ţ���ʼ���ഫ�����ݣ��˴�ʹ���߳�������
				ServerThread serverThread = new ServerThread(socket);// ����һ���µ��߳�
				serverThread.start();// �����߳�
				
				count++;// ͳ�ƿͻ��˵�����
				System.out.println("�ͻ��˵�������" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��" + address.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
