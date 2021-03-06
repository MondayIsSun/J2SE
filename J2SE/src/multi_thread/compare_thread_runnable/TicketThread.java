package multi_thread.compare_thread_runnable;

class MyThread extends Thread {

	// 一共5张火车票
	private int ticketsCunt = 5;

	// 有3个售票窗口同时在售出这5张票（实际上就是3个线程啦）
	// 这个地方的name是给线程一个名字啦（为了区分呗）
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	// 我们要卖完这5张票，所以只要我们的票数还是 > 0的我们就一直卖下去
	// 否则就停止售票呗
	@Override
	public void run() {
		while (ticketsCunt > 0) {
			ticketsCunt--;
			System.out.println(name + "卖了一张票，还剩余的票数为：" + ticketsCunt);
		}
	}
}

public class TicketThread {

	public static void main(String[] args) {

		// 创建三个线程模拟三个窗口进行卖票
		MyThread mt1 = new MyThread("窗口1");
		MyThread mt2 = new MyThread("窗口2");
		MyThread mt3 = new MyThread("窗口3");

		// 启动三个线程模拟开始卖票
		mt1.start();
		mt2.start();
		mt3.start();
	}

}
