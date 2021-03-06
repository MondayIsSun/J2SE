package multi_thread.compare_thread_runnable;

class MyProcess implements Runnable {

	// 一共5张火车票
	private int ticketsCunt = 5;

	// 我们要卖完这5张票，所以只要我们的票数还是 > 0的我们就一直卖下去
	// 否则就停止售票呗
	@Override
	public void run() {
		while (ticketsCunt > 0) {
			ticketsCunt--;
			System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩余的票数为：" + ticketsCunt);
		}
	}
}

public class TicketRunnable {

	public static void main(String[] args) {

		MyProcess mt1 = new MyProcess();

		// 创建三个线程模拟三个窗口进行卖票
		Thread t1 = new Thread(mt1, "窗口1");
		Thread t2 = new Thread(mt1, "窗口2");
		Thread t3 = new Thread(mt1, "窗口3");

		// 启动三个线程模拟开始卖票
		t1.start();
		t2.start();
		t3.start();
	}
}
