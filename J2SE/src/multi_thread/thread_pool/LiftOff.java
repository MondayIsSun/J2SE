package multi_thread.thread_pool;

public class LiftOff implements Runnable {

	private static int taskCount = 0;
	private final int id = taskCount++;

	private int countDown = 10;// default

	private String status() {
		return (countDown > 0 ? "(" + countDown + "), " : "(LiftOff)\r\n");
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print("#" + id + status());
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new LiftOff());
		t1.start();

		Thread t2 = new Thread(new LiftOff());
		t2.start();
	}

}
