package multi_thread.compare_thread_runnable;

class MyThread extends Thread {

	// һ��5�Ż�Ʊ
	private int ticketsCunt = 5;

	// ��3����Ʊ����ͬʱ���۳���5��Ʊ��ʵ���Ͼ���3���߳�����
	// ����ط���name�Ǹ��߳�һ����������Ϊ�������£�
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	// ����Ҫ������5��Ʊ������ֻҪ���ǵ�Ʊ������ > 0�����Ǿ�һֱ����ȥ
	// �����ֹͣ��Ʊ��
	@Override
	public void run() {
		while (ticketsCunt > 0) {
			ticketsCunt--;
			System.out.println(name + "����һ��Ʊ����ʣ���Ʊ��Ϊ��" + ticketsCunt);
		}
	}
}

public class TicketThread {
	
	public static void main(String[] args) {
		
		//���������߳�ģ���������ڽ�����Ʊ
		MyThread mt1 = new MyThread("����1");
		MyThread mt2 = new MyThread("����2");
		MyThread mt3 = new MyThread("����3");
		
		//���������߳�ģ�⿪ʼ��Ʊ
		mt1.start();
		mt2.start();
		mt3.start();
		
		
		
	}

}