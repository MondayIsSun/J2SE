package multi_thread.concurrence.future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BookInstance {
	/**
	 * ��ǰ��ҳ��
	 */
	private volatile int currentPage = 1;

	/**
	 * �첽�������ȡ��ǰҳ������
	 */
	FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
		@Override
		public String call() throws Exception {
			return loadDataFromNet();
		}
	});

	/**
	 * ʵ����һ���飬�����뵱ǰ������ҳ��
	 * 
	 * @param currentPage
	 */
	public BookInstance(int currentPage) {
		this.currentPage = currentPage;
		/**
		 * ֱ�������̻߳�ȡ��ǰҳ������
		 */
		Thread thread = new Thread(futureTask);
		thread.start();
	}

	/**
	 * ��ȡ��ǰҳ������
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public String getCurrentPageContent() throws InterruptedException, ExecutionException {
		String con = futureTask.get();
		this.currentPage = currentPage + 1;
		Thread thread = new Thread(futureTask = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return loadDataFromNet();
			}
		}));
		thread.start();
		return con;
	}

	/**
	 * ����ҳ�������ץȡ����
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	private String loadDataFromNet() throws InterruptedException {
		Thread.sleep(1000);
		return "Page " + this.currentPage + " : the content ....";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BookInstance instance = new BookInstance(1);
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			String content = instance.getCurrentPageContent();
			System.out.println("[1���Ķ�ʱ��]read:" + content);
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis() - start);
		}
	}
}
