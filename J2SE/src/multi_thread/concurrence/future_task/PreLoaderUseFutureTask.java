package multi_thread.concurrence.future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask
 * �е�����Runnable��������ͨ��Thread������������FutureTask���Է���ִ����ϵ����ݣ�����FutureTask��get����֧��������
 * 
 * ���ڣ�FutureTask���Է���ִ����ϵ����ݣ�����FutureTask��get����֧���������������ԣ����ǿ�������Ԥ�ȼ���һЩ�����õ���Դ��
 * Ȼ��Ҫ�õ�ʱ�򣬵���get������ȡ�������Դ�����ֱ꣬�ӷ��أ���������ȴ��������ɣ���
 * 
 * @author Administrator
 *
 */
public class PreLoaderUseFutureTask {

	/**
	 * ����һ��FutureTask����������Դ
	 */
	private final FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return "������Դ��Ҫ3��";
		}
	});

	public final Thread thread = new Thread(futureTask);

	public void start() {
		thread.start();
	}

	/**
	 * ��ȡ��Դ
	 * 
	 * @return
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public String getRes() throws InterruptedException, ExecutionException {
		return futureTask.get();// �������ֱ�ӷ��أ�����ȴ��������

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		PreLoaderUseFutureTask task = new PreLoaderUseFutureTask();
		/**
		 * ����Ԥ������Դ
		 */
		task.start();
		// �û���������Ҫ������Դǰ����������������2��
		Thread.sleep(2000);

		/**
		 * ��ȡ��Դ
		 */
		System.out.println(System.currentTimeMillis() + "����ʼ������Դ");
		String res = task.getRes();
		System.out.println(res);
		System.out.println(System.currentTimeMillis() + "��������Դ����");
	}
}