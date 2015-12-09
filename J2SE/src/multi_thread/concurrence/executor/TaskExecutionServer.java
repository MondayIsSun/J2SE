package multi_thread.concurrence.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionServer {

	/**
	 * Executors��API����
	 * 
	 * Java����ṩ�����ྲ̬����������һ���̳߳أ�
	 * 
	 * a��newFixedThreadPool ����һ���̶����ȵ��̳߳أ��������߳��������ʱ���̳߳صĹ�ģ�����ٱ仯��
	 * 
	 * b��newCachedThreadPool
	 * ����һ���ɻ�����̳߳أ������ǰ�̳߳صĹ�ģ�����˴������󣬽����տյ��̣߳�����������ʱ���������߳��������̳߳ع�ģ�����ơ�
	 * 
	 * c��newSingleThreadPoolExecutor ����һ�����̵߳�Executor��ȷ��������д���ִ��
	 * 
	 * d��newScheduledThreadPool
	 * ����һ���̶����ȵ��̳߳أ��������ӳٻ��߶�ʱ�ķ�ʽ��ִ�У�����Timer������󵥶�ʹ��Blog��������Timer����
	 * 
	 * С��һ�£����̳߳���ִ�������Ϊÿ���������һ���߳����Ƹ��࣬ͨ���������е��̶߳����Ǵ������̣߳�
	 * �����ڴ����������ʱ��̯�̴߳��������ٲ����ľ޴�Ŀ����������󵽴�ʱ��ͨ�������߳��Ѿ����ڣ��������Ӧ�ԣ�ͨ�������̳߳صĴ�С��
	 * ���Դ����㹻����߳�ʹCPU�ﵽæµ״̬�������Է�ֹ�߳�̫��ľ����������Դ��
	 */

	private static final int THREAD_COUNT = 100;
	private static final Executor exec = Executors.newFixedThreadPool(THREAD_COUNT);

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(9911);
		while (true) {
			final Socket client = server.accept();
			Runnable task = new Runnable() {
				@Override
				public void run() {
					handleReq(client);
				}
			};
			exec.execute(task);
		}
	}

	protected static void handleReq(Socket client) {
		System.out.println("handleReq~~~");
	}
}