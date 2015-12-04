package test;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public enum IcPlayerID {

		DEFAULT("Ĭ��ֵ", -1), // û��ͨ��DebugUtilsActivity�ı�Module��Ĭ��Module
		HDKT("��������Module", 0), // ͨ��DebugUtilsActivityʹ�û�������Module
		XUEKE("ѧ��Module", 1), // ͨ��DebugUtilsActivityʹ��ѧ��Module
		XIAMEN("����Module", 2);// ͨ��DebugUtilsActivityʹ������Module

		private String module;
		private int sp_id;

		IcPlayerID(String module, int sp_id) {
			this.module = module;
			this.sp_id = sp_id;
			// 201509210001
		}
	}

	public static String modifyOneDigitSeatNum(String seatNum) {
		if (seatNum.matches("^[0-9]*$")) {
			if (seatNum.matches("^\\d$")) {
				seatNum = "0" + seatNum;
			}
		} else {
			System.out.print("NaN");
		}
		return seatNum;
	}

	public static void main(String[] args) {
		// System.out.println(IcPlayerID.DEFAULT.module + " = " +
		// IcPlayerID.DEFAULT.sp_id);
		// System.out.println(modifyOneDigitSeatNum("12345t"));
		// System.out.println(modifyOneDigitSeatNum("09287462"));
		// System.out.println(modifyOneDigitSeatNum("1"));
		// System.out.println(modifyOneDigitSeatNum("2"));
		// System.out.println(modifyOneDigitSeatNum("32"));
		// System.out.println(modifyOneDigitSeatNum("2124"));
		// System.out.println(modifyOneDigitSeatNum("124g566"));

		// for (int i = 0; i < 10000; i++) {
		// //System.out.println((Math.random()));
		// System.out.println((int)(Math.random()*1));
		// }

		// LinkedList<String> mTaskQueue = new LinkedList<>();
		// mTaskQueue.add("test");
		// System.out.println(mTaskQueue.removeFirst());

		// java�ź�������
		ExecutorService exec = Executors.newCachedThreadPool();// �̳߳�
		final Semaphore semp = new Semaphore(5);// ֻ��5���߳�ͬʱ����

		for (int index = 0; index < 20; index++) {// ģ��20���ͻ��˷���
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						semp.acquire();// ��ȡ���
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						semp.release();// ��������ͷ�
						System.out.println("-----------------" + semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		// �˳��̳߳�
		exec.shutdown();
	}
}
