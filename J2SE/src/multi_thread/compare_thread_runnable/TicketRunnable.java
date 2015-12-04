package multi_thread.compare_thread_runnable;

class MyProcess implements Runnable {

	// һ��5�Ż�Ʊ
	private int ticketsCunt = 5;
	
	// ����Ҫ������5��Ʊ������ֻҪ���ǵ�Ʊ������ > 0�����Ǿ�һֱ����ȥ
	// �����ֹͣ��Ʊ��
	@Override
	public void run() {
		while (ticketsCunt > 0) {
			ticketsCunt--;
			System.out.println(Thread.currentThread().getName() + "����һ��Ʊ����ʣ���Ʊ��Ϊ��" + ticketsCunt);
		}
	}
}

public class TicketRunnable {
	
	public static void main(String[] args) {
		
		MyProcess mt1 = new MyProcess();
		
		//���������߳�ģ���������ڽ�����Ʊ
		Thread t1 = new Thread(mt1,"����1");
		Thread t2 = new Thread(mt1,"����2");
		Thread t3 = new Thread(mt1,"����3");
		
		//���������߳�ģ�⿪ʼ��Ʊ
		t1.start();
		t2.start();
		t3.start();
	}

}